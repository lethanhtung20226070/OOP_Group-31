/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.StringConverters;

/**
 *
 * @author LENOVO
 */
public class BooleanExpressionConverter4Variables {
    public static String toSOP(String[] implicants) {
        char[] variables = {'A', 'B', 'C','D'};
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

    public static String toPOS(String[] implicants) {
        char[] variables = {'A', 'B', 'C','D'};
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
        if(pos.toString().equals("()")){
            pos.delete(0, 2);
        }
        return pos.toString();
    }
}
