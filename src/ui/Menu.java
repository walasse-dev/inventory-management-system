package ui;

import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    public void menu() {
        while(true) {
            mainMenu();
            int option = Integer.parseInt(sc.nextLine());
            switch(option) {
                case 0:
                    return;
                case 1:
                    productMenu();
                    break;
                case 2:
                    break;
                case 3:
                    newOrder();
                    char option2 = sc.nextLine().toUpperCase().charAt(0);
                    if(option2 == 'N') {

                    }
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\n[ERROR] Invalid option. Please try again.");
            }
        }
    }

    public void mainMenu() {
        System.out.print("""
                ========== INVENTORY MANAGEMENT SYSTEM ==========
                
                1 - Manage products
                2 - Manage customers
                3 - Create order
                4 - Manage orders
                5 - Reports
                0 - Exit
                
                Select an option:\s""");
    }

    public void productMenu() {
        System.out.println("""
                ========== PRODUCT MANAGEMENT ==========
                
                1 - Register product
                2 - List products
                3 - Search product
                4 - Update product
                5 - Remove product
                6 - Add quantity
                7 - Remove quantity
                8 - List low quantity products
                0 - Back
                
                Select an option:\s""");
    }

    public void newProduct() {
        System.out.println("========== REGISTER PRODUCT ==========");
        System.out.print("Product ID: ");
        Long id = Long.parseLong(sc.nextLine());
        System.out.print("Product Name: ");
        String name = sc.nextLine();

        System.out.print("\nProduct ID: ");
        Long productID = Long.parseLong(sc.nextLine());
        System.out.print("Product: ");
        String product = sc.nextLine();
        System.out.print("Product price: ");
        BigDecimal price = new BigDecimal(sc.nextLine());
        System.out.print("Initial quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());
    }


    public void newOrder() {
        System.out.println("========== NEW ORDER ==========");
        System.out.print("Client ID: ");
        Long id = Long.parseLong(sc.nextLine());
        System.out.print("Client: ");
        String name = sc.nextLine();

        System.out.print("\nProduct ID: ");
        Long productID = Long.parseLong(sc.nextLine());
        System.out.print("Product: ");
        String product = sc.nextLine();
        System.out.print("Price: ");
        BigDecimal price = new BigDecimal(sc.nextLine());
        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());

        System.out.print("\nAdd another product? (Y/N): ");
    }
}
