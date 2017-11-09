public class SeatMap {

    Seat aSeat;

    String[] rowLetter = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T"};

    int row;
    int column;
    Seat[][] map;

    int fc;
    int c;


    public SeatMap(int row, int column, int fc, int c) {

        if (row<20){
            this.row = row;
        }else {
            throw new RuntimeException("Too big");
        }

        if (column<20){
            this.column = column;
        }else {
            throw new RuntimeException("Too big");
        }
        this.fc=fc;
        this.c=c;

        map = new Seat[row][column];
        map = fillSeatMap(map);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Seat[][] getMap() {
        return map;
    }

    public Seat getaSeat() {
        return aSeat;
    }

    public Seat[][] fillSeatMap(Seat[][] matrix) {

        for (int i = 0; i < fc; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = new FirstClass();
                matrix[i][j].setName(rowLetter[i] + " " + (j+1));
            }
        }

        for (int i = fc; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = new Couch();
                matrix[i][j].setName(rowLetter[i] + " " + (j+1));
            }
        }

        return matrix;
    }

    public void print() {
        String str = "\t";
        System.out.println("------------ SEATS ------------");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                //This means that the last case will not have the separation "-"
                if (j+1 == column){
                    str += map[i][j].printName()  + "\t";

                }else{
                    str += map[i][j].printName() + "  -" + "\t";
                }
            }
            System.out.println(str);
            str = "\t";
        }
    }

//    public static void main(String[]args){
//        AppAdmin.SeatMap a = new AppAdmin.SeatMap(19,19);
//        a.print();
//
//    }

}
