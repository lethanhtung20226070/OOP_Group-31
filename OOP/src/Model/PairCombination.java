package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PairCombination extends BaseMinterm {

    public PairCombination(String combinedMinterm, String indices) {
        super(indices, combinedMinterm);
    }

    public String getCombinedMinterm() {
        return binaryString;
    }

    public boolean isCombined() {
        return indices.contains(" ");
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

    // Phương thức tĩnh để chuyển đổi danh sách PairCombination thành danh sách chuỗi
    public static List<String> convertToInputPairs(List<PairCombination> pairCombinations) {
        return pairCombinations.stream()
                .map(pc -> pc.getIndices() + " " + pc.getCombinedMinterm())
                .collect(Collectors.toList());
    }
}
