import java.time.LocalDate;
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
