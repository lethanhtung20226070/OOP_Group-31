package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimeImplicant {

    Set<Integer> minterms; // Set of minterm indices this PI covers
    String implicant; // Representation of the implicant, e.g., "10-"

    public PrimeImplicant(Set<Integer> minterms, String implicant) {
        this.minterms = minterms;
        this.implicant = implicant;
    }

    public Set<Integer> getMinterms() {
        return minterms;
    }

    public String getImplicant() {
        return implicant;
    }

    public static List<PrimeImplicant> parseInputPairs(List<String> inputPairs) {
        List<PrimeImplicant> primeImplicants = new ArrayList<>();
        for (String pair : inputPairs) {
            String[] parts = pair.split(" ");
            Set<Integer> minterms = parseMinterms(parts[0]);
            String implicant = parts[1];
            primeImplicants.add(new PrimeImplicant(minterms, implicant));
        }
        return primeImplicants;
    }

    private static Set<Integer> parseMinterms(String mintermPart) {
        mintermPart = mintermPart.replaceAll("[()]", ""); // Remove parentheses
        Set<Integer> minterms = new HashSet<>();
        for (String minterm : mintermPart.split(",")) {
            try {
                minterms.add(Integer.parseInt(minterm.trim())); // trim to remove any leading or trailing spaces
            } catch (NumberFormatException e) {
                System.err.println("Error parsing integer from input: '" + minterm + "'");
                // Handle error or continue
            }
        }
        return minterms;
    }
}
