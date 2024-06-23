package Model;

public class Rowfor4Variables extends Row {

    private int columnD;

    // Constructor with columnA, columnB, columnC, columnD, column0, column1
    public Rowfor4Variables(int columnA, int columnB, int columnC, int columnD, boolean column0, boolean column1) {
        super(columnA, columnB, columnC, column0, column1);
        this.columnD = columnD;
    }
      public Rowfor4Variables(int index, int columnA, int columnB, int columnC, int columnD, boolean column0, boolean column1) {
        super(index, columnA, columnB, columnC, column0, column1);
        this.columnD = columnD;
    }

    public int getColumnD() {
        return columnD;
    }

    public void setColumnD(int columnD) {
        this.columnD = columnD;
    }

    @Override
    public int getNumberOfColumns() {
        return 4;
    }

    // toString method for better readability when printing
    @Override
    public String toString() {
        return "Rowfor4Variables{" +
                "columnA=" + columnA +
                ", columnB=" + columnB +
                ", columnC=" + columnC +
                ", columnD=" + columnD +
                ", column0=" + column0 +
                ", column1=" + column1 +
                '}';
    }
}
