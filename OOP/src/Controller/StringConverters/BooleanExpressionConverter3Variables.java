package Controller.StringConverters;

public class BooleanExpressionConverter3Variables extends BooleanExpressionConverter {

    @Override
    protected char[] getVariables() {
        return new char[] {'A', 'B', 'C'};
    }

    public static String toSOP(String[] implicants) {
        BooleanExpressionConverter3Variables converter = new BooleanExpressionConverter3Variables();
        return converter.convertToSOP(implicants);
    }

    public static String toPOS(String[] implicants) {
        BooleanExpressionConverter3Variables converter = new BooleanExpressionConverter3Variables();
        return converter.convertToPOS(implicants);
    }
}
