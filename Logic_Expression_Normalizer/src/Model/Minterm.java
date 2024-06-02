
package Model;

/**
 *
 * @author LENOVO
 */
public class Minterm {
    private String value;//giá trị index
    private String minterm;// giá trị nhị phân để tí so sánh 

    public Minterm(String minterm) {
        this.minterm = minterm;
    }

    public Minterm(String value, String minterm) {
        this.value = value;
        this.minterm = minterm;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMinterm() {
        return minterm;
    }

    public void setMinterm(String minterm) {
        this.minterm = minterm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        sb.append(" ").append(minterm);
        return sb.toString();
    }
    
}
