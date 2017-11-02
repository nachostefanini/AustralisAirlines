package AppAdmin;
import Server.Server;
import Scanner.Scanner;

public class AdminMenu {
    static Apifake api = new Apifake();

    public static void main(String[] args) {


                    SeatMap asientos = new SeatMap(3,3);

                    //Creo los aviones
                    Airplane test1 = new Airplane(asientos,"Test1");
                    Airplane test2 = new Airplane(asientos,"Test2");
                    Airplane test3 = new Airplane(asientos,"Test3");
                    Airplane test4 = new Airplane(asientos,"Test4");
                    Airplane test5 = new Airplane(asientos,"Test5");
                    Airplane test6 = new Airplane(asientos,"Test6");
                    Airplane test7 = new Airplane(asientos,"Test7");
                    Airplane test8 = new Airplane(asientos,"Test8");

                    //Creo pilotos
                    Pilot piloto = new Pilot("Juan","Perez","1234567");


                    //Creo los vuelos
                    Flight a = new Flight("Argentina","China",test1,"F01",piloto);
                    Flight b = new Flight("Argentina","Peru",test2,"F02",piloto);
                    Flight c = new Flight("Peru","Venezuela",test3,"F03",piloto);
                    Flight d = new Flight("Venezuela","China",test4,"F04",piloto);
                    Flight e = new Flight("Madrid","China",test5,"F05",piloto);
                    Flight f = new Flight("Peru","China",test6,"F06",piloto);
                    Flight g = new Flight("Argentina","Venezuela",test7,"F07",piloto);
                    Flight h = new Flight("Venezuela","Madrid",test8,"F08",piloto);


                    //agrego los vuelos a la lista de vuelos
                    api.addflight(a);
                    api.addflight(b);
                    api.addflight(c);
                    api.addflight(d);
                    api.addflight(e);
                    api.addflight(f);
                    api.addflight(g);
                    api.addflight(h);


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
            System.out.println("13. Find Flights");
            System.out.println("14. Exit: ");
            System.out.println();
            int opc = Scanner.getInt("What operation do you want to do: ");
            System.out.println("\t");

            switch (opc) {
                case 1:
                    System.out.flush();
                    String name = Scanner.getString("Enter the name of the pilot: ");
                    String surname = Scanner.getString("Enter the surname of the pilot: ");
                    String dni = Scanner.getString("Enter the DNI of the pilot: ");
                    Pilot newPilot = new Pilot(name, surname, dni);
                    Server.addpilot(newPilot);
                    break;
                case 2:
                    System.out.flush();
<<<<<<< HEAD
                    dni = Scanner.getString("Enter the DNI of the pilot you want to remove");
                    Server.quitpilot(dni);
=======
                    dni = Scanner.getString("Enter the DNI of the pilot you want to remove: ");
                    api.quitpilot(dni);
>>>>>>> e513ec4997cbb74616d979b853f2ccdd1dbb6d49
                    System.out.println();
                    break;
                case 3:
                    System.out.flush();
                    Server.printpilots();
                    System.out.println();
                    break;
                case 4:
                    System.out.flush();
                    String code = Scanner.getString("Please enter the code of the airplane: ");
                    int rows = Scanner.getInt("Please enter the number of rows of seats: ");
                    int columns = Scanner.getInt("Please enter the number of columns of seats: ");
                    SeatMap seats = new SeatMap(rows, columns);
                    Airplane newairplane = new Airplane(seats, code);
                    Server.addairplane(newairplane);
                    break;
                case 5:
                    System.out.flush();
<<<<<<< HEAD
                    code = Scanner.getString("Please enter the code of the airplane you want to quit ");
                    Server.quitairplane(code);
=======
                    code = Scanner.getString("Please enter the code of the airplane you want to eliminate: ");
                    api.quitairplane(code);
>>>>>>> e513ec4997cbb74616d979b853f2ccdd1dbb6d49
                    System.out.println();
                    break;
                case 6:
                    System.out.flush();
                    Server.printairplanes();
                    System.out.println();
                    break;
                case 7:
                    System.out.flush();
                    String airportcode = Scanner.getString("Please enter the code of the airport: ");
                    String location = Scanner.getString("Please enter the location of the airport: ");
                    Airport newairport = new Airport(airportcode, location);
                    Server.addairport(newairport);
                    System.out.println();
                    break;
                case 8:
                    System.out.flush();
<<<<<<< HEAD
                    airportcode = Scanner.getString("Please enter the code of the airport you want to quit ");
                    Server.quitairport(airportcode);
=======
                    airportcode = Scanner.getString("Please enter the code of the airport you want to eliminate: ");
                    api.quitairport(airportcode);
>>>>>>> e513ec4997cbb74616d979b853f2ccdd1dbb6d49
                    System.out.println();
                    break;
                case 9:
                    System.out.flush();
                    Server.printairports();
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
<<<<<<< HEAD
                    code = Scanner.getString("please enter a flight code");
                    Flight flight = new Flight(airportFrom, airportTo, airplane, pilot, code);
                    Server.addflight(flight);
                    break;
                case 11:
                    code = Scanner.getString("please enter the flight code you want to erase");
                    Server.quitflight(code);
=======
                    code = Scanner.getString("Please enter a flight code: ");
                    Flight flight = new Flight(airportcodefrom, airportcodeto, airplane, code, pilot);
                    api.addflight(flight);
                    break;
                case 11:
                    code = Scanner.getString("Please enter the flight code you want to erase: ");
                    api.quitflight(code);
>>>>>>> e513ec4997cbb74616d979b853f2ccdd1dbb6d49
                    break;
                case 12:
                    System.out.flush();
                    Server.printflights();
                    break;
                case 13:
                    System.out.flush();
                    String origin = Scanner.getString("Please enter the airport of origin: ");
                    String destiny = Scanner.getString("Please enter the airport of destiny: ");
                    String[] buscar = {origin,destiny};
                    System.out.println("\n");
                    System.out.println(" ------------- Flight finder------------- ");
                    Apifake.find(buscar);
                    break;
                case 14:
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
