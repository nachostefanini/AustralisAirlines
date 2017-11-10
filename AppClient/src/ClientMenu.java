import com.sun.corba.se.spi.activation.Server;

import java.time.LocalDate;
import java.util.Random;

public class ClientMenu {
    public static ServerMOCK server;
    public  static void main(String[] args) {
        server = new ServerMOCK();

        //Agregamos agunas cosas

        SeatMap asientos1 = new SeatMap(8,8,4,4);
        SeatMap asientos2 = new SeatMap(8,8,4,4);
        SeatMap asientos3 = new SeatMap(8,8,4,4);
        SeatMap asientos4 = new SeatMap(8,8,4,4);
        SeatMap asientos5 = new SeatMap(8,8,4,4);
        SeatMap asientos6 = new SeatMap(8,8,4,4);
        SeatMap asientos7 = new SeatMap(8,8,4,4);


        //Creo los aviones
        Airplane test1 = new Airplane(asientos1,"Test1");
        Airplane test2 = new Airplane(asientos2,"Test2");
        Airplane test3 = new Airplane(asientos3,"Test3");
        Airplane test4 = new Airplane(asientos4,"Test4");
        Airplane test5 = new Airplane(asientos5,"Test5");
        Airplane test6 = new Airplane(asientos6,"Test6");
        Airplane test7 = new Airplane(asientos7,"Test7");

        server.addairplane(test1);
        server.addairplane(test2);
        server.addairplane(test3);
        server.addairplane(test4);
        server.addairplane(test5);
        server.addairplane(test6);
        server.addairplane(test7);


        //Creo pilotos
        Pilot juan = new Pilot("Juan","Maradona","123456789");
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
        Flight a = new Flight(arg, ven, test1,"F01", juan, date0);
        Flight b = new Flight(ven, col, test2,"F02", juan, date1);
        Flight c = new Flight(col, bra, test3,"F03", juan, date2);
        Flight d = new Flight(arg, col, test4,"F04", juan, date3);
        Flight e = new Flight(arg, bra, test5,"F05", juan, date4);
        Flight f = new Flight(col, ven, test6,"F06", juan, date5);
        Flight g = new Flight(ven, bra, test7,"F07", juan, date6);


        server.addflight(a);
        server.addflight(b);
        server.addflight(c);
        server.addflight(d);
        server.addflight(e);
        server.addflight(f);
        server.addflight(g);



        System.out.println("+--------------------------------------------+");
        System.out.println("              Australis Airlines              ");
        System.out.println("                  Admin app                   ");
        System.out.println("+--------------------------------------------+");

        int dni = Scanner.getInt("Insert your DNI: ");
        System.out.println("Welcome back: " + dni);
        System.out.println("\n");



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
                    int quantity = Scanner.getInt("Quantity: ");

                    String from = Scanner.getString("From: ");
                    String to = Scanner.getString("To: ");

                    String[] data = new String[2];
                    data[0] = from;
                    data[1] = to;

                    boolean condicion = server.find(data);

                    if (condicion == false){

                        String flight = Scanner.getString("Insert the Flight you want: ");
                        boolean validacion = server.validateFlight(flight);


                        if (validacion == true){
                            server.startPurchase(quantity,flight,dni);
                        }else {
                            System.out.println("Flight not found");
                            break;
                        }

                    }else {
                        System.out.println("Invalid destination or origin");
                    }

                    break;
                case 2:
                   int code = Scanner.getInt("Insert the code of the ticket you want to cancel: ");

                   boolean validar = server.validateTicket(code);

                   if (validar == true){
                       server.cancelTicket(code);
                   }else {
                       System.out.println("Ticket code not found");
                   }
                    break;
                case 3:
                    server.printTickets();
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
