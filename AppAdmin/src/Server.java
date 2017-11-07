import AppAdmin.Airplane;
import AppAdmin.Airport;
import AppAdmin.Pilot;

import java.util.ArrayList;
import java.util.Map;

public class Server {
    ArrayList<Pilot> pilots = new ArrayList<>();
    ArrayList<Airplane> airplanes = new ArrayList<>();
    ArrayList<Airport> airports = new ArrayList<>();
    static ArrayList<Flight> vuelos = new ArrayList<>();

/*
    void addpilot(Pilot newPilot) {
        String dni = newPilot.getDni();
        for (int i = 0; i < pilots.size(); i++) {

            if (pilots.get(i).getDni().equals(dni)) {
                System.out.println("already exist a pilot with that DNI, please enter another...");
            } else {
                pilots.add(newPilot);
                System.out.println("The AppAdmin.Pilot with DNI " + newPilot.getDni() + " has been succesfully added to the list");
            }
        }
    }*/


    void quitpilot(String dni) {
        for (int i = 0; i < pilots.size(); i++) {
            if (pilots.get(i).getDni().equals(dni)) {
                pilots.remove(i);
                System.out.println("The pilot with the dni" + dni + "has been eliminated");
            } else {
                System.out.println("");
            }
        }
    }

    void printpilots() {
        if (pilots.isEmpty()) {
            System.out.println("The list of pilots is empty");
        } else {
            System.out.println("This is the list of pilots:");
            for (int i = 0; i < pilots.size(); i++) {
                System.out.println("DNI: " + pilots.get(i).getDni() + " Name: " + pilots.get(i).getName() + " " + pilots.get(i).getSurname());
            }
        }
    }


    void addairplane(Airplane newAirplane) {
        String code = newAirplane.getcode();
        if (airplanes.contains(newAirplane)) {
            System.out.println("already exist a airplane with that code, please enter another...");
        } else {
            airplanes.add(newAirplane);

            System.out.println("The airplane with code " + newAirplane.getcode() + " has been succesfully added to the list");
        }
    }

    void quitairplane(String code) {
        for (int j = 0; j < airplanes.size(); j++) {
            if (airplanes.get(j).getcode().equals(code)) {
                airplanes.remove(j);
                System.out.println("the pilot whith code " + code + " has been deleted succesfully...");
            } else {
                System.out.println("the pilot with code " + code + " is not listed...");
            }
        }
    }
    void printairplanes() {
        if (airplanes.isEmpty()) {
            System.out.println("The list of airplanes is empty");
        } else {
            for (int k = 0; k < airplanes.size() ; k++) {
                System.out.println("Code of Airplane: " + airplanes.get(k).getcode());
            }
        }
    }

    void addairport(Airport newairport) {
        String code = newairport.getairportcode();
        if (airports.contains(newairport)) {
            System.out.println("already exist a airplane with that code, please enter another...");
        } else {
            airports.add(newairport);
            System.out.println("The airport with code " + newairport.getairportcode() + " has been succesfully added to the list");
        }
    }

    void quitairport(String airportcode) {
        for (int i = 0; i < airports.size(); i++) {

            if (airports.get(i).getairportcode().equals(airportcode)) {
                airports.remove(airportcode);
                System.out.println("the airport whith code " + airportcode + " has been deleted succesfully...");
            } else {
                System.out.println("the airport with code " + airportcode + " is not listed...");
            }
        }
    }

    void printairports() {
        if (airports.isEmpty()) {
            System.out.println("The list of airports is empty");
        } else {
            System.out.println("This is the list of airports:");
            for (int j = 0; j < airports.size(); j++) {
                System.out.println("Airport code: "+ airports.get(j).getairportcode() + ", Location: " + airports.get(j).getlocation());
            }
        }
    }
    /*
    Airport getairportFrom(String airportcodefrom) {
        return airports.get(airportcodefrom);
    }

    Airport getairportTo(String airportcodeto) {

        return airports.get(airportcodeto);
    }

    Airplane getairplane(String airplanecode) {

        return airplanes.get(airplanecode);
    }

    Pilot getpilot(String dni) {

        return pilots.get(dni);
    }
    */

    public void addflight(Airport from, Airport to, Airplane airplane, Pilot pilot, String code) {
        if (airports.contains(from) && airports.contains(to) && airplanes.contains(airplane) && pilots.contains(pilot)) {
            Flight newflight = new Flight(from, to, airplane, code, pilot);
            vuelos.add(newflight);
        } else {
            throw new RuntimeException("Verify your data");
        }
    }

    public void quitflight(String code) {


        for (int i = 0; i < vuelos.size(); i++) {

            if (vuelos.get(i).getCode().equalsIgnoreCase(code)) {
                vuelos.remove(i);
                System.out.println("The flight with the code " + code + " has been deleted successfully...");
                break;
            }
//            System.out.println("The flight with code " + code + " does not exist.");
        }
    }

