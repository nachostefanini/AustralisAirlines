import java.util.Calendar;

public class Flight {
    Airport from;
    Airport to;
    Airplane airplane;
    String code;
    Pilot pilot;

    public Flight(Airport from, Airport to, Airplane airplane, String code, Pilot pilot) {
        this.from = from;
        this.to = to;
        this.airplane = airplane;
        this.code = code;
        this.pilot = pilot;
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
