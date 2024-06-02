package Controller.SetCover.GetCoverPIs;

import Model.PrimeImplicant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BooleanSimplication {

    public static List<PrimeImplicant> findEssentialPrimeImplicants(List<PrimeImplicant> primeImplicants, Set<Integer> allMinterms) {
        Map<Integer, List<PrimeImplicant>> coverageMap = new HashMap<>();
        List<PrimeImplicant> essentialPIs = new ArrayList<>();

        // Build a map of minterm to list of PIs that cover it
        for (Integer minterm : allMinterms) {
            for (PrimeImplicant pi : primeImplicants) {
                if (pi.getMinterms().contains(minterm)) {
                    coverageMap.computeIfAbsent(minterm, k -> new ArrayList<>()).add(pi);
                }
            }
        }

        // Identify essential PIs
        for (Map.Entry<Integer, List<PrimeImplicant>> entry : coverageMap.entrySet()) {
            if (entry.getValue().size() == 1) { // Only one PI covers this minterm
                PrimeImplicant essentialPI = entry.getValue().get(0);
                if (!essentialPIs.contains(essentialPI)) {
                    essentialPIs.add(essentialPI);
                }
            }
        }

        return essentialPIs;
    }

    // Hàm này tìm ra tập hợp nhỏ nhất của Non-EPIs để phủ tất cả các minterms
    public static List<PrimeImplicant> findMinimumCoverOfNonEPIs(
            List<PrimeImplicant> nonEpis,
            Set<Integer> mintermsToCover,
            List<PrimeImplicant> essentialPrimeImplicants
    ) {
        List<PrimeImplicant> selectedNonEpis = new ArrayList<>();
        Set<Integer> coveredMinterms = new HashSet<>();

        // Bao phủ ban đầu bởi EPIs
        for (PrimeImplicant epi : essentialPrimeImplicants) {
            coveredMinterms.addAll(epi.getMinterms());
        }

        // Nếu tất cả các minterms đã được phủ bởi EPIs, không cần thêm Non-EPIs
        if (coveredMinterms.containsAll(mintermsToCover)) {
            return selectedNonEpis;
        }

        // Đệ quy vét cạn để tìm các tập hợp của Non-EPIs
        return bruteForceSearch(nonEpis, new HashSet<>(mintermsToCover), coveredMinterms, 0);
    }

    private static List<PrimeImplicant> bruteForceSearch(
            List<PrimeImplicant> nonEpis,
            Set<Integer> mintermsToCover,
            Set<Integer> coveredMinterms,
            int startIndex
    ) {
        List<PrimeImplicant> bestCover = null;

        // Vét cạn từ startIndex đến cuối danh sách Non-EPIs
        for (int i = startIndex; i < nonEpis.size(); i++) {
            PrimeImplicant current = nonEpis.get(i);

            // Tạo một bản sao để không ảnh hưởng đến tập hợp ban đầu
            Set<Integer> newCoveredMinterms = new HashSet<>(coveredMinterms);
            newCoveredMinterms.addAll(current.getMinterms());

            // Kiểm tra xem tập hợp mới có phủ tất cả minterms chưa
            if (newCoveredMinterms.containsAll(mintermsToCover)) {
                // Nếu phủ tất cả, trả về tập hợp hiện tại
                List<PrimeImplicant> singleSolution = new ArrayList<>();
                singleSolution.add(current);
                return singleSolution;
            } else {
                // Nếu chưa, tiếp tục vét cạn với phần còn lại của danh sách
                List<PrimeImplicant> subSolution = bruteForceSearch(nonEpis, mintermsToCover, newCoveredMinterms, i + 1);

                // Kết hợp tập hợp hiện tại với giải pháp con và so sánh với tập hợp tốt nhất hiện có
                if (subSolution != null) {
                    subSolution.add(0, current);
                    if (bestCover == null || subSolution.size() < bestCover.size()) {
                        bestCover = subSolution;
                    }
                }
            }
        }

        // Trả về tập hợp tốt nhất tìm được
        return bestCover;
    }
}