    public static void printflights() {
        for (Flight i : vuelos) {
            System.out.println("Flight: " + i.getCode() + " (from: " + i.getAirportFrom().getairportcode() + " to: " + i.getAirportTo().getairportcode() + ")");
        }
        System.out.println("\n");
    }

    public static void find(String from, String to) {
        for (int j = 0; j < vuelos.size(); j++) {
            if (from.equals(vuelos.get(j).getAirportFrom().getairportcode()) && to.equals(vuelos.get(j).getAirportTo().getairportcode())) {
                Airport airportFrom = vuelos.get(j).getAirportFrom();
                Airport airportTo = vuelos.get(j).getAirportTo();
                for (int i = 0; i < vuelos.size(); i++) {
                    if (airportFrom.equals(vuelos.get(i).getAirportFrom()) && airportTo.equals(vuelos.get(i).getAirportTo())) {
                        System.out.println(vuelos.get(i).getCode());
                    } else {
                        System.out.println("Sorry, but the flight doesn't exist");
                    }
                }
            }
        }
    }

    public static void findFlight(String[] arreglo) {
        ArrayList<ArrayList<Flight>> definitivo = new ArrayList<>();


        //Si hay vuelo directo
        for (int i = 0; i < vuelos.size(); i++) {

            if (arreglo[0].equalsIgnoreCase(vuelos.get(i).getAirportFrom().getairportcode()) && arreglo[1].equalsIgnoreCase(vuelos.get(i).getAirportTo().getairportcode())) {
                System.out.println("Se encontro vuelo directo: ");
                System.out.println(vuelos.get(i).getCode() + " from: " + vuelos.get(i).getAirportFrom().getairportcode() + " to: " + vuelos.get(i).getAirportTo().getairportcode());
                vuelos.remove(vuelos.get(i));
                System.out.println("\n");
            }
        }

        ArrayList<Flight> temp = new ArrayList<>();

        // 1 escala...
        for (int i = 0; i < vuelos.size(); i++) {

            if (arreglo[0].equalsIgnoreCase(vuelos.get(i).getAirportFrom().getairportcode())) {
                temp.add(vuelos.get(i));

                for (int j = 0; j < vuelos.size(); j++) {

                    if (temp.get(0).getAirportTo().getairportcode().equalsIgnoreCase(vuelos.get(j).getAirportFrom().getairportcode()) && vuelos.get(j).getAirportTo().getairportcode().equalsIgnoreCase(arreglo[1])) {

                        temp.add(vuelos.get(j));

                        System.out.println("Se encontro vuelo con 1 sola escala: ");
                        printFlight(temp);

                        definitivo.add(temp);

                    }
                }
                temp.clear();
            }
        }


        // 2 escala...
        for (int i = 0; i < vuelos.size(); i++) {

            if (arreglo[0].equalsIgnoreCase(vuelos.get(i).getAirportFrom().getairportcode())) {

                temp.add(vuelos.get(i));

                for (int j = 0; j < vuelos.size(); j++) {

                    if (temp.get(0).getAirportTo().getairportcode().equalsIgnoreCase(vuelos.get(j).getAirportFrom().getairportcode())) {

                        temp.add(vuelos.get(j));

                        for (int k = 0; k < vuelos.size(); k++) {

                            if (temp.get(1).getAirportTo().getairportcode().equalsIgnoreCase(vuelos.get(k).getAirportFrom().getairportcode()) && vuelos.get(k).getAirportTo().getairportcode().equalsIgnoreCase(arreglo[1])) {
                                temp.add(vuelos.get(k));
                                System.out.println("Se encontro vuelo con 2 escalas: ");
                                printFlight(temp);
                            }

                        }
                        temp.remove(1);

                    }

                }
                temp.clear();
            }
        }
    }

    public static void printFlight(ArrayList<Flight> arreglo) {
        for (Flight i : arreglo) {
            System.out.println("Avion: " + i.getCode() + " (from: " + i.getAirportFrom().getairportcode() + " to: " + i.getAirportTo().getairportcode() + ")");
        }
        System.out.println("\n");
    }

    public void addpilot(String name, String surname, String dni) {
        Pilot newPilot = new Pilot(name, surname, dni);
        for (int i = 0; i < pilots.size(); i++) {

            if (pilots.get(i).getDni().equals(dni)) {
                System.out.println("already exist a pilot with that DNI, please enter another...");
            } else {
                pilots.add(newPilot);
                System.out.println("The AppAdmin.Pilot with DNI " + newPilot.getDni() + " has been succesfully added to the list");
            }
        }
    }
}

