public abstract class Seat {

    boolean status = true;
    String name;
    int price;
    String type;


    public Seat (){
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setName(String string) {
        name += string;
    }

    public void replaceName(String name){
        this.name=name;
    }

    public boolean isOccupied(){
        return status;
    }

    public String printName(){
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

