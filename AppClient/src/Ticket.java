import java.util.ArrayList;

public class Ticket {

    private Flight vuelo;
    private int total;
    private int clientDNI;
    private int quantity;
    private int stops;
    String temp;

    public Ticket(Flight vuelo, String temp, int client, int quantity) {
        this.vuelo = vuelo;
        this.temp = temp;
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
        System.out.println("Seat: " + temp);

        System.out.println("\n");

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