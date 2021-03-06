import java.time.LocalDate;
import java.util.Calendar;

public class Flight {
    Airport from;
    Airport to;
    Airplane airplane;
    String code;
    Pilot pilot;
    LocalDate date;

    public Flight(Airport from, Airport to, Airplane airplane, String code, Pilot pilot, LocalDate date) {
        this.from = from;
        this.to = to;
        this.airplane = airplane;
        this.code = code;
        this.pilot = pilot;
        this.date = date;
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

    public LocalDate getDate(){
        return date;
    }


}
