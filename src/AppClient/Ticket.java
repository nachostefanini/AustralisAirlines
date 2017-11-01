package AppClient;
import java.util.ArrayList;

public class Ticket {

    private String from;
    private String to;
    private int clientDNI;
    private int quantity;
    /*
    private int stops;
    fecha salida = Scanner.getfecha;
    fecha llegada = Scanner.getfecha;
    */

    public Ticket(String from, String to, int client, int quantity) {
        this.clientDNI = client;
        this.quantity = quantity;
        this.from = from;
        this.to = to;
    }

    public void print(){
        System.out.println("+--------------------------------------------+");
        System.out.println("                    Ticket                    ");
        System.out.println("+--------------------------------------------+");
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Client: " + clientDNI);
        System.out.println("Quantity: " + quantity);
    }


}
