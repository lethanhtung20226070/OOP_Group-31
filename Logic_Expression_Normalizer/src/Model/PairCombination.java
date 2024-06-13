package Model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PairCombination {

    private String combinedMinterm;
    private String indices;

    public PairCombination(String combinedMinterm, String indices) {
        this.combinedMinterm = combinedMinterm;
        this.indices = indices;
    }

    public String getCombinedMinterm() {
        return combinedMinterm;
    }

    public String getIndices() {
        return indices;
    }

    public boolean isCombined() {
        return indices.contains(" ");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(indices);
        sb.append(" ").append(combinedMinterm);
        return sb.toString();
    }

    
}
