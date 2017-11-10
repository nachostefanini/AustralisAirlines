public class Pilot {
    String name;
    String surname;
    String dni;

    public Pilot(String name, String surname,String dni) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDni() {return dni;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pilot pilot = (Pilot) o;

        return dni != null ? dni.equals(pilot.dni) : pilot.dni == null;
    }

}
