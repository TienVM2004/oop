public class Square implements Expression{
    Expression ex;
    Square(Expression expression){
        ex = expression;
    }
    public int evaluate() {
        return ex.evaluate() * ex.evaluate();
    }
    public String toString(){
        String strSquare = "";
        strSquare += String.valueOf(ex.toString());
        strSquare += "^2";
        return strSquare;
    }
}
//
