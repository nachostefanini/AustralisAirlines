package AppClient;
import AppAdmin.*;
import Scanner.Scanner;

public class ClientMenu {

    static Apifake api = new Apifake();

    public static void main(String[] args) {
        while(true){
            System.out.println("+--------------------------------------------+");
            System.out.println("              Australis Airlines              ");
            System.out.println("                  Admin app                   ");
            System.out.println("+--------------------------------------------+");
            System.out.println("Operation: ");
            System.out.println("1. Buy Ticket: ");
            System.out.println("2. Cancel Ticket: ");
            System.out.println("3. View my Tickets: ");
            System.out.println("4. Exit: ");
            int opc = Scanner.getInt("What operation do you want to do: ");
            System.out.println("\t");

            switch(opc){
                case 1:
                    System.out.flush();
                    String from = Scanner.getString("please enter an origin airport");
                    String to = Scanner.getString("please enter a destiny airport");
                    /*
                    fecha salida = Scanner.getfecha;
                    fecha llegada = Scanner.getfecha;
                     */
                    int quantity = Scanner.getInt("please enter the cuantity of pasengers");
                    String code = Scanner.getString("please enter the code of client");
                    //int stops = Scanner.getInt("please enter the maximum cuantity of stops");
                    /*
                    categoría implementar;
                    se tiene que poder ordenar por precio, escalas y duración.
                     */
//                    api.searchflight(from,to,quantity,code);
                    System.out.println();
                    break;
                case 2:
                    System.out.flush();

                    System.out.println();
                    break;
                case 3:
                    System.out.flush();

                    System.out.println();
                    break;
                case 4:
                    System.out.println("Thank you for using the Clients App");
                    System.exit(0);
                    break;
                default:
                    System.out.flush();
                    System.out.println("Please, insert a correct character: ");
                    break;
            }
        }
    }
}
