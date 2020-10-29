package academy.learnprogramming;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Branch> branches = new ArrayList<>();


    public void printBranches(){
        for (int i = 0; i < branches.size(); i++){
            System.out.println(branches.get(i).getName());
        }
    }

    public int addNewBranch(String branchName){
        int position = findBranch(branchName);
        Branch branch = new Branch(branchName);
        if(position < 0){
            branches.add(branch);
            return 1;
        }

        return -1;
    }

    public int addNewTransaction(String branchName, String customerName, double transaction){
        int branchPosition = findBranch(branchName);
        if(branchPosition >= 0){
            int customerPosition = branches.get(branchPosition).findCustomer(customerName);
            if(customerPosition >= 0){
                branches.get(branchPosition).addTransaction(customerName, transaction);
            } else {
                return -2;
            }
        }

        return -1;
    }


    public void addCustomerToBranch(String branchName, String customerName, double initTransaction){
        int branchPosition = findBranch(branchName);
        branches.get(branchPosition).addCustomer(customerName, initTransaction);
    }

    public int showCustomersInBranch(String branchName){
        int position = findBranch(branchName);
        if(position >= 0) {
            branches.get(position).showCustomers();
           return 1;
        } else
            return -1;
    }

    public int findBranch(String branchName){
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);
            if (branchName.equals(branch.getName())) {
                return i;
            }
        }
        return -1;

    }

    public int findCustomerInBranchToAdd(String branchName, String customerName){
        int branchPosition = findBranch(branchName);
        if(branchPosition < 0){
            return -1;
        } else {
            int customerPosition = branches.get(branchPosition).findCustomer(customerName);
            if(customerPosition >= 0){
                return -2;
            } else {
                return 1;
            }
        }
    }




}