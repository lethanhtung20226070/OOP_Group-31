package Controller.StringConverters;

public abstract class BooleanExpressionConverter {
    protected abstract char[] getVariables();

    protected String convertToSOP(String[] implicants) {
        char[] variables = getVariables();
        StringBuilder sop = new StringBuilder();

        for (String implicant : implicants) {
            StringBuilder term = new StringBuilder();
            for (int i = 0; i < implicant.length(); i++) {
                if (implicant.charAt(i) != '_') { // Ignore don't cares
                    if (term.length() > 0) {
                        term.append(" . ");
                    }
                    term.append(implicant.charAt(i) == '1' ? variables[i] : variables[i] + "'");
                }
            }
            if (sop.length() > 0) {
                sop.append(" + ");
            }
            sop.append(term);
        }

        return sop.toString();
    }

    protected String convertToPOS(String[] implicants) {
        char[] variables = getVariables();
        StringBuilder pos = new StringBuilder();

        for (String implicant : implicants) {
            StringBuilder term = new StringBuilder("(");
            for (int i = 0; i < implicant.length(); i++) {
                if (implicant.charAt(i) != '_') { // Ignore don't cares
                    if (term.length() > 1) {
                        term.append(" + ");
                    }
                    term.append(implicant.charAt(i) == '0' ? variables[i] : variables[i] + "'");
                }
            }
            term.append(")");
            if (pos.length() > 0) {
                pos.append(" . ");
            }
            pos.append(term);
        }
        return pos.toString();
    }
}
