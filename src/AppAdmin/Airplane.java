package AppAdmin;

public class Airplane {
    SeatMap seatMap;
    String code;
    /*int precio1;
    int precio 2;
    Un vuelo también tiene vinculado un avión, donde cada avión tiene un código único y un mapa de asientos y un tarifario
    de precios por categoría de asientos. Hay distintas categorías de asientos, por lo que las categorías deben ser dinámicas.
    */


    public Airplane(SeatMap seating, String code) {
        this.seatMap = seating;
        this.code = code;
    }

    public SeatMap getseats() {
        return seatMap;
    }

    public String getcode() {return code;}

    public void print(){
        seatMap.print();
    }

}
