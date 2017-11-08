import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;

public class ServerMOCK {

    ArrayList<Pilot> pilots = new ArrayList<>();
    ArrayList<Airplane> airplanes = new ArrayList<>();
    ArrayList<Airport> airports = new ArrayList<>();
    ArrayList<Flight> vuelos = new ArrayList<>();

    public void find(String[] arreglo) {

        ArrayList<ArrayList<Flight>> definitivo = new ArrayList<>();


        //Si hay vuelo directo
        for (int i = 0; i < vuelos.size(); i++) {

            if (arreglo[0].equalsIgnoreCase(vuelos.get(i).getAirportFrom().getlocation()) && arreglo[1].equalsIgnoreCase(vuelos.get(i).getAirportTo().getlocation())) {
                System.out.println("Se encontro vuelo directo: ");
                System.out.println(vuelos.get(i).getCode() + " from: " + vuelos.get(i).getAirportFrom().getlocation() + " to: " + vuelos.get(i).getAirportTo().getlocation());
                vuelos.remove(vuelos.get(i));
                System.out.println("\n");
            }
        }

        ArrayList<Flight> temp = new ArrayList<>();

        // 1 escala...
        for (int i = 0; i < vuelos.size(); i++) {

            if (arreglo[0].equalsIgnoreCase(vuelos.get(i).getAirportFrom().getlocation())) {
                temp.add(vuelos.get(i));

                for (int j = 0; j < vuelos.size(); j++) {

                    if (temp.get(0).getAirportTo().getlocation().equalsIgnoreCase(vuelos.get(j).getAirportFrom().getlocation()) && vuelos.get(j).getAirportTo().getlocation().equalsIgnoreCase(arreglo[1])) {

                        temp.add(vuelos.get(j));

                        System.out.println("Se encontro vuelo con 1 sola escala: ");
                        print(temp);
                    }
                }
                temp.clear();
            }
        }

        // 2 escala...
        for (int i = 0; i < vuelos.size(); i++) {

            if (arreglo[0].equalsIgnoreCase(vuelos.get(i).getAirportFrom().getlocation())) {

                temp.add(vuelos.get(i));

                for (int j = 0; j < vuelos.size(); j++) {

                    if (temp.get(0).getAirportTo().getlocation().equalsIgnoreCase(vuelos.get(j).getAirportFrom().getlocation())) {

                        temp.add(vuelos.get(j));

                        for (int k = 0; k < vuelos.size(); k++) {

                            if (temp.get(1).getAirportTo().getlocation().equalsIgnoreCase(vuelos.get(k).getAirportFrom().getlocation()) && vuelos.get(k).getAirportTo().getlocation().equalsIgnoreCase(arreglo[1])) {
                                temp.add(vuelos.get(k));
                                System.out.println("Se encontro vuelo con 2 escalas: ");
                                print(temp);
                            }

                        }
                        temp.remove(1);

                    }

                }
                temp.clear();
            }
        }

    }


    public void print(ArrayList<Flight> arreglo) {
        for (Flight i : arreglo) {
            System.out.println("Flight: " + i.getCode() + " (from: " + i.getAirportFrom().getlocation() + " to: " + i.getAirportTo().getlocation() + ")");
        }
        System.out.println("\n");
    }

    //--------------------------------------- Pilots --------------------------------------- //
    Pilot findPilot(String pilotDNI) {
        for (int i = 0; i < pilots.size(); i++) {
            if (pilots.get(i).getDni().equals(pilotDNI)) {
                return pilots.get(i);
            }
        }
        return null;
    }

