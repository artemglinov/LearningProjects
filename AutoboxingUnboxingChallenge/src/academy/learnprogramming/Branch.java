package academy.learnprogramming;

import java.util.ArrayList;

public class Branch {

    private String name;

    private ArrayList<Customer> branchCustomers = new ArrayList<>();

    public Branch(String name) {
        this.name = name;
    }

    public void addCustomer(String name, double initTransaction){
            ArrayList<Double> transactions = new ArrayList<Double>();
            transactions.add(initTransaction);
            addCustomer(new Customer(name, transactions));
    }

    private void addCustomer(Customer customer){
        branchCustomers.add(customer);
    }

    public void addTransaction(String customerName, double newTransaction) {
            int position = findCustomer(customerName);
            ArrayList<Double> customerTransactions = branchCustomers.get(position).getTransactions();
            customerTransactions.add(newTransaction);
            branchCustomers.get(position).setTransactions(customerTransactions);

            //debugging
        for(int i = 0; i < customerTransactions.size(); i++){
            System.out.println(customerTransactions.get(i));
        }
    }

    public void showCustomers(){
        System.out.println("Customers of the branch " + name + " are: \n");
        for (int i = 0; i < branchCustomers.size(); i++) {
            System.out.println(branchCustomers.get(i).getName());
        }
    }

    public String getName() {
        return name;
    }

    public int findCustomer(String customerName) {

        for (int i = 0; i < branchCustomers.size(); i++) {
            Customer customer = branchCustomers.get(i);
            if (customerName.equals(customer.getName())) {
                return i;
            }
        }
        return -1;
    }
}
