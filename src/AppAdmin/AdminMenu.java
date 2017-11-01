package AppAdmin;
import Scanner.Scanner;

public class AdminMenu {
    static Apifake api = new Apifake();
    public static void main(String[] args) {
        while (true) {
            System.out.println("+--------------------------------------------+");
            System.out.println("              Australis Airlines              ");
            System.out.println("                  Admin app                   ");
            System.out.println("+--------------------------------------------+");
            System.out.println("Operation: ");
            System.out.println("1. Add Pilot: ");
            System.out.println("2. Quit Pilot: ");
            System.out.println("3. Show Pilots list");
            System.out.println("4. Add Airplane: ");
            System.out.println("5. Quit Airplane: ");
            System.out.println("6. Show Airplanes list");
            System.out.println("7. Add Airport: ");
            System.out.println("8. Quit Airport: ");
            System.out.println("9. Show Airports list");
            System.out.println("10. Add Flight");
            System.out.println("11. Quit Flight");
            System.out.println("12. Show Flights list");
            System.out.println("13. Exit: ");
            System.out.println();
            int opc = Scanner.getInt("What operation do you want to do: ");
            System.out.println("\t");

            switch (opc) {
                case 1:
                    System.out.flush();
                    String name = Scanner.getString("Enter the name of the pilot: ");
                    String surname = Scanner.getString("Enter the surname of the pilot: ");
                    String dni = Scanner.getString("Enter the DNI of the pilot");
                    Pilot newPilot = new Pilot(name, surname, dni);
                    api.addpilot(newPilot);
                    break;
                case 2:
                    System.out.flush();
                    dni = Scanner.getString("Enter the DNI of the pilot you want to remove");
                    api.quitpilot(dni);
                    System.out.println();
                    break;
                case 3:
                    System.out.flush();
                    api.printpilots();
                    System.out.println();
                    break;
                case 4:
                    System.out.flush();
                    String code = Scanner.getString("Please enter the code of the airplane: ");
                    int rows = Scanner.getInt("Please enter the number of rows of seats: ");
                    int columns = Scanner.getInt("Please enter the number of columns of seats: ");
                    SeatMap seats = new SeatMap(rows, columns);
                    Airplane newairplane = new Airplane(seats, code);
                    api.addairplane(newairplane);
                    break;
                case 5:
                    System.out.flush();
                    code = Scanner.getString("Please enter the code of the airplane you want to quit ");
                    api.quitairplane(code);
                    System.out.println();
                    break;
                case 6:
                    System.out.flush();
                    api.printairplanes();
                    System.out.println();
                    break;
                case 7:
                    System.out.flush();
                    String airportcode = Scanner.getString("Please enter the code of the airport: ");
                    String location = Scanner.getString("Please enter the location of the airport");
                    Airport newairport = new Airport(airportcode, location);
                    api.addairport(newairport);
                    System.out.println();
                    break;
                case 8:
                    System.out.flush();
                    airportcode = Scanner.getString("Please enter the code of the airport you want to quit ");
                    api.quitairport(airportcode);
                    System.out.println();
                    break;
                case 9:
                    System.out.flush();
                    api.printairports();
                    System.out.println();
                    break;
                case 10:
                    String airportcodefrom = Scanner.getString("Please enter the country of origin: ");
                    Airport airportFrom = api.getairportFrom(airportcodefrom);
                    String airportcodeto = Scanner.getString("Please enter the country of destination: ");
                    Airport airportTo = api.getairportTo(airportcodeto);
                    String airplanecode = Scanner.getString("Please enter the code of the airplane you want to asign ");
                    Airplane airplane = api.getairplane(airplanecode);
                    dni = Scanner.getString("Please enter the dni of the pilot you want to asign");
                    Pilot pilot = api.getpilot(dni);
                    code = Scanner.getString("please enter a flight code");
                    Flight flight = new Flight(airportcodefrom, airportcodeto, airplane, code, pilot);
                    api.addflight(flight);
                    break;
                case 11:
                    code = Scanner.getString("please enter the flight code you want to erase");
                    api.quitflight(code);
                    break;
                case 12:
                    System.out.flush();
                    api.printflights();
                    break;
                case 13:
                    System.out.flush();
                    System.out.println("Thank you for using the Admin App...");
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
