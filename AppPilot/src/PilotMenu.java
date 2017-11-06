public class PilotMenu {
    public static void main(String[] args) {
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
                    System.out.println();
                    break;
                case 2:
                    System.out.flush();
                    System.out.println();
                    break;
                case 3:
                    System.out.flush();
                    System.out.println("Thank for use this App!");
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
