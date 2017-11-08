import java.util.ArrayList;

public class ServerMOCK{
    ArrayList<Flight> vuelos = new ArrayList<>();
    ArrayList<Airport> airports = new ArrayList<>();
    ArrayList<Airplane> airplanes = new ArrayList<>();
    ArrayList<Pilot> pilots = new ArrayList<>();
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

