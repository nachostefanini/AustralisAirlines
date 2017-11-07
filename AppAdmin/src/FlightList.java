import java.util.ArrayList;

public class FlightList {

    ArrayList<Flight> vuelos;

    public FlightList(ArrayList<Flight> vuelos) {
        this.vuelos = vuelos;
    }

    public void find(String[] arreglo){

        ArrayList<ArrayList<Flight>> definitivo = new ArrayList<>();


        //Si hay vuelo directo
        for (int i =0; i<vuelos.size();i++){

            if (arreglo[0].equalsIgnoreCase(vuelos.get(i).getAirportFrom().getlocation())  && arreglo[1].equalsIgnoreCase(vuelos.get(i).getAirportTo().getlocation())){
                System.out.println("Direct flight found: ");
                System.out.println( vuelos.get(i).getCode() +" from: "+ vuelos.get(i).getAirportFrom().getlocation() + " to: "+ vuelos.get(i).getAirportTo().getlocation());
                vuelos.remove(vuelos.get(i));
                System.out.println("\n");
            }
        }

        ArrayList<Flight> temp = new ArrayList<>();

        // 1 escala...
        for (int i =0; i<vuelos.size();i++){

            if (arreglo[0].equalsIgnoreCase(vuelos.get(i).getAirportFrom().getlocation()) ) {
                temp.add(vuelos.get(i));

                for (int j =0; j<vuelos.size();j++){

                    if (temp.get(0).getAirportTo().getlocation().equalsIgnoreCase( vuelos.get(j).getAirportFrom().getlocation()) && vuelos.get(j).getAirportTo().getlocation().equalsIgnoreCase(arreglo[1])  ){

                        temp.add(vuelos.get(j));

                        System.out.println("Flight with one stop found: ");
                        print(temp);

                        definitivo.add(temp);

                    }
                }
                temp.clear();
            }
        }


        // 2 escala...
        for (int i =0; i<vuelos.size();i++){

            if (arreglo[0].equalsIgnoreCase( vuelos.get(i).getAirportFrom().getlocation())) {

                temp.add(vuelos.get(i));

                for (int j =0; j<vuelos.size();j++){

                    if (temp.get(0).getAirportFrom().getlocation().equalsIgnoreCase( vuelos.get(j).getAirportFrom().getlocation())){

                        temp.add(vuelos.get(j));

                        for (int k =0; k<vuelos.size();k++){

                            if (temp.get(1).getAirportTo().getlocation().equalsIgnoreCase( vuelos.get(k).getAirportFrom().getlocation()) && vuelos.get(k).getAirportTo().getlocation().equalsIgnoreCase( arreglo[1])){
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

// Total
//        System.out.println("Total");
//            return definitivo;
    }

    //Metodos para imprmir

    //It doesnt work
//    public void pasar(ArrayList<ArrayList<Flight>> arreglo){
//        for (ArrayList<Flight> i: arreglo) {
//            print(i);
//        }
//    }
    public void print(ArrayList<Flight> arreglo){
        for (Flight i : arreglo) {
            System.out.println("Flight: " + i.getCode() + " (from: "+i.getAirportFrom().getlocation() + " to: "+i.getAirportTo().getlocation()+ ")");
        }
        System.out.println("\n");
    }



}


