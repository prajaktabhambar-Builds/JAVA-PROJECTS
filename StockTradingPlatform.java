import java.util.ArrayList;
import java.util.Scanner;

class Stock
 {
    String symbol;
    double price;

    Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
}

class Transaction {
    String type;
    String stockSymbol;
    int quantity;
    double price;

    Transaction(String type, String stockSymbol, int quantity, double price) {
        this.type = type;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
    }
}


class User {
    String name;
    double balance;
    ArrayList<Transaction> portfolio = new ArrayList<>();

    User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void buyStock(Stock stock, int quantity) {
        double cost = stock.price * quantity;

        if (balance >= cost) {
            balance -= cost;
            portfolio.add(new Transaction("BUY", stock.symbol, quantity, stock.price));
            System.out.println("Stock bought successfully!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void sellStock(Stock stock, int quantity) {
        balance += stock.price * quantity;
        portfolio.add(new Transaction("SELL", stock.symbol, quantity, stock.price));
        System.out.println("Stock sold successfully!");
    }

    void showPortfolio() {
        System.out.println("\n--- Portfolio Summary ---");
        for (Transaction t : portfolio) {
            System.out.println(t.type + " | " + t.stockSymbol +" | Qty: " + t.quantity + " | Price: " + t.price);
        }
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
       
        Stock s1 = new Stock("TCS", 3500);
        Stock s2 = new Stock("INFY", 1500);
        Stock s3 = new Stock("RELIANCE", 2500);

      
        System.out.print("Enter user name: ");
        String name = sc.nextLine();
        User user = new User(name, 10000);

        int choice;
        do {
            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Market Data ---");
                    System.out.println("1. TCS - ₹3500");
                    System.out.println("2. INFY - ₹1500");
                    System.out.println("3. RELIANCE - ₹2500");
                    break;

                case 2:
                    System.out.print("Select stock (1-3): ");
                    int buyChoice = sc.nextInt();
                    System.out.print("Enter quantity: ");
                    int buyQty = sc.nextInt();

                    if (buyChoice == 1) user.buyStock(s1, buyQty);
                    else if (buyChoice == 2) user.buyStock(s2, buyQty);
                    else if (buyChoice == 3) user.buyStock(s3, buyQty);
                    break;

                case 3:
                    System.out.print("Select stock (1-3): ");
                    int sellChoice = sc.nextInt();
                    System.out.print("Enter quantity: ");
                    int sellQty = sc.nextInt();

                    if (sellChoice == 1) user.sellStock(s1, sellQty);
                    else if (sellChoice == 2) user.sellStock(s2, sellQty);
                    else if (sellChoice == 3) user.sellStock(s3, sellQty);
                    break;

                case 4:
                    user.showPortfolio();
                    break;

                case 5:
                    System.out.println("Thank you for trading!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}