import java.util.ArrayList;

public class Sandbox2 {
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

        //Creo los aeropuertos
        Airport testa = new Airport("asd", "Argentina");
        Airport testb = new Airport("ads", "Venezuela");
        Airport testc = new Airport("dsg", "Colombia");
        Airport testd = new Airport("aew", "Brasil");
        Airport teste = new Airport("ast", "Peru");
        Airport testf = new Airport("ass", "Uruguay");
        Airport testg = new Airport("asa", "Chile");
        Airport testh = new Airport("add", "Mexico");

        //Creo los vuelos
        Flight a = new Flight(testa, testb,test1,"F01",piloto);
        Flight b = new Flight(testb,testc,test2,"F02",piloto);
        Flight c = new Flight(testc,testd,test3,"F03",piloto);
        Flight d = new Flight(testd,teste,test4,"F04",piloto);
        Flight e = new Flight(teste,testf,test5,"F05",piloto);
        Flight f = new Flight(testf,testg,test6,"F06",piloto);
        Flight g = new Flight(testg,testh,test7,"F07",piloto);
        Flight h = new Flight(testh,testa,test8,"F08",piloto);


        //Creo la lista de vuelos
        ArrayList<Flight> listavuelos = new ArrayList<>();
        listavuelos.add(a);
        listavuelos.add(b);
        listavuelos.add(c);
        listavuelos.add(d);
        listavuelos.add(e);
        listavuelos.add(f);
        listavuelos.add(g);
        listavuelos.add(h);

        FlightList lista = new FlightList(listavuelos);


        String array[] = new String[2];
        array[0] = "Argentina";
        array[1] = "Venezuela";

        System.out.println(" ------------- Flight finder------------- ");
        lista.find(array);


    }
}
