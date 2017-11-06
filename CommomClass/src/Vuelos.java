public class Vuelos {
    Airport from;
    Airport to;
    Airplane airplane;
    String code;
    Pilot pilot;

    public Vuelos(Airport from, Airport to, Airplane airplane, String code, Pilot pilot) {
        this.from = from;
        this.to = to;
        this.airplane = airplane;
        this.code = code;
        this.pilot = pilot;
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

    public String getCode() {
        return code;
    }

    public Pilot getPilot() {
        return pilot;
    }
}
