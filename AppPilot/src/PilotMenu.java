import java.util.ArrayList;

public class PilotMenu {
    public static void main(String[] args) {
        ServerMOCK server = new ServerMOCK();
        while (true) {
            System.out.println("+--------------------------------------------+");
            System.out.println("              Australis Airlines              ");
            System.out.println("                  AppAdmin.Pilot app                   ");
            System.out.println("+--------------------------------------------+");
            System.out.println();
            System.out.println("Operation: ");
            System.out.println("1. View Itinerary");
            System.out.println("2. Exit: ");
            System.out.println();
            System.out.println("+--------------------------------------------+");
            System.out.println("              Australis Airlines              ");
            System.out.println("                  AppAdmin.Pilot app                   ");
            System.out.println("+--------------------------------------------+");
            int opc = Scanner.getInt("What operation do you want to do: ");
            System.out.println("\t");

            switch (opc) {
                case 1:
                    System.out.flush();
                    String id = Scanner.getString("Please insert your ID");
                    ArrayList<String> flightOfPilots = server.printFlight(id);
                    for (int i = 0; i < flightOfPilots.size() ; i++) {
                        System.out.println("Flight assignated: " + flightOfPilots.get(i));
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.flush();
                    System.out.println("Thank you for using this App");
                    System.exit(0);
                    System.out.println();
                    break;
                default:
                    System.out.flush();
                    System.out.println("Please, insert a correct character: ");
                    break;
            }
        }
    }
}
