import java.io.IOException;

public class AdminMenu {

    public static void main(String[] args) throws IOException {

        ServerMOCK Server = new ServerMOCK();

        //Agregamos agunas cosas

        SeatMap asientos = new SeatMap(8,8,4,4);

        //Creo los aviones
        Airplane test1 = new Airplane(asientos,"Test1");
        Airplane test2 = new Airplane(asientos,"Test2");
        Airplane test3 = new Airplane(asientos,"Test3");
        Airplane test4 = new Airplane(asientos,"Test4");
        Airplane test5 = new Airplane(asientos,"Test5");
        Airplane test6 = new Airplane(asientos,"Test6");
        Airplane test7 = new Airplane(asientos,"Test7");

        Server.addairplane(test1);
        Server.addairplane(test2);
        Server.addairplane(test3);
        Server.addairplane(test4);
        Server.addairplane(test5);
        Server.addairplane(test6);
        Server.addairplane(test7);


        //Creo pilotos
        Pilot juan = new Pilot("Juan","Maradona","123456789");
        Server.addpilot(juan);



        //Creo los aeropuertos
        Airport arg = new Airport("ARG001", "Argentina");
        Airport ven = new Airport("VEN001", "Venezuela");
        Airport col = new Airport("COL001", "Colombia");
        Airport bra = new Airport("BRA001", "Brasil");
        Airport per = new Airport("PER001", "Peru");
        Airport uru = new Airport("URU001", "Uruguay");
        Airport chi = new Airport("CHI001", "Chile");
        Airport mex = new Airport("MEX001", "Mexico");

        Server.addairport(arg);
        Server.addairport(ven);
        Server.addairport(col);
        Server.addairport(bra);
        Server.addairport(per);
        Server.addairport(uru);
        Server.addairport(chi);
        Server.addairport(mex);

        //Creo los vuelos

        Flight a = new Flight(arg, ven,test1,"F01",juan);
        Flight b = new Flight(ven,col,test2,"F02",juan);
        Flight c = new Flight(col, bra,test3,"F03",juan);
        Flight d = new Flight(arg, col,test4,"F04",juan);
        Flight e = new Flight(arg, bra,test5,"F05",juan);
        Flight f = new Flight(col, ven,test6,"F06",juan);
        Flight g = new Flight(ven, bra,test7,"F07",juan);


        Server.addflight(a);
        Server.addflight(b);
        Server.addflight(c);
        Server.addflight(d);
        Server.addflight(e);
        Server.addflight(f);
        Server.addflight(g);






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
                    Pilot pilot = new Pilot(name,surname,dni);
                    Server.addpilot(pilot);
                    break;
                case 2:
                    System.out.flush();
                    dni = Scanner.getString("Enter the DNI of the pilot you want to remove");
                    Server.quitpilot(dni);
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
                    int fc = 0;
                    int c1 = 0;

                    while ((fc + c1) != rows){
                        fc = Scanner.getInt("Insert the number of first class rows: ");
                        c1 = Scanner.getInt("Insert the number of couch rows: ");
                    }
                    SeatMap seats = new SeatMap(rows, columns,fc,c1);
                    Airplane newairplane = new Airplane(seats, code);
                    Server.addairplane(newairplane);
                    break;
                case 5:
                    System.out.flush();
                    code = Scanner.getString("Please enter the code of the airplane you want to quit ");
                    Server.quitairplane(code);
                    code = Scanner.getString("Please enter the code of the airplane you want to eliminate: ");
                    Server.quitairplane(code);
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
                    airportcode = Scanner.getString("Please enter the code of the airport you want to quit ");
                    Server.quitairport(airportcode);
                    System.out.println();
                    break;
                case 9:
                    System.out.flush();
                    Server.printairports();
                    System.out.println();
                    break;
                case 10:
                    String airportCodeFrom = Scanner.getString("Please enter the country of origin: ");
                    Airport from = Server.findAirport(airportCodeFrom);
                    String airportCodeTo = Scanner.getString("Please enter the country of destination: ");
                    Airport to = Server.findAirport(airportCodeTo);
                    String airplaneCode = Scanner.getString("Please enter the code of the airplane you want to asign ");
                    Airplane airplane = Server.findAirplane(airplaneCode);
                    String pilotDNI = Scanner.getString("Please enter the dni of the pilot you want to asign");
                    Pilot pilot1 = Server.findPilot(pilotDNI);
                    code = Scanner.getString("please enter a flight code");

                    Flight aFlight = new Flight(from, to, airplane, code, pilot1);
                    Server.addflight(aFlight);
                    break;
                case 11:
                    code = Scanner.getString("please enter the flight code you want to erase");
                    Server.quitflight(code);
                    break;
                case 12:
                    System.out.flush();
                    Server.printflights();
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
                    Server.find(data);
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