    void addpilot(Pilot aPilot) throws IOException {

        String dni = aPilot.getDni();

        if (airports.contains(aPilot)) {
            System.out.println("Already exist a airplane with that code, please enter another...");
        } else {
            pilots.add(aPilot);
            System.out.println("The pilot: " + aPilot.getName() + " " + aPilot.getSurname() + " " + dni + " has been succesfully added to the list");
        }
        try {
            FileWriter writer = new FileWriter("listPilot.txt");
            for (Pilot pilot: pilots) {
                writer.write(String.valueOf(pilot));
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void quitpilot(String dni) {
        for (int i = 0; i < pilots.size(); i++) {
            if (pilots.get(i).getDni().equals(dni)) {
                pilots.remove(i);
                System.out.println("The pilot with the dni" + dni + "has been eliminated");
            } else {
                System.out.println("");
            }
        }
        try {
            FileWriter writer = new FileWriter("listPilot.txt");
            for (Pilot pilot: pilots) {
                writer.write(String.valueOf(pilot));
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    void printpilots() {
        if (pilots.size() > 0) {
            System.out.println("This is the list of pilots:");
            for (int k = 0; k < pilots.size(); k++) {
                System.out.println("Pilots: " + pilots.get(k).getName() + " " + pilots.get(k).getSurname() + " " + pilots.get(k).getDni());
            }
        } else {
            System.out.println("The list of pilots is empty");
        }
    }

    //--------------------------------------- Airplane --------------------------------------- //
    Airplane findAirplane(String airplane) {
        for (int i = 0; i < airplanes.size(); i++) {
            if (airplanes.get(i).getcode().equals(airplane)) {
                return airplanes.get(i);
            }
        }
        return null;
    }

    void addairplane(Airplane newAirplane) {
        String code = newAirplane.getcode();

        if (airplanes.contains(newAirplane)) {
            System.out.println("already exist a airplane with that code, please enter another...");
        } else {
            airplanes.add(newAirplane);
            System.out.println("The airplane with code " + newAirplane.getcode() + " has been succesfully added to the list");
        }
        try {
            FileWriter writer = new FileWriter("listAirplane.txt");
            for (Airplane airplane: airplanes) {
                writer.write(String.valueOf(airplane));
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
        try {
            FileWriter writer = new FileWriter("listAirplane.txt");
            for (Airplane airplane: airplanes) {
                writer.write(String.valueOf(airplane));
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void printairplanes() {
        if (airplanes.isEmpty()) {
            System.out.println("The list of airplanes is empty");
        } else {
            for (int k = 0; k < airplanes.size(); k++) {
                System.out.println("Code of Airplane: " + airplanes.get(k).getcode());
            }
        }
    }

    //--------------------------------------- Airport --------------------------------------- //
    Airport findAirport(String airport) {
        for (int i = 0; i < airports.size(); i++) {
            if (airports.get(i).getairportcode().equals(airport))
                return airports.get(i);
        }
        return null;
    }

    void addairport(Airport newairport) {
        String code = newairport.getairportcode();

        if (airports.contains(newairport)) {
            System.out.println("already exist a airplane with that code, please enter another...");
        } else {
            airports.add(newairport);
            System.out.println("The airport with code " + newairport.getairportcode() + " has been succesfully added to the list");
        }try {
            FileWriter writer = new FileWriter("listAirports.txt");
            for (Airport airport: airports) {
                writer.write(String.valueOf(airport));
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void quitairport(String airportcode) {
        for (int i = 0; i < airports.size(); i++) {
            if (airports.get(i).getairportcode().equals(airportcode)) {
                airports.remove(i);
                System.out.println("the airport whith code " + airportcode + " has been deleted succesfully...");
            } else {
                System.out.println("the airport with code " + airportcode + " is not listed...");
            }try {
                FileWriter writer = new FileWriter("listAirports.txt");
                for (Airport airport: airports) {
                    writer.write(String.valueOf(airport));
                    writer.write("\n");
                }
                writer.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    void printairports() {
        if (airports.isEmpty()) {
            System.out.println("The list of airports is empty");
        } else {
            System.out.println("This is the list of airports:");
            for (int j = 0; j < airports.size(); j++) {
                System.out.println("Airport code: " + airports.get(j).getairportcode() + ", Location: " + airports.get(j).getlocation());
            }
        }
    }
    /*
    vuelos.get(i).getAirportFrom().getairportcode().equals(from) && vuelos.get(i).getAirportTo().
                getairportcode().equals(to) && vuelos.get(i).getAirplane().getcode().equals(airplane)
     */

    public void addflight(Airport from, Airport to, Airplane airplane, Pilot pilot, String code) {
        for (int i = 0; i < vuelos.size(); i++) {
            if (vuelos.get(i).getAirportFrom().equals(from) && vuelos.get(i).getAirportTo().equals(to) && vuelos.get(i).getAirplane().equals(airplane) && vuelos.get(i).getPilot().equals(pilot)) {
                System.out.println("The flight alrady exist");
            } else {
                Flight newFlight = new Flight(from, to, airplane, code, pilot);
                vuelos.add(newFlight);
            }
        }
    }
            //--------------------------------------- Flight --------------------------------------- //

        public void addflight (Flight flight){
            if (vuelos.contains(flight)) {
                System.out.println("Already exist a flight with that code, please enter another...");
            } else {
                vuelos.add(flight);
                System.out.println("Flight Added");
            }try {
                FileWriter writer = new FileWriter("listFlight.txt");
                for (Flight flight1: vuelos) {
                    writer.write(String.valueOf(flight1));
                    writer.write("\n");
                }
                writer.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        public void quitflight (String code){

            for (int i = 0; i < vuelos.size(); i++) {
                if (vuelos.get(i).getCode().equals(code)) {
                    vuelos.remove(i);
                    System.out.println("The flight with the code " + code + " has been deleted successfully...");
                } else {
                    System.out.println("The flight with code " + code + " does not exist.");
                }
            }
            try {
                FileWriter writer = new FileWriter("listFlight.txt");
                for (Flight flight1: vuelos) {
                    writer.write(String.valueOf(flight1));
                    writer.write("\n");
                }
                writer.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        public void printflights () {
            for (Flight i : vuelos) {
                System.out.println("Flight: " + i.getCode() + " (from: " + i.getAirportFrom().getairportcode() + " to: " + i.getAirportTo().getairportcode() + ")");
            }
            System.out.println("\n");
        }


        //Metodo para hacer la compra

        public void startPurchase (String flightCode,int quantity){

            SeatMap map = new SeatMap(5, 5, 2, 3);
            Airplane temp = new Airplane(map, "Temp");

            for (Flight i : vuelos) {
                if (i.getCode().equalsIgnoreCase(flightCode)) {
                    temp = i.getAirplane();
                }
            }

            int count = 0;

            while (count < quantity) {

                temp.print();

                int rowTemp = Scanner.getInt("Select row: ");

                if (rowTemp <= temp.getSeatMap().getRow()) {
                    int columnTemp = Scanner.getInt("Select column: ");

                    if (columnTemp <= temp.getSeatMap().getColumn()) {

                        if (temp.getSeatMap().getMap()[rowTemp - 1][columnTemp - 1].isOccupied() == true) {
                            temp.getSeatMap().getMap()[rowTemp - 1][columnTemp - 1].setStatus(false);
                            System.out.println("You succesfully reserved the seat: " + temp.getSeatMap().getMap()[rowTemp - 1][columnTemp - 1].printName() + "\n");
                            temp.getSeatMap().getMap()[rowTemp - 1][columnTemp - 1].replaceName(" FULL  ");
                            count++;
                        } else {
                            System.out.println("The seat is occupied");
                        }
                    } else {
                        System.out.println("Try again...");
                    }
            } else {
                System.out.println("Try again...");
            }
        }
    }
}


