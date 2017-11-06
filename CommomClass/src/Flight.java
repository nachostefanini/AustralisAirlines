public class Flight {
    Airport from;
    Airport to;
    Airplane airplane;
    String code;
    Pilot pilot;

    Airport[] data = new Airport[2];

    public Flight(Airport from, Airport to, Airplane airplane, String code ,Pilot pilot) {
        this.from = from;
        this.to = to;
        this.airplane = airplane;
        this.pilot = pilot;
        this.code = code;

        data[0] = from;
        data[1] = to;
    }
    public Airport getAirportFrom() { return from; }

    public Airport getAirportTo() { return to; }

    public Airplane getAirplane() {
        return airplane;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public String getCode(){
        return code;
    }



}
