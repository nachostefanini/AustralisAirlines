package AppAdmin;

public class Flight {
    Airport from;
    Airport to;
    Airplane airplane;
    Pilot pilot;

    public Flight(Airport from, Airport to, Airplane airplane, Pilot pilot) {
        this.from = from;
        this.to = to;
        this.airplane = airplane;
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

    public Pilot getPilot() {
        return pilot;
    }
}
