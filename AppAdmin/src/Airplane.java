public class Airplane {
    SeatMap seatMap;
    String code;

    public Airplane(SeatMap seating, String code) {
        this.seatMap = seating;
        this.code = code;
    }

    public SeatMap getSeatMap() {
        return seatMap;
    }

    public String getcode() {return code;}

    public void print(){
        seatMap.print();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airplane airplane = (Airplane) o;

        return code != null ? code.equals(airplane.code) : airplane.code == null;
    }

}
