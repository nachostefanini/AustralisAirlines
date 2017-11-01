package AppAdmin;

public class Flight {
    /*
        int dia;
        int horario;
        fecha desde;
        fecha hasta;
        Un vuelo siempre es entre dos aeropuertos conocidos y están planificados para un dia de la semana y horario en particular,
        y tienen un código. Además tienen una fecha desde y hasta que determinan un rango de semanas en donde ese vuelo se repite,
        conservando siempre el mismo código de vuelo. Un vuelo también tiene vinculado un avión
    */
    
    public Flight(String from, String to, Airplane airplane, Pilot pilot, String code) {
        this.from = from;
        this.to = to;
        this.airplane = airplane;
        this.pilot = pilot;
        this.code = code;
    }
    String from;
    String to;
    Airplane airplane;
    Pilot pilot;

    String code;

    public String getOrigin() {
        return from;
    }

    public String getDestination() {return to;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public String getName(){
        return code;
    }
}
