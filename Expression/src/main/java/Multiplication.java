public class Multiplication implements Expression{
    Expression left;
    Expression right;

    Multiplication(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }
    public int evaluate(){
        return left.evaluate() * right.evaluate();
    }
    public String toString(){
        String strAdd = "";
        strAdd +="(";
        strAdd += left.toString();
        strAdd += " * ";
        strAdd += right.toString();
        strAdd += ")";
        return strAdd;
    }

}
//