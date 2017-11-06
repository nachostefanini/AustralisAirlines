public class Sandbox {
    public static void main (String[]args){

        //For admin to do
        int row = Scanner.getInt("Insert the number of rows: ");
        int column = Scanner.getInt("Insert the number of columns: ");

        int fc = 0;
        int c = 0;

        while ((fc + c) != row){
            fc = Scanner.getInt("Insert the number of first class rows: ");
            c = Scanner.getInt("Insert the number of couch rows: ");
        }

        SeatMap a = new SeatMap(row,column,fc,c);

        //For client to do
        int pax = Scanner.getInt("Insert quantity: ");

        int count = 0;

        while (count<pax){

            a.print();

            int rowTemp = Scanner.getInt("Select row: ");

            if (rowTemp <= row){
                int columnTemp = Scanner.getInt("Select column: ");

                if (columnTemp <= column){

                    if (a.getMap()[rowTemp-1][columnTemp-1].isOccupied() == true){
                        a.getMap()[rowTemp-1][columnTemp-1].setStatus(false);
                        System.out.println("You succesfully reserved the seat: " + a.getMap()[rowTemp-1][columnTemp-1].printName() + "\n");
                        a.getMap()[rowTemp-1][columnTemp-1].replaceName(" FULL  ");
                        count++;

                    }else {
                        System.out.println("The seat is occupied");
                    }

                }else {
                    System.out.println("Try again...");
                }

            }else {
                System.out.println("Try again...");
            }
        }
    }

}
