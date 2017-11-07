import java.util.ArrayList;

public class Sandbox2 {
    public static void main(String[] args) {
        SeatMap asientos = new SeatMap(5,5,1,4);


        //Creo los aviones
        Airplane test1 = new Airplane(asientos,"Test1");
        Airplane test2 = new Airplane(asientos,"Test2");
        Airplane test3 = new Airplane(asientos,"Test3");
        Airplane test4 = new Airplane(asientos,"Test4");
        Airplane test5 = new Airplane(asientos,"Test5");
        Airplane test6 = new Airplane(asientos,"Test6");
        Airplane test7 = new Airplane(asientos,"Test7");



        //Creo los aeropuertos
        Airport arg = new Airport("ARG001", "Argentina");
        Airport ven = new Airport("VEN001", "Venezuela");
        Airport col = new Airport("COL001", "Colombia");
        Airport bra = new Airport("BRA001", "Brasil");
        Airport per = new Airport("PER001", "Peru");
        Airport uru = new Airport("URU001", "Uruguay");
        Airport chi = new Airport("CHI001", "Chile");
        Airport mex = new Airport("MEX001", "Mexico");


        //Creo pilotos
        Pilot juan = new Pilot("Juan","Perez","1234567");

        //Creo los vuelos

        Flight a = new Flight(arg, ven,test1,"F01",juan);
        Flight b = new Flight(ven,col,test2,"F02",juan);
        Flight c = new Flight(col, bra,test3,"F03",juan);
        Flight d = new Flight(arg, col,test4,"F04",juan);
        Flight e = new Flight(arg, bra,test5,"F05",juan);
        Flight f = new Flight(col, ven,test6,"F06",juan);
        Flight g = new Flight(ven, bra,test7,"F07",juan);


        //Creo la lista de vuelos
        ArrayList<Flight> listavuelos = new ArrayList<>();
        listavuelos.add(a);
        listavuelos.add(b);
        listavuelos.add(c);
        listavuelos.add(d);
        listavuelos.add(e);
        listavuelos.add(f);
        listavuelos.add(g);

        FlightList lista = new FlightList(listavuelos);


        String[] array = new String[2];
        array[0] = "Argentina";
        array[1] = "Brasil";

        System.out.println(" ------------- Flight finder------------- ");
        lista.find(array);


    }
}
