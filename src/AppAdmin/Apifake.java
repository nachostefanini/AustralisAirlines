package AppAdmin;

import java.util.*;
import java.util.ArrayList;

public class Apifake {

    HashMap <String , Pilot> pilots= new HashMap<>();
    HashMap <String, Airplane> airplanes= new HashMap <>();
    HashMap <String, Airport> airports = new HashMap<>();
    static ArrayList<Flight> vuelos = new ArrayList<>();


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

     public void addflight (Flight flight){
        if(vuelos.contains(flight)){
            System.out.println("already exist a flight with that code, please enter another...");
        }
        else{
            vuelos.add(flight);
            System.out.println("The flight with code "+flight.getCode()+" has been succesfully added to the list");
        }
    }

    public void quitflight (String code){


        for (int i = 0; i < vuelos.size(); i++) {

            if (vuelos.get(i).getCode().equalsIgnoreCase(code)) {
                vuelos.remove(i);
                System.out.println("The flight with the code " + code + " has been deleted successfully...");
                break;
            }
//            System.out.println("The flight with code " + code + " does not exist.");
        }
    }


    public  static void printflights(){
        for (Flight i : vuelos) {
            System.out.println("Flight: " + i.getName() + " (from: "+i.getOrigin() + " to: "+i.getDestination()+ ")");
        }
        System.out.println("\n");
    }

    public static void find(String[] arreglo){

        ArrayList<ArrayList<Flight>> definitivo = new ArrayList<>();


        //Si hay vuelo directo
        for (int i =0; i<vuelos.size();i++){

            if (arreglo[0].equalsIgnoreCase(vuelos.get(i).getOrigin())  && arreglo[1].equalsIgnoreCase(vuelos.get(i).getDestination())){
                System.out.println("Direct flight found: ");
                System.out.println( vuelos.get(i).getName() +" from: "+ vuelos.get(i).getOrigin() + " to: "+ vuelos.get(i).getDestination());
                vuelos.remove(vuelos.get(i));
                System.out.println("\n");
            }
        }

        ArrayList<Flight> temp = new ArrayList<>();

        // 1 escala...
        for (int i =0; i<vuelos.size();i++){

            if (arreglo[0].equalsIgnoreCase(vuelos.get(i).getOrigin()) ) {
                temp.add(vuelos.get(i));

                for (int j =0; j<vuelos.size();j++){

                    if (temp.get(0).getDestination().equalsIgnoreCase( vuelos.get(j).getOrigin()) && vuelos.get(j).getDestination().equalsIgnoreCase(arreglo[1])  ){

                        temp.add(vuelos.get(j));

                        System.out.println("Flight with one stop found: ");
                        printflights();

                        definitivo.add(temp);

                    }
                }
                temp.clear();
            }
        }


        // 2 escala...
        for (int i =0; i<vuelos.size();i++){

            if (arreglo[0].equalsIgnoreCase( vuelos.get(i).getOrigin())) {

                temp.add(vuelos.get(i));

                for (int j =0; j<vuelos.size();j++){

                    if (temp.get(0).getDestination().equalsIgnoreCase( vuelos.get(j).getOrigin())){

                        temp.add(vuelos.get(j));

                        for (int k =0; k<vuelos.size();k++){

                            if (temp.get(1).getDestination().equalsIgnoreCase( vuelos.get(k).getOrigin()) && vuelos.get(k).getDestination().equalsIgnoreCase( arreglo[1])){
                                temp.add(vuelos.get(k));
                                System.out.println("Flight with two stops found: ");
                                printflights();
                            }

                        }
                        temp.remove(1);

                    }

                }
                temp.clear();
            }
        }
    }






}