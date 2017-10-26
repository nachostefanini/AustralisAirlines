package AppAdmin;

import java.util.*;

public class Apifake {

    HashMap <String , Pilot> pilots= new HashMap<>();
    HashMap <String, Airplane> airplanes= new HashMap <>();
    HashMap <String, Airport> airports = new HashMap<>();
    HashMap <String, Flight> fligths = new HashMap<>();

    void addpilot (Pilot newPilot){
        String Dni = newPilot.getDni();
        if(pilots.containsKey(Dni)){
            System.out.println("already exist a pilot with that DNI, please enter another...");
        }
        else{
            pilots.put(newPilot.getDni(),newPilot);
            System.out.println("The AppAdmin.Pilot with DNI "+newPilot.getDni()+" has been succesfully added to the list");
        }
    }

    void quitpilot (String dni){
        if (pilots.containsKey(dni)) {
            pilots.remove(dni);
            System.out.println("the pilot whith DNI "+dni+" has been deleted succesfully...");
        }
        else{
            System.out.println("the pilot with DNI "+dni+" is not listed...");
        }
    }

    void printpilots (){
        if (pilots.isEmpty()){
            System.out.println("The list of pilots is empty");
        }
        else {
            System.out.println("This is the list of pilots:");
            pilots.forEach((String, Pilot) -> System.out.println("DNI: " + String + ": AppAdmin.Pilot: " + Pilot.getName() + " " + Pilot.getSurname()));
        }
    }
    void addairplane (Airplane newairplane){
        String code = newairplane.getcode();
        if(airplanes.containsKey(code)){
            System.out.println("already exist a airplane with that code, please enter another...");
        }
        else{
            airplanes.put(newairplane.getcode(),newairplane);
            System.out.println("The airplane with code "+newairplane.getcode()+" has been succesfully added to the list");
        }
    }

    void quitairplane (String code){
        if (airplanes.containsKey(code)) {
            airplanes.remove(code);
            System.out.println("the pilot whith code "+code+" has been deleted succesfully...");
        }
        else{
            System.out.println("the pilot with code "+code+" is not listed...");
        }
    }

    void printairplanes (){
        if (airplanes.isEmpty()){
            System.out.println("The list of airplanes is empty");
        }
        else {
            System.out.println("This is the list of airplanes:");
            //airplanes.forEach((String, Airplane) -> System.out.println("Code: "+String + Airplane));

            for (Map.Entry<String, Airplane> item: airplanes.entrySet()) {
                String key = item.getKey();
                Airplane value = item.getValue();

                System.out.println("airplane code: "+key);
                value.print();
                System.out.println("\t");
            }
        }

    }

    void addairport (Airport newairport){
        String code = newairport.getairportcode();
        if(airports.containsKey(code)){
            System.out.println("already exist a airplane with that code, please enter another...");
        }
        else{
            airports.put(newairport.getairportcode(),newairport);
            System.out.println("The airport with code "+newairport.getairportcode()+" has been succesfully added to the list");
        }
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
    void addFlight (Airplane airplane, Pilot pilot, Airport airportFrom, Airport airportTo){
        if(airplanes.containsKey(airplane)){
            if(pilots.containsKey(pilot)){
                if (airports.containsKey(airportFrom)){
                    if (airports.containsKey(airportTo)){
                        Flight flight = new Flight(airportFrom, airportTo, airplane, pilot);
                    }
                }
            }
        }
        else {
            System.out.println("that airplane does not exit");
        }
    }


}
