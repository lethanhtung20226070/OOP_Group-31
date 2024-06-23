package Model;

/**
 * Lớp trừu tượng cho các đối tượng có thuộc tính indices và một chuỗi nhị phân.
 */
public abstract class BaseMinterm {
    protected String indices; // Giá trị index hoặc chỉ mục
    protected String binaryString; // Giá trị nhị phân

    public BaseMinterm(String binaryString) {
        this.binaryString = binaryString;
    }

    public BaseMinterm(String indices, String binaryString) {
        this.indices = indices;
        this.binaryString = binaryString;
    }

    public String getIndices() {
        return indices;
    }

    public void setIndices(String indices) {
        this.indices = indices;
    }

    public String getBinaryString() {
        return binaryString;
    }

    public void setBinaryString(String binaryString) {
        this.binaryString = binaryString;
    }

    @Override
    public String toString() {
        return indices + " " + binaryString;
    }
}
