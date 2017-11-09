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

        System.out.println(" ------------- Flight finder------------- ");


        //Si hay vuelo directo
        for (int i = 0; i < vuelos.size(); i++) {

            if (arreglo[0].equalsIgnoreCase(vuelos.get(i).getAirportFrom().getlocation()) && arreglo[1].equalsIgnoreCase(vuelos.get(i).getAirportTo().getlocation())) {
                System.out.println("Direct flight found: ");
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

                        System.out.println("Flight with one stop found: ");
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
                                System.out.println("Flight with two stops found: ");
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
    public void startPurchase (int quantity, String vuelo, int dni){

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

            for (Flight i : vuelos) {

                if (i.getCode().equalsIgnoreCase(vuelo)){

                    System.out.println(i.getCode());
                    i.getAirplane().print();
                    System.out.println("First Class: $500");
                    System.out.println("Couch : $100");
                    System.out.println("\n");

                    int rowTemp = Scanner.getInt("Select row: ");

                    if (rowTemp <= i.getAirplane().getSeatMap().getRow()) {
                        int columnTemp = Scanner.getInt("Select column: ");

                        if (columnTemp <= i.getAirplane().getSeatMap().getColumn()) {

                            if (i.getAirplane().getSeatMap().getMap()[rowTemp - 1][columnTemp - 1].isOccupied() == true) {

                                i.getAirplane().getSeatMap().getMap()[rowTemp - 1][columnTemp - 1].setStatus(false);
                                total += i.getAirplane().getSeatMap().getMap()[rowTemp - 1][columnTemp - 1].getPrice();

                                System.out.println("\n");
                                System.out.println("You succesfully reserved the seat: " + i.getAirplane().getSeatMap().getMap()[rowTemp - 1][columnTemp - 1].printName() +  " $"+ i.getAirplane().getSeatMap().getMap()[rowTemp - 1][columnTemp - 1].getPrice());

                                String seatName = i.getAirplane().getSeatMap().getMap()[rowTemp - 1][columnTemp - 1].printName();

                                reservados.add(i.getAirplane());
                                i.getAirplane().getSeatMap().getMap()[rowTemp - 1][columnTemp - 1].replaceName(" FULL  ");
                                count++;

                                Ticket reserva = new Ticket(i,seatName ,dni ,quantity);
                                tickets.add(reserva);
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

            }
        }
    }



    public boolean validateFlight(String code) {

        for (Flight i : vuelos) {
            if (i.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }

        return false;
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

    public void cancelTicket(int code) {

        for (Ticket i : tickets) {

            if (i.getNumero() == code){

                String seatName = i.getSeat();
                Seat[][] mapa = i.getVuelo().getAirplane().getSeatMap().getMap();

                for (int j = 0; j < mapa.length; j++) {
                    for (int k = 0; k < mapa.length; k++) {

                        if (mapa[j][k].getName().equalsIgnoreCase(seatName)){
                            mapa[j][k].setStatus(true);
                        }
                    }
                }
                tickets.remove(i);
                System.out.println("Ticket deleted");
            }
        }
    }
}

