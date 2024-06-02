/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.CombineMinterms;

import Model.PairCombination;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author LENOVO
 */
public class ParityCheck {

    // Phương thức này so sánh và kết hợp các minterm nhiều lần cho đến khi không thể kết hợp thêm
    public static List<PairCombination> combineMintermsRepeatedly(List<String> minterms) {
        List<PairCombination> prevMinterms = convertToPairCombinations(minterms);
        boolean[] isCombined = new boolean[prevMinterms.size()]; // Initialize here
        List<PairCombination> newMinterms = combineMinterms(prevMinterms, isCombined); // Pass isCombined here
        while (!arePairCombinationsEqual(newMinterms, prevMinterms)) {
            prevMinterms = newMinterms;
            Arrays.fill(isCombined, false); // Reset the isCombined array
            newMinterms = combineMinterms(prevMinterms, isCombined); // Pass isCombined here
        }
        return newMinterms;
    }

    // Hỗ trợ phương thức chuyển đổi từ List<String> sang List<PairCombination>
    private static List<PairCombination> convertToPairCombinations(List<String> minterms) {
        List<PairCombination> pairCombinations = new ArrayList<>();
        for (int i = 0; i < minterms.size(); i++) {
            pairCombinations.add(new PairCombination(minterms.get(i), "(" + i + ")"));
        }
        return pairCombinations;
    }
    // Hỗ trợ phương thức so sánh hai danh sách PairCombination

    private static boolean arePairCombinationsEqual(List<PairCombination> list1, List<PairCombination> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).getCombinedMinterm().equals(list2.get(i).getCombinedMinterm())) {
                return false;
            }
        }
        return true;
    }

    // Phương thức này so sánh và kết hợp các minterm
    public static List<PairCombination> combineMinterms(List<PairCombination> pairCombinations, boolean[] isCombined) {
        List<PairCombination> combinedPairs = new ArrayList<>();
        Arrays.fill(isCombined, false);

        for (int i = 0; i < pairCombinations.size(); i++) {
            for (int j = i + 1; j < pairCombinations.size(); j++) {
                String a = pairCombinations.get(i).getCombinedMinterm();
                String b = pairCombinations.get(j).getCombinedMinterm();
                String result = combine(a, b);
                if (result != null) {
                    combinedPairs.add(new PairCombination(result, pairCombinations.get(i).getIndices() + "," + pairCombinations.get(j).getIndices()));
                    isCombined[i] = true;
                    isCombined[j] = true;
                }
            }
            if (!isCombined[i]) {
                combinedPairs.add(pairCombinations.get(i)); // Add as is if not combined
            }
        }

        return combinedPairs;
    }

    private static String combine(String a, String b) {
        char[] result = new char[a.length()];
        int differences = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                result[i] = a.charAt(i);
            } else {
                differences++;
                result[i] = '_';
            }
        }

        // Chỉ kết hợp khi có một bit khác nhau
        if (differences == 1) {
            return new String(result);
        } else {
            return null;
        }
    }

    public static List<PairCombination> combinePairCombinations(List<PairCombination> pairs) {
        List<PairCombination> combinedPairs = new ArrayList<>();
        Set<String> uniqueMinterms = new HashSet<>();

        for (int i = 0; i < pairs.size(); i++) {
            for (int j = i + 1; j < pairs.size(); j++) {
                if (canCombine(pairs.get(i).getCombinedMinterm(), pairs.get(j).getCombinedMinterm())) {
                    String result = combine(pairs.get(i).getCombinedMinterm(), pairs.get(j).getCombinedMinterm());
                    if (result != null && !uniqueMinterms.contains(result)) {
                        combinedPairs.add(new PairCombination(result, pairs.get(i).getIndices() + "," + pairs.get(j).getIndices()));
                        uniqueMinterms.add(result); // Đánh dấu đã thêm minterm này
                    }
                }
            }
        }

        return combinedPairs;
    }

    public static List<PairCombination> findPrimeImplicants(List<PairCombination> pairCombinations) {
        List<PairCombination> primeImplicants = new ArrayList<>();
        boolean[] isCombined = new boolean[pairCombinations.size()];
        List<PairCombination> combinedPairs = combineMinterms(pairCombinations, isCombined);

        // Add only those which haven't been combined to the list of prime implicants
        for (int i = 0; i < pairCombinations.size(); i++) {
            if (!isCombined[i]) {
                primeImplicants.add(pairCombinations.get(i));
            }
        }

        return primeImplicants;
    }

    // Kiểm tra xem hai minterm có thể kết hợp được không (đơn giản chỉ cần xem chúng khác nhau ở đúng một bit)
    private static boolean canCombine(String a, String b) {
        return combine(a, b) != null;
    }

}
