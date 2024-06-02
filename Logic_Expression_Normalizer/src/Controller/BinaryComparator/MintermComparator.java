/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.BinaryComparator;

import Model.Minterm;
import java.util.Comparator;

/*
Lớp này được dùng để sắp xếp các minterm ban đầu dựa trên các binary
*/
public class MintermComparator implements Comparator<Minterm> {

    @Override
    public int compare(Minterm m1, Minterm m2) {
        int countOnesM1 = countOnes(m1.getMinterm());
        int countOnesM2 = countOnes(m2.getMinterm());

        // Nếu số lượng chữ số '1' giống nhau, so sánh giá trị nhị phân
        if (countOnesM1 == countOnesM2) {
            // Giả sử minterm là một chuỗi nhị phân, chuyển đổi nó thành số nguyên và so sánh
            return Integer.compare(Integer.parseInt(m1.getMinterm(), 2), Integer.parseInt(m2.getMinterm(), 2));
        }
        // Nếu không, sắp xếp theo số lượng '1'
        return Integer.compare(countOnesM1, countOnesM2);
    }

    // Phương thức trợ giúp để đếm số lượng '1' trong một chuỗi nhị phân
    private int countOnes(String binary) {
        return (int) binary.chars().filter(ch -> ch == '1').count();
    }
}
