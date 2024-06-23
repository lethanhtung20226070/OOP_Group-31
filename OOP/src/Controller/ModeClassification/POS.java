package Controller.ModeClassification;

/**
 *
 * @author Nam Cường đẹp trai
 */
public class POS {

    private int index;

    public POS(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
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
