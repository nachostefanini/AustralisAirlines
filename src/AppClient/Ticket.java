package AppClient;

import java.util.ArrayList;

public class Ticket {

    //the list with the airports needs to be in the server?
    ArrayList<String> listOfAirports;

    private String from;
    private String to;
    private int clientDNI;
    private int quantity;
    private int stops;

    public Ticket(String from, String to, int client, int quantity, int stops) {

        // Checks if the airport exists
        for (String x: listOfAirports) {
            if (from.equalsIgnoreCase(x)){
                this.from = from;
            }else {
                throw new RuntimeException("The airport you selected does not exist.");
            }
        }

        for (String x: listOfAirports) {
            if (to.equalsIgnoreCase(x)){
                this.to = to;
            }else {
                throw new RuntimeException("The airport you selected does not exist.");
            }
        }
        this.clientDNI = client;
        this.quantity = quantity;
        this.stops = stops;
    }

    public void print(){
        System.out.println("+--------------------------------------------+");
        System.out.println("                    AppClient.Ticket                    ");
        System.out.println("+--------------------------------------------+");
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Client: " + clientDNI);
        System.out.println("Quantity: " + quantity);
        System.out.println("Stops: " + stops);
    }


}
