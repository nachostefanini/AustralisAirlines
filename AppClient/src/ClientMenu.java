public class ClientMenu {

    public  static void main(String[] args) {

        Server Server = new Server();


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
                case 1:

                    String from = Scanner.getString("From: ");
                    String to = Scanner.getString("To: ");
                    int quantity = Scanner.getInt("Quantity: ");
//                    int stops = Scanner.getInt("Stops: ");

                    //Priemr paso, busco flights
//                    System.out.println(" ------------- Flight finder------------- ");

                    String[] data = new String[2];
                    data[0] = from;
                    data[1] = to;

                    Server.find(data);

                    //2 Le pido q ingrese el flight q quiere comprar
                    String flight = Scanner.getString("Insert the Flight you want: ");

                    //Habria q validarlo

                    Server.startPurchase(flight,quantity);

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
