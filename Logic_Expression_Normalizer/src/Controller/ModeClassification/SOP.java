/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ModeClassification;

/**
 *
 * @author LENOVO
 */
public class SOP {

    private int index;

    public SOP(int index) {
        this.index = index;
    }

    public String toStringThree() {
        StringBuilder sb = new StringBuilder();
        String binary = convertToBinaryThree(index);
        sb.append("(").append(index).append(") ").append(binary).append("\n");
        return sb.toString();
    }

    public String toStringFour() {
        StringBuilder sb = new StringBuilder();
        String binary = convertToBinaryFour(index);
        sb.append("(").append(index).append(") ").append(binary).append("\n");
        return sb.toString();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String convertToBinaryThree(int index) {
        var minterm = Integer.toBinaryString(index);
        while (minterm.length() < 3) {
            minterm = "0" + minterm;
        }
        return minterm;
    }

    public String convertToBinaryFour(int index) {
        var minterm = Integer.toBinaryString(index);
        while (minterm.length() < 4) {
            minterm = "0" + minterm;
        }
        return minterm;
    }
}
