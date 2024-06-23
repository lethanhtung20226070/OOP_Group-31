package Model;

public abstract class Row {
    
    protected int index;
    protected int columnA;
    protected int columnB;
    protected int columnC;
    protected boolean column0;
    protected boolean column1;

    // Constructor with columnA, columnB, columnC, column0, column1
    public Row(int columnA, int columnB, int columnC, boolean column0, boolean column1) {
        this.columnA = columnA;
        this.columnB = columnB;
        this.columnC = columnC;
        this.column0 = column0;
        this.column1 = column1;
    }

    public Row(int index, int columnA, int columnB, int columnC, boolean column0, boolean column1) {
        this.index = index;
        this.columnA = columnA;
        this.columnB = columnB;
        this.columnC = columnC;
        this.column0 = column0;
        this.column1 = column1;
    }

    // Getter and Setter methods
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public int getColumnA() {
        return columnA;
    }

    public void setColumnA(int columnA) {
        this.columnA = columnA;
    }

    public int getColumnB() {
        return columnB;
    }

    public void setColumnB(int columnB) {
        this.columnB = columnB;
    }

    public int getColumnC() {
        return columnC;
    }

    public void setColumnC(int columnC) {
        this.columnC = columnC;
    }

    public boolean isColumn0() {
        return column0;
    }

    public void setColumn0(boolean column0) {
        this.column0 = column0;
    }

    public boolean isColumn1() {
        return column1;
    }

    public void setColumn1(boolean column1) {
        this.column1 = column1;
    }

    // Abstract method to get number of columns
    public abstract int getNumberOfColumns();
}
