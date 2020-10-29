import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] fractions;


    public PercolationStats(int n, int trials){

        if((n <= 0) || (trials <= 0)){
            throw new IllegalArgumentException();
        }

        fractions = new double[trials];


        for (int i = 0; i < trials; i++) {
            int count = 0;
            Percolation perc = new Percolation(n);
            while (!perc.percolates()) {
                int rowIndex = StdRandom.uniform(n);
                int colIndex = StdRandom.uniform(n);
                int row = rowIndex + 1;
                int col = colIndex + 1;
                if(perc.isOpen(row, col)){
                    continue;
                }
                perc.open(row, col);
                count++;
            }
            double frac = ((double) count)/(n*n);
            fractions[i] = frac;
        }
    }


    public double mean(){
        return StdStats.mean(fractions);
    }

    public double stddev(){
        return StdStats.stddev(fractions);
    }

    public double confidenceLo(){
        return mean() - (1.96*stddev()/Math.sqrt(fractions.length));
    }

    public double confidenceHi(){
        return mean() + (1.96*stddev()/Math.sqrt(fractions.length));
    }

    public static void main(String[] args) {

       PercolationStats percStat = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        StdOut.println("mean = " + percStat.mean());
        StdOut.println("stddev = " + percStat.stddev());
        StdOut.println("95% confidence interval = " + "[" + percStat.confidenceLo() + ", " + percStat.confidenceHi() + "]");
    }
}
