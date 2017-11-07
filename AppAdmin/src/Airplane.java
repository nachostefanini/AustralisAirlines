public class Airplane {
    SeatMap seatMap;
    String code;

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
