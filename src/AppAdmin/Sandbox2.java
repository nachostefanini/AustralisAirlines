package AppAdmin;

import java.util.ArrayList;

public class Sandbox2 {
    public static void main(String[] args) {

        SeatMap a = new SeatMap(3,3);

        //Creo los aviones
        Airplane test1 = new Airplane(a,"Test1");
        Airplane test2 = new Airplane(a,"Test2");
        Airplane test3 = new Airplane(a,"Test3");
        Airplane test4 = new Airplane(a,"Test4");
        Airplane test5 = new Airplane(a,"Test5");
        Airplane test6 = new Airplane(a,"Test6");
        Airplane test7 = new Airplane(a,"Test7");
        Airplane test8 = new Airplane(a,"Test8");

        //Creo pilotos
        Pilot p = new Pilot("Juan","Perez","1234567");


        //Creo los vuelos
        Flight y = new Flight("Argentina","China",test1,"F01",p);
        Flight b = new Flight("Argentina","Peru",test2,"F02",p);
        Flight c = new Flight("Peru","Venezuela",test3,"F03",p);
        Flight d = new Flight("Venezuela","China",test4,"F04",p);
        Flight e = new Flight("Madrid","China",test5,"F05",p);
        Flight f = new Flight("Peru","China",test6,"F06",p);
        Flight g = new Flight("Argentina","Venezuela",test7,"F07",p);
        Flight h = new Flight("Venezuela","Madrid",test8,"F08",p);


        //Creo la lista de vuelos
        ArrayList<Flight> lista = new ArrayList<>();
        lista.add(y);
        lista.add(b);
        lista.add(c);
        lista.add(d);
        lista.add(e);
        lista.add(f);
        lista.add(g);
        lista.add(h);

        FlightList algo = new FlightList(lista);

        String[] buscar = {"Argentina","China"};

        System.out.println(" ------------- Flight finder------------- ");
        algo.find(buscar);


    }
}
