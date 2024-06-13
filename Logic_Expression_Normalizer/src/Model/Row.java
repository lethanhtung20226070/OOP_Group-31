/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LENOVO
 */
public class Row {

    private int index;
    private int columnA;
    private int columnB;
    private int columnC;
    private int columnD;
    private boolean column0;
    private boolean column1;

    public Row() {
    }

    public Row(int index, int columnA, int columnB, int columnC) {
        this.index = index;
        this.columnA = columnA;
        this.columnB = columnB;
        this.columnC = columnC;
    }

    public Row(int index, int columnA, int columnB, int columnC, int columnD) {
        this.index = index;
        this.columnA = columnA;
        this.columnB = columnB;
        this.columnC = columnC;
        this.columnD = columnD;
    }

    public Row(boolean column0, boolean column1) {
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

    public Row(int index, int columnA, int columnB, int columnC, int columnD, boolean column0, boolean column1) {
        this.index = index;
        this.columnA = columnA;
        this.columnB = columnB;
        this.columnC = columnC;
        this.columnD = columnD;
        this.column0 = column0;
        this.column1 = column1;
    }

    public Row(boolean column0) {
        this.column0 = column0;
    }

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

    public int getColumnD() {
        return columnD;
    }

    public void setColumnD(int columnD) {
        this.columnD = columnD;
    }

}
