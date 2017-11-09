import java.util.ArrayList;
import java.util.Random;

public class Ticket {

    Random r = new Random();

    private Flight vuelo;
    private int total;
    private int clientDNI;
    private int quantity;
    private int stops;
    String seat;

    int numero = r.nextInt(99999);
    int numeroTicket = numero;

    public Ticket(Flight vuelo, String seat, int client, int quantity) {
        this.vuelo = vuelo;
        this.seat = seat;
        this.clientDNI = client;
        this.quantity = quantity;
        this.numero = numero;
    }

    public int getNumero() {
        return numeroTicket;
    }

    public Flight getVuelo() {
        return vuelo;
    }

    public String getSeat() {
        return seat;
    }

    public void print(){
        System.out.println("+--------------------------------------------+");
        System.out.println("               Ticket  " + numeroTicket);
        System.out.println("+--------------------------------------------+");
        System.out.println("Client: " + clientDNI);
        System.out.println("Flight: " + vuelo.getCode());
        System.out.println("From: " + vuelo.getAirportFrom().getlocation());
        System.out.println("To: " + vuelo.getAirportTo().getlocation());
        System.out.println("Seat: " + seat);

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