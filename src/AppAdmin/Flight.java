package AppAdmin;

public class Flight {
    String from;
    String to;
    Airplane airplane;
    String code;
    Pilot pilot;

    String[] data = new String[2];

    public Flight(String from, String to, Airplane airplane, String code ,Pilot pilot) {
        this.from = from;
        this.to = to;
        this.airplane = airplane;
        this.pilot = pilot;
        this.code = code;

        data[0] = from;
        data[1] = to;
    }

    public String getOrigin(){
        return data[0];
    }

    public String getDestination(){
        return data[1];
    }

    public String getName() {
        return code;
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
