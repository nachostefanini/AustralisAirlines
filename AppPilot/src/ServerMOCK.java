import java.util.ArrayList;

public class ServerMOCK{

        ArrayList<Pilot> pilots = new ArrayList<>();
        ArrayList<Airplane> airplanes = new ArrayList<>();
        ArrayList<Airport> airports = new ArrayList<>();
        ArrayList<Flight> vuelos = new ArrayList<>();

        public ArrayList printFlight(String id) {
                ArrayList<String> flightOfPilots = new ArrayList();
                for (int i = 0; i < vuelos.size(); i++) {
                        if(vuelos.get(i).getPilot().getDni().equals(id)){
                                flightOfPilots.add(vuelos.get(i).getCode());
                        }else {
                                System.out.println("No flights assigned");
                        }
                }
                return flightOfPilots;
        }
}
