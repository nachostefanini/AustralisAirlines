import java.util.ArrayList;

public class ClientMenu {

    public  static void main(String[] args) {
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

                    boolean out = true;
                    while (out){
                        String flight = Scanner.getString("Insert the Flight you want: ");
                        boolean condicion = Server.validateFlight(flight);

                        if (condicion == true){
                            Server.startPurchase(quantity,flight,dni);
                            out = false;
                        }

                    }
                    
                    break;
                case 2:
                    System.out.flush();
                    System.out.println();
                    break;
                case 3:
                    Server.printTickets();
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
