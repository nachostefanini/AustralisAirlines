package AppAdmin;

public class Flight {
    Airport from;
    Airport to;
    Airplane airplane;
    Pilot pilot;
    String code;

    public Flight(Airport from, Airport to, Airplane airplane, Pilot pilot, String code) {
        this.from = from;
        this.to = to;
        this.airplane = airplane;
        this.pilot = pilot;
        this.code = code;
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }

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
