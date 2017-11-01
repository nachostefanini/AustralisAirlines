package AppAdmin;

public class Flight {
    Airport from;
    Airport to;
    Airplane airplane;
    Pilot pilot;
    String code;
/*
    int dia;
    int horario;
    fecha desde;
    fecha hasta;
    Un vuelo siempre es entre dos aeropuertos conocidos y están planificados para un dia de la semana y horario en particular,
    y tienen un código. Además tienen una fecha desde y hasta que determinan un rango de semanas en donde ese vuelo se repite,
    conservando siempre el mismo código de vuelo. Un vuelo también tiene vinculado un avión
*/

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
