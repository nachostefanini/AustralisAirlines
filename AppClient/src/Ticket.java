import java.util.ArrayList;

public class Ticket {

    private Flight vuelo;
    private int total;
    private String clientDNI;
    private int quantity;
    private int stops;

    public Ticket(Flight vuelo, int total, String client, int quantity) {
        this.vuelo = vuelo;
        this.total = total;
        this.clientDNI = client;
        this.quantity = quantity;

    }

    public void print(){
        System.out.println("+--------------------------------------------+");
        System.out.println("                    Ticket                    ");
        System.out.println("+--------------------------------------------+");
        System.out.println("Client: " + clientDNI);
        System.out.println("Flight: " + vuelo.getCode());
        System.out.println("From: " + vuelo.getAirportFrom().getlocation());
        System.out.println("To: " + vuelo.getAirportTo().getlocation());
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: $" +total);
    }


}

// Checks if the airport exists
//        for (String x: listOfAirports) {
//            if (from.equalsIgnoreCase(x)){
//                this.from = from;
//            }else {
//                throw new RuntimeException("The airport you selected does not exist.");
//            }
//        }
//
//        for (String x: listOfAirports) {
//            if (to.equalsIgnoreCase(x)){
//                this.to = to;
//            }else {
//                throw new RuntimeException("The airport you selected does not exist.");
//            }
//        }