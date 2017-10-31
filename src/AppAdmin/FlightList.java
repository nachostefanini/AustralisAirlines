package AppAdmin;

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

            if (arreglo[0].equalsIgnoreCase(vuelos.get(i).getOrigin())  && arreglo[1].equalsIgnoreCase(vuelos.get(i).getDestination())){
                System.out.println("Se encontro vuelo directo: ");
                System.out.println( vuelos.get(i).getName() +" from: "+ vuelos.get(i).getOrigin() + " to: "+ vuelos.get(i).getDestination());
                vuelos.remove(vuelos.get(i));
                System.out.println("\n");
            }
        }

        ArrayList<Flight> temp = new ArrayList<>();

        // 1 escala...
        for (int i =0; i<vuelos.size();i++){

            if (arreglo[0].equalsIgnoreCase(vuelos.get(i).getOrigin()) ) {
                temp.add(vuelos.get(i));

                for (int j =0; j<vuelos.size();j++){

                    if (temp.get(0).getDestination().equalsIgnoreCase( vuelos.get(j).getOrigin()) && vuelos.get(j).getDestination().equalsIgnoreCase(arreglo[1])  ){

                        temp.add(vuelos.get(j));

                        System.out.println("Se encontro vuelo con 1 sola escala: ");
                        print(temp);

                        definitivo.add(temp);

                    }
                }
                temp.clear();
            }
        }


        // 2 escala...
        for (int i =0; i<vuelos.size();i++){

            if (arreglo[0].equalsIgnoreCase( vuelos.get(i).getOrigin())) {

                temp.add(vuelos.get(i));

                for (int j =0; j<vuelos.size();j++){

                    if (temp.get(0).getDestination().equalsIgnoreCase( vuelos.get(j).getOrigin())){

                        temp.add(vuelos.get(j));

                        for (int k =0; k<vuelos.size();k++){

                            if (temp.get(1).getDestination().equalsIgnoreCase( vuelos.get(k).getOrigin()) && vuelos.get(k).getDestination().equalsIgnoreCase( arreglo[1])){
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
            System.out.println("Flight: " + i.getName() + " (from: "+i.getOrigin() + " to: "+i.getDestination()+ ")");
        }
        System.out.println("\n");
    }



}


