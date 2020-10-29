package com.timbuchalka;

public class MainChallenge {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {


        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for (String s : stockList.Items().keySet()){
            System.out.println(s);
        }

        Basket timsBasket = new Basket("Tim");
        reserveItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        reserveItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        if(reserveItem(timsBasket, "car", 1) != 1){
            System.out.println("There are no more cars in stock");
        }

        reserveItem(timsBasket, "spanner", 5);
        System.out.println(timsBasket);

        reserveItem(timsBasket, "juice", 4);
        reserveItem(timsBasket, "cup", 12);
        System.out.println(timsBasket);

//        reserveItem(timsBasket, "cup", 4000);
//        System.out.println(timsBasket);


        reserveItem(timsBasket, "bread", 1);
        System.out.println(timsBasket);

        timsBasket.checkOut();

        System.out.println(timsBasket);

        System.out.println(stockList);

//        temp = new StockItem("pen", 1.12);
//        stockList.Items().put(temp.getName(), temp);
    }

    public static int reserveItem(Basket basket, String item, int quantity){
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }

        if(stockList.reserveStock(item, quantity) != 0) {
            if(basket.addToBasket(stockItem, quantity) != 0){
                return quantity;
            } else {
                System.out.println("There is not " + item + " in the basket.");
            }

        } else {
            System.out.println("Reserved stock is greater than available");
        }

        return 0;
    }

    public static int unreserveItem(Basket basket, String item, int quantity){
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }

        int flag = stockList.unreserveStock(item, quantity);
        if(flag == -1){
            System.out.println(item + "'s stock is not reserved");
        } else if(flag == 0){
            System.out.println("Unreserved stock is greater than reserved");
        } else {
            if(basket.removeFromBasket(stockItem, quantity) != 0) {
                return quantity;
            } else {
                System.out.println("There is not " + item + " in the basket.");
            }
        }

        return 0;
    }




}
