import java.util.ArrayList;

public class ServerMOCK{

    ArrayList<Ticket> tickets = new ArrayList<>();

    ArrayList<Flight> vuelos = new ArrayList<>();
    ArrayList<Airport> airports = new ArrayList<>();
    ArrayList<Airplane> airplanes = new ArrayList<>();
    ArrayList<Pilot> pilots = new ArrayList<>();


    // ----------------------- TICKETS -----------------------/
    public void addTicket(Ticket aTicket){
       tickets.add(aTicket);
    }

    public void printTickets(){

        for (Ticket i : tickets) {
            i.print();
        }

        if (tickets.isEmpty()){
            System.out.println("The List is empty");
        }
    }


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
    public void startPurchase (int quantity, Flight vuelo){

        SeatMap map = new SeatMap(5, 5, 2, 3);
        Airplane temp = new Airplane(map, "Temp");

        ArrayList<Airplane> reservados = new ArrayList<>();

        //Esto seria validar q se puede hacer en otro metodo...
//        for (Flight i : vuelos) {
//            if (i.getCode().equalsIgnoreCase(flightCode)) {
//                temp = i.getAirplane();
//            }
//        }

        int count = 0;
        int total = 0;


        while (count < quantity) {

            System.out.println("\n");
            temp.print();
            System.out.println("First Class: $500");
            System.out.println("Couch : $100");
            System.out.println("\n");


            int rowTemp = Scanner.getInt("Select row: ");

            if (rowTemp <= temp.getSeatMap().getRow()) {
                int columnTemp = Scanner.getInt("Select column: ");

                if (columnTemp <= temp.getSeatMap().getColumn()) {

                    if (temp.getSeatMap().getMap()[rowTemp - 1][columnTemp - 1].isOccupied() == true) {
                        temp.getSeatMap().getMap()[rowTemp - 1][columnTemp - 1].setStatus(false);
                        total += temp.getSeatMap().getMap()[rowTemp - 1][columnTemp - 1].getPrice();

                        System.out.println("\n");
                        System.out.println("You succesfully reserved the seat: " + temp.getSeatMap().getMap()[rowTemp - 1][columnTemp - 1].printName() +  " $"+ temp.getSeatMap().getMap()[rowTemp - 1][columnTemp - 1].getPrice());
                        reservados.add(temp);
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
            System.out.println("Total: $" + total);

        }

        System.out.println("Final: $" + total);


        Ticket reserva = new Ticket(vuelo,total,"1234",quantity);
        tickets.add(reserva);
    }



    public  Flight validateFlight(String flight) {

        for (Flight i : vuelos) {
            if (i.getCode().equalsIgnoreCase(flight)){
                return i;
            }else {
                throw new RuntimeException("Flight does not exsist");
            }

        }

        //no me gusta para nada
        return null;
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

