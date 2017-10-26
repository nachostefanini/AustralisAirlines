package AppAdmin;

public class Airport {
    String airportcode;
    String location;

    public Airport(String airportcode, String location) {
        this.airportcode = airportcode;
        this.location = location;
    }

    public String getairportcode() {
        return this.airportcode;
    }

    public String getlocation(){
        return this.location;
    }
}
