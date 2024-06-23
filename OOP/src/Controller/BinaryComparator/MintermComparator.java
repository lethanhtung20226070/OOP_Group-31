package Controller.BinaryComparator;

import Model.BaseMinterm;
import java.util.Comparator;

/*
Lớp này được dùng để sắp xếp các đối tượng dựa trên chuỗi nhị phân của chúng.
*/
public class MintermComparator implements Comparator<BaseMinterm> {

    @Override
    public int compare(BaseMinterm m1, BaseMinterm m2) {
        int countOnesM1 = countOnes(m1.getBinaryString());
        int countOnesM2 = countOnes(m2.getBinaryString());

        // Nếu số lượng chữ số '1' giống nhau, so sánh giá trị nhị phân
        if (countOnesM1 == countOnesM2) {
            // Giả sử binaryString là một chuỗi nhị phân, chuyển đổi nó thành số nguyên và so sánh
            return Integer.compare(Integer.parseInt(m1.getBinaryString(), 2), Integer.parseInt(m2.getBinaryString(), 2));
        }
        // Nếu không, sắp xếp theo số lượng '1'
        return Integer.compare(countOnesM1, countOnesM2);
    }

    // Phương thức trợ giúp để đếm số lượng '1' trong một chuỗi nhị phân
    private int countOnes(String binary) {
        return (int) binary.chars().filter(ch -> ch == '1').count();
    }
}
