package AppClient;
import Scanner.Scanner;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Menu {
    boolean exit = false;
    boolean exitBook = false;
    int id = 0;
    int choice = -1;


    public void printHeader(){
        System.out.println("+--------------------------------------------+");
        System.out.println("              Australis Airlines              ");
        System.out.println("                  Clients app                 ");
        System.out.println("+--------------------------------------------+");
    }

    public void printIdMenu(){
        System.out.println("\n Please insert your ID: ");
    }


    public void runMenu(){
        printHeader();
        printIdMenu();
        id = Scanner.getInt("\t");
        // TODO: validate the id to the client...
        System.out.println("Welcome back " + id);

        printMenu();

        while (!exit) {
            choice = Scanner.getInt("");
            performActionMenu(choice);
        }
    }

    public void printMenu(){
        System.out.println("\n Please select an option: ");
        System.out.println("1) Book a flight");
        System.out.println("2) My reservations");
        System.out.println("0) Exit");
    }



    public void performActionMenu(int choice) {

        if (choice >= 0 && choice <= 2) {
            switch (choice) {
                case 0:
                    System.out.println("Thank you for using the Clients app");
                    exit = true;
                    break;
                case 1:
                    System.out.println("option 1");
                    // TODO: implement method that searches for the itinerary and returns it...
                    printBook();
                    break;
                case 2:
                    System.out.println("option 2");
                    // TODO: search for the clients reservations and return them...
                    break;
                default:
                    System.out.println("Unknown error ocurred");
                    break;
            }
        }else {
            System.out.println("Please insert a valid number");
        }
    }

    public void printBook(){
        String from = Scanner.getString("From: ");
        String to = Scanner.getString("To: ");
        int quantity = Scanner.getInt("Quantity: ");
        int stops = Scanner.getInt("Stops: ");

        System.out.println("Sort by: ");
        System.out.println("1) Price");
        System.out.println("2) Stops");
        System.out.println("3) Duration");
        System.out.println("0) All");

        int choiceBook = Scanner.getInt("");
        performActionBook(choiceBook);
        System.out.println("\n Info: \n ");

    }

    public void performActionBook(int choice){
        if (choice>=0 && choice<=3){
        switch (choice){
            case 0:
                System.out.println("All");
                // TODO: Show all flights
                break;
            case 1:
                System.out.println("Sort by price");
                // TODO: Sort flights by price
                break;
            case 2:
                System.out.println("Sort by stops");
                // TODO: Sort flights by stops;
                break;
            case 3:
                System.out.println("Sort by duration");
                // TODO: Sort flights by duration
                break;
            }
        }else {
            System.out.println("Insert a valid number");
        }
    }

    public void from(int choice){
        switch (choice){
            case 0:
                System.out.println("?");
            case 1:

        }

    }
}
