public class Seat {

    String name;
    boolean status = true;

    public Seat(String name) {
        this.name = name;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOccupied(){
        return status;
    }

    public String printName(){
        return name;
    }


}
