package Server;

import AppAdmin.Airplane;
import AppAdmin.Airport;
import AppAdmin.Flight;
import AppAdmin.Pilot;

import java.util.HashMap;
import java.util.Map;

public class Server {
    HashMap<String , Pilot> pilots= new HashMap<>();
    HashMap <String, Airplane> airplanes= new HashMap <>();
    HashMap <String, Airport> airports = new HashMap<>();
    HashMap <String, Flight> flights = new HashMap<>();

    public static void addpilot(Pilot newPilot){
        ServerAPI.addpilot(newPilot);
    }

    public static void quitpilot (String dni){
        ServerAPI.quitpilot (dni);
    }

    public static void printpilots (){
        ServerAPI.printpilots();
    }
    public static void addairplane (Airplane newairplane){
        ServerAPI.addairplane(newairplane);
    }

    public static void quitairplane (String code) {
        ServerAPI.quitairplane(code);
    }

    public static void printairplanes (){
        ServerAPI.printairplanes();
    }

    public static void addairport (Airport newairport){
        ServerAPI.addairport(newairport)
    }

    void quitairport (String airportcode){
        if (airports.containsKey(airportcode)) {
            airports.remove(airportcode);
            System.out.println("the airport whith code "+airportcode+" has been deleted succesfully...");
        }
        else{
            System.out.println("the airport with code "+airportcode+" is not listed...");
        }
    }

    void printairports (){
        if (airports.isEmpty()){
            System.out.println("The list of airports is empty");
        }
        else {
            System.out.println("This is the list of airports:");
            airports.forEach((String, Airport) -> System.out.println("Code: "+String + " Location: "+Airport.getlocation()));
        }
    }

    Airport getairportFrom (String airportcodefrom){ return airports.get(airportcodefrom); }

    Airport getairportTo (String airportcodeto){
        return airports.get(airportcodeto);
    }

    Airplane getairplane (String airplanecode){
        return airplanes.get(airplanecode);
    }

    Pilot getpilot (String dni){
        return pilots.get(dni);
    }

    void addflight (Flight flight){
        String code = flight.getCode();
        if(flights.containsKey(code)){
            System.out.println("already exist a flight with that code, please enter another...");
        }
        else{
            flights.put(code,flight);
            System.out.println("The flight with code "+code+" has been succesfully added to the list");
        }
    }

    void quitflight (String code){
        if (flights.containsKey(code)) {
            flights.remove(code);
            System.out.println("the flight whith code "+code+" has been deleted succesfully...");
        }
        else{
            System.out.println("the flight with code "+code+" is not listed...");
        }
    }

    void printflights(){
        if (flights.isEmpty()){
            System.out.println("The list of flights is empty");
        }
        else {
            System.out.println("This is the list of flights:");
            flights.forEach((String, Flight) -> System.out.println("Code: "+String+" Origin Airport: "+Flight.getFrom()+" Destination Airport: "+Flight.getTo()+" Airplane: "+Flight.getAirplane()+" Pilot: "+Flight.getPilot()));
        }
    }

}
}
