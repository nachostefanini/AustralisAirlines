import java.io.IOException;
import java.time.LocalDate;

public class AdminMenu {
    public static ServerMOCK server;
    public static void main(String[] args) throws IOException {

        server = new ServerMOCK();

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

        server.addairplane(test1);
        server.addairplane(test2);
        server.addairplane(test3);
        server.addairplane(test4);
        server.addairplane(test5);
        server.addairplane(test6);
        server.addairplane(test7);


        //Creo pilotos
        Pilot juan = new Pilot("Juan","Maradona","123");
        server.addpilot(juan);



        //Creo los aeropuertos
        Airport arg = new Airport("ARG001", "Argentina");
        Airport ven = new Airport("VEN001", "Venezuela");
        Airport col = new Airport("COL001", "Colombia");
        Airport bra = new Airport("BRA001", "Brasil");
        Airport per = new Airport("PER001", "Peru");
        Airport uru = new Airport("URU001", "Uruguay");
        Airport chi = new Airport("CHI001", "Chile");
        Airport mex = new Airport("MEX001", "Mexico");

        server.addairport(arg);
        server.addairport(ven);
        server.addairport(col);
        server.addairport(bra);
        server.addairport(per);
        server.addairport(uru);
        server.addairport(chi);
        server.addairport(mex);

        //Creo las fechas de los vuelos
        LocalDate date0 = LocalDate.of(2017,12,1);
        LocalDate date1 = LocalDate.of(2017,12,2);
        LocalDate date2 = LocalDate.of(2017,12,3);
        LocalDate date3 = LocalDate.of(2017,12,4);
        LocalDate date4 = LocalDate.of(2017,12,5);
        LocalDate date5 = LocalDate.of(2017,12,6);
        LocalDate date6 = LocalDate.of(2017,12,7);

        //Creo los vuelos
        Flight a = new Flight(arg, ven,test1,"F01",juan, date0);
        Flight b = new Flight(ven,col,test2,"F02",juan,date1);
        Flight c = new Flight(col, bra,test3,"F03",juan,date2);
        Flight d = new Flight(arg, col,test4,"F04",juan,date3);
        Flight e = new Flight(arg, bra,test5,"F05",juan,date4);
        Flight f = new Flight(col, ven,test6,"F06",juan,date5);
        Flight g = new Flight(ven, bra,test7,"F07",juan, date6);


        server.addflight(a);
        server.addflight(b);
        server.addflight(c);
        server.addflight(d);
        server.addflight(e);
        server.addflight(f);
        server.addflight(g);



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
                    server.addpilot(pilot);
                    break;
                case 2:
                    System.out.flush();
                    dni = Scanner.getString("Enter the DNI of the pilot you want to remove");
                    server.quitpilot(dni);
                    System.out.println();
                    break;
                case 3:
                    System.out.flush();
                    server.printpilots();
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
                    server.addairplane(newairplane);
                    break;
                case 5:
                    System.out.flush();
                    code = Scanner.getString("Please enter the code of the airplane you want to quit ");
                    server.quitairplane(code);
                    System.out.println();
                    break;
                case 6:
                    System.out.flush();
                    server.printairplanes();
                    System.out.println();
                    break;
                case 7:
                    System.out.flush();
                    String airportcode = Scanner.getString("Please enter the code of the airport: ");
                    String location = Scanner.getString("Please enter the location of the airport: ");
                    Airport newairport = new Airport(airportcode, location);
                    server.addairport(newairport);
                    System.out.println();
                    break;
                case 8:
                    System.out.flush();
                    airportcode = Scanner.getString("Please enter the code of the airport you want to quit ");
                    server.quitairport(airportcode);
                    System.out.println();
                    break;
                case 9:
                    System.out.flush();
                    server.printairports();
                    System.out.println();
                    break;
                case 10:
                    String airportCodeFrom = Scanner.getString("Please enter the code of airport of origin: ");
                    Airport from = server.findairport(airportCodeFrom);
                    String airportCodeTo = Scanner.getString("Please enter the code of airport of destination: ");
                    Airport to = server.findairport(airportCodeTo);
                    String airplaneCode = Scanner.getString("Please enter the code of the airplane you want to asign ");
                    Airplane airplane = server.findAirplane(airplaneCode);
                    String pilotDNI = Scanner.getString("Please enter the dni of the pilot you want to asign");
                    Pilot pilot1 = server.findPilot(pilotDNI);
                    code = Scanner.getString("please enter a flight code");
                    int year = Scanner.getInt("Please enter the year of the Flight: ");
                    int month = Scanner.getInt("Please enter the month of the Flight: ");
                    int day = Scanner.getInt("Please enter the day of the Flight: ");
                    LocalDate date = LocalDate.of(year, month, day);
                    Flight aFlight = new Flight(from, to, airplane, code, pilot1, date);
                    server.addflight(aFlight);
                    break;
                case 11:
                    code = Scanner.getString("please enter the flight code you want to erase");
                    server.quitflight(code);
                    break;
                case 12:
                    System.out.flush();
                    server.printflights();
                    break;
                case 13:
                    System.out.flush();
                    String origin = Scanner.getString("Please enter the airport of origin: ");
                    String destiny = Scanner.getString("Please enter the airport of destiny: ");
                    System.out.println("\n");
                    System.out.println(" ------------- Flight finder------------- ");
                    String data[] = new String[2];
                    data[0] = origin;
                    data[1] = destiny;
                    server.find(data);
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
