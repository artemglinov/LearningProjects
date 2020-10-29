import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int len;
    private Site[][] sites;
    private Site virtualTop;
    private Site virtualBottom;
    private WeightedQuickUnionUF uf;

    public static void main(String[] args) {
        int n = 3;
        Percolation perc = new Percolation(n);
//        for (int j = 1; j <= n; j++){
//            perc.open(j, 2);
//        }
//
//        perc.open(10, 4);
//        System.out.println(perc.isFull(10, 4));
//        System.out.println(perc.numberOfOpenSites());
//        System.out.println(perc.percolates());

        perc.open(1,1);
        perc.open(2,1);
        perc.open(3,1);
        perc.open(1,2);
        perc.open(3,3);
        perc.open(2,3);
        StdOut.println(perc.isFull(2,3));
    }

    public Percolation(int n){
        if(n <= 0){
            throw new IllegalArgumentException();
        }

        uf = new WeightedQuickUnionUF(n*n + 2);

        virtualTop = new Site(true, 0);
        virtualBottom = new Site(true, n*n + 1);

        len = n;

        sites = new Site[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                sites[i][j] = new Site(false, i*n + j + 1);
            }
        }



//        sites = new Site[n*n];
    }



    public void open(int row, int col){

        if((row < 1) || (row > len) || (col < 1) || (col > len)){
            throw new IllegalArgumentException();
        }

        int rowIndex = row - 1;
        int colIndex = col - 1;

        Site site = sites[rowIndex][colIndex];
        site.isOpen = true;


        if(rowIndex == 0){
            uf.union(site.id, virtualTop.id);

            if(rowIndex == len - 1){
                uf.union(site.id, virtualBottom.id);
            }
        }

        if(rowIndex != 0){
            if(isOpen(row-1, col)) {
                uf.union(uf.find(site.id), sites[rowIndex - 1][colIndex].id);

//                if((rowIndex == len - 1) && (uf.find(sites[rowIndex - 1][colIndex].id) == uf.find(virtualTop.id))){
//                    uf.union(site.id, virtualBottom.id);
//                }
            }
        }

        if((rowIndex != (len - 1))){
            if(isOpen(row+1, col)) {
                uf.union(site.id, sites[rowIndex + 1][colIndex].id);
            }
        }

        if((colIndex != 0)){
            if(isOpen(row, col - 1)) {
                uf.union(site.id, sites[rowIndex][colIndex - 1].id);

//                if((rowIndex == len - 1) && (uf.find(sites[rowIndex][colIndex - 1].id) == uf.find(virtualTop.id))){
//                    uf.union(site.id, virtualBottom.id);
//                }
            }
        }

        if((colIndex != (len - 1))){
            if(isOpen(row, col + 1)) {
                uf.union(site.id, sites[rowIndex][colIndex + 1].id);

//                if((rowIndex == len - 1) && (uf.find(sites[rowIndex][colIndex + 1].id) == uf.find(virtualTop.id))){
//                    uf.union(site.id, virtualBottom.id);
//                 }
            }
        }

        if(rowIndex == len -1){
            uf.union(site.id, virtualBottom.id);
        }

//        if(rowIndex == len - 1){
//            if((uf.find(sites[rowIndex][colIndex + 1].id) == uf.find(virtualTop.id))
//                    || (sites[rowIndex][colIndex - 1].id == virtualTop.id)
//                    || (sites[rowIndex - 1][colIndex].id == virtualTop.id)) {
//                uf.union(site.id, virtualBottom.id);
//            }
//        }

//        if(rowIndex == len -1){
//            uf.union(site.id, virtualBottom.id);
//        }
    }

    public boolean isOpen(int row, int col){
        if((row < 1) || (row > len) || (col < 1) || (col > len)){
            throw new IllegalArgumentException();
        }
        return sites[--row][--col].isOpen;
    }

    public boolean isFull(int row, int col){
        if((row < 1) || (row > len) || (col < 1) || (col > len)){
            throw new IllegalArgumentException();
        }

        Site site = sites[row - 1][col - 1];

        int rowIndex = row - 1;
        int colIndex = col - 1;

        if(!site.isOpen){
            return false;
        }

        if(colIndex != 0){
            if(uf.find(sites[rowIndex][colIndex - 1].id) == uf.find(virtualTop.id)){
                return true;
            }
        }

        if(colIndex != len - 1){
            if(uf.find(sites[rowIndex][colIndex + 1].id) == uf.find(virtualTop.id)){
                return true;
            }
        }

        if(rowIndex != 0){
            if(uf.find(sites[rowIndex - 1][colIndex].id) == uf.find(virtualTop.id)){
                return true;
            }
        } else {
            return true;
        }

        if(rowIndex != len - 1){
            if(uf.find(sites[rowIndex + 1][colIndex].id) == uf.find(virtualTop.id)){
                return true;
            }
        }

        return false;

    }

    public int numberOfOpenSites(){
        int count = 0;

        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                if(sites[i][j].isOpen){
                    count++;
                }
            }
        }

        return count;
    }

    public boolean percolates(){
//        for (int i = 0; i < len; i++) {
//            if(sites[len - 1][i].isOpen) {
//                uf.union(sites[len - 1][i].id, virtualBottom.id);
//            }
//        }
        return uf.find(virtualTop.id) == uf.find(virtualBottom.id);
    }


//    private Site root(Site site){
//        while (!site.parent.equals(site)){
//            site = site.parent;
//        }
//        return site;
//    }

//    private boolean connected(Site site1, Site site2){
//        return root(site1) == root(site2);
//    }

//    private void union(Site site1, Site site2){
//        if((!site1.isOpen) || (!site2.isOpen)){
//            return;
//        }
//
//        Site root1 = root(site1);
//        Site root2 = root(site2);
//
//        if(root1.equals(root2)){
//            return;
//        } else {
//            if(root1.sz < root2.sz){
//                root1.parent = root2;
//                root2.sz += root1.sz;
//            } else {
//                root2.parent = root1;
//                root1.sz += root2.sz;
//            }
//        }
//    }

    private class Site{

//        int sz;
//        Site parent;
        int id;
        boolean isOpen;

        Site(boolean isOpen, int id) {
            this.isOpen = isOpen;
            this.id = id;
//            parent = this;
//            sz = 1;
        }

    }
}
