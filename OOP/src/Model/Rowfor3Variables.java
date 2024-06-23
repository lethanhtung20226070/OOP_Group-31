package Model;

public class Rowfor3Variables extends Row {

    // Constructor with columnA, columnB, columnC, column0, column1
    public Rowfor3Variables(int columnA, int columnB, int columnC, boolean column0, boolean column1) {
        super(columnA, columnB, columnC, column0, column1);
    }

    // Constructor with index, columnA, columnB, columnC, column0, column1
    public Rowfor3Variables(int index, int columnA, int columnB, int columnC, boolean column0, boolean column1) {
        super(index, columnA, columnB, columnC, column0, column1);
    }
    
    @Override
    public int getNumberOfColumns() {
        return 3;
    }

    // toString method for better readability when printing
    @Override
    public String toString() {
        return "Rowfor3Variables{" +
                "index=" + index +
                ", columnA=" + columnA +
                ", columnB=" + columnB +
                ", columnC=" + columnC +
                ", column0=" + column0 +
                ", column1=" + column1 +
                '}';
    }
}
