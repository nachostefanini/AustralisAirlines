import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Server {
    ArrayList<Pilot> pilots = new ArrayList<>();
    ArrayList<Airplane> airplanes = new ArrayList<>();
    ArrayList<Airport> airports = new ArrayList<>();
    static ArrayList<Flight> vuelos = new ArrayList<>();

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
    Airplane findAirplane (String airplane){
        for (int i = 0; i <airplanes.size() ; i++) {
            if (airplanes.get(i).getcode().equals(airplane)){
                return airplanes.get(i);
            }
        }return null;
    }
    Airport findAirport (String airport){
        for (int i = 0; i < airports.size() ; i++) {
            if (airports.get(i).getairportcode().equals(airport))
                return airports.get(i);
        }return null;
    }
    Pilot findPilot (String pilotDNI){
        for (int i = 0; i <pilots.size() ; i++) {
            if (pilots.get(i).getDni().equals(pilotDNI)){
                return pilots.get(i);
            }
        }return null;
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
                airports.remove(i);
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
    vuelos.get(i).getAirportFrom().getairportcode().equals(from) && vuelos.get(i).getAirportTo().
                getairportcode().equals(to) && vuelos.get(i).getAirplane().getcode().equals(airplane)
     */

    public void addflight(Airport from, Airport to, Airplane airplane, Pilot  pilot, String code) {
        for (int i = 0; i < vuelos.size(); i++) {
            if (vuelos.get(i).getAirportFrom().equals(from) && vuelos.get(i).getAirportTo().equals(to) && vuelos.get(i).getAirplane().equals(airplane) && vuelos.get(i).getPilot().equals(pilot)) {
                System.out.println("The flight alrady exist");
            } else {
                Flight newFlight = new Flight(from, to, airplane, code, pilot);
                vuelos.add(newFlight);
            }
        }
    }

    public void quitflight(String code) {

        for (int i = 0; i < vuelos.size(); i++) {
            if (vuelos.get(i).getCode().equals(code)) {
                vuelos.remove(i);
                System.out.println("The flight with the code " + code + " has been deleted successfully...");
            } else {
                System.out.println("The flight with code " + code + " does not exist.");
            }
        }
    }

    public static void printflights() {
        for (Flight i : vuelos) {
            System.out.println("Flight: " + i.getCode() + " (from: " + i.getAirportFrom().getairportcode() + " to: " + i.getAirportTo().getairportcode() + ")");
        }
        System.out.println("\n");
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

