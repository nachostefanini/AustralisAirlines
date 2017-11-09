import java.util.ArrayList;

public class ServerMOCK{

        ArrayList<Pilot> pilots = new ArrayList<>();
        ArrayList<Airplane> airplanes = new ArrayList<>();
        ArrayList<Airport> airports = new ArrayList<>();
        ArrayList<Flight> vuelos = new ArrayList<>();

        public ArrayList<String> printFlight(String id) {
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
        void addpilot(Pilot aPilot) {
                pilots.add(aPilot);
        }

        void addairplane(Airplane newAirplane) {
                airplanes.add(newAirplane);
        }

        void addairport(Airport newairport) {
                airports.add(newairport);
        }

        public void addflight (Flight flight){
                vuelos.add(flight);
        }
}
