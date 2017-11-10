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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        return airportcode != null ? airportcode.equals(airport.airportcode) : airport.airportcode == null;
    }

}
