public class Addition extends Expression{
    Expression left;
    Expression right;

    Addition(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }
    public int evaluate(){
        return left.evaluate() + right.evaluate();
    }
    public String toString(){
        String strAdd = "";
        strAdd +="(";
        strAdd += left.toString();
        strAdd += " + ";
        strAdd += right.toString();
        strAdd += ")";
        return strAdd;
    }

}
