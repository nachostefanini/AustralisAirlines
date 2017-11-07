public class AdminMenu {
    static Server api = new Server();

    public static void main(String[] args) {


                    SeatMap asientos = new SeatMap(5,5,1,4);
/*
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

*/
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
                    api.addpilot(name, surname,dni);
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
                    int fc = 0;
                    int c = 0;

                    while ((fc + c) != rows){
                        fc = Scanner.getInt("Insert the number of first class rows: ");
                        c = Scanner.getInt("Insert the number of couch rows: ");
                    }
                    SeatMap seats = new SeatMap(rows, columns,fc,c);
                    Airplane newairplane = new Airplane(seats, code);
                    api.addairplane(newairplane);
                    break;
                case 5:
                    System.out.flush();
                    code = Scanner.getString("Please enter the code of the airplane you want to quit ");
                    api.quitairplane(code);
                    code = Scanner.getString("Please enter the code of the airplane you want to eliminate: ");
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
                    String location = Scanner.getString("Please enter the location of the airport: ");
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
                    String airportCodeFrom = Scanner.getString("Please enter the country of origin: ");
                    Airport from = api.findAirport(airportCodeFrom);
                    String airportCodeTo = Scanner.getString("Please enter the country of destination: ");
                    Airport to = api.findAirport(airportCodeTo);
                    String airplaneCode = Scanner.getString("Please enter the code of the airplane you want to asign ");
                    Airplane airplane = api.findAirplane(airplaneCode);
                    String pilotDNI = Scanner.getString("Please enter the dni of the pilot you want to asign");
                    Pilot pilot = api.findPilot(pilotDNI);
                    code = Scanner.getString("please enter a flight code");
                    api.addflight(from, to, airplane, pilot, code);
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
                    String origin = Scanner.getString("Please enter the airport of origin: ");
                    String destiny = Scanner.getString("Please enter the airport of destiny: ");
                    System.out.println("\n");
                    System.out.println(" ------------- Flight finder------------- ");
                    String data[] = new String[1];
                    data[0] = origin;
                    data[1] = destiny;
                    api.findFlight(data);
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
