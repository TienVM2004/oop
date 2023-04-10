public class Numeral implements Expression{
    private int value;
    Numeral(int val){
        value = val;
    }
    public String toString(){
        String strValue = String.valueOf(value);
        return strValue;
    }
    public int evaluate(){
        return value;
    }
}
