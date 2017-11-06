package AppAdmin;

import java.util.List;

public class ApiFake2 {
    List<Airport> airports = null;
    List<Airplane> airplanes = null;
    List<Pilot> pilots = null;
    List<Flight> flights = null;

    void addPilot (String name, String surname, String dni){
        Pilot newPilot = new Pilot(name,surname, dni);
        pilots.add(newPilot);
    }

    }

