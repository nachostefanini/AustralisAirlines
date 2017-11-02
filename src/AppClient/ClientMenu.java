package AppClient;
import Scanner.Scanner;

public class ClientMenu {
    public static void main(String[] args) {

        while(true){
            System.out.println("+--------------------------------------------+");
            System.out.println("              Australis Airlines              ");
            System.out.println("                  Admin app                   ");
            System.out.println("+--------------------------------------------+");
            System.out.println("Operation: ");
            System.out.println("1. Buy AppClient.Ticket: ");
            System.out.println("2. Cancel AppClient.Ticket: ");
            System.out.println("3. View my reserve: ");
            System.out.println("4. Exit: ");
            int opc = Scanner.getInt("What operation do you want to do: ");
            System.out.println("\t");

            switch(opc){
                /*
                This method permite al usuario comprar un ticket.
                Comprar un ticket implica las siguientes cosas:
                    * Tiene que estar creado el vuelo en el API Server
                    * Tiene que devolver los asientos disponibles
                 */
                case 1:
                    System.out.flush();
                    // TODO Implement
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
