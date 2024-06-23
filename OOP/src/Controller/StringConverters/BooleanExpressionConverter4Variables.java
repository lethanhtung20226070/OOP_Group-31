package Controller.StringConverters;

public class BooleanExpressionConverter4Variables extends BooleanExpressionConverter {

    @Override
    protected char[] getVariables() {
        return new char[] {'A', 'B', 'C', 'D'};
    }

    public static String toSOP(String[] implicants) {
        BooleanExpressionConverter4Variables converter = new BooleanExpressionConverter4Variables();
        return converter.convertToSOP(implicants);
    }

    public static String toPOS(String[] implicants) {
        BooleanExpressionConverter4Variables converter = new BooleanExpressionConverter4Variables();
        return converter.convertToPOS(implicants);
    }
}
