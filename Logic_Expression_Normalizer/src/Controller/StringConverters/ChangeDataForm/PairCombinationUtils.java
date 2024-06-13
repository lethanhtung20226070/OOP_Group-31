/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.StringConverters.ChangeDataForm;

import Model.PairCombination;
import java.util.List;
import java.util.stream.Collectors;

/**
 * chức năng chính là chuyển đổi một danh sách các đối tượng PairCombination
 * thành một danh sách các chuỗi (List<String>). Mỗi chuỗi trong danh sách kết
 * quả được tạo ra bằng cách kết hợp hai thuộc tính của mỗi đối tượng
 * PairCombination: indices và combinedMinterm. Các thuộc tính này được nối với
 * nhau bởi một khoảng trắng để tạo thành một chuỗi đầu vào cho các tác vụ xử lý
 * tiếp theo
 *
 */
public class PairCombinationUtils {

    public static List<String> convertToInputPairs(List<PairCombination> pairCombinations) {
        return pairCombinations.stream()
                .map(pc -> pc.getIndices() + " " + pc.getCombinedMinterm())
                .collect(Collectors.toList());
    }
}
