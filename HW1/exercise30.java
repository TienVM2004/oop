import java.lang.Math;
/*
Write the shortest Java program you can that takes an integer command-line argument n and prints true
if (1 + 2 + ... + n) 2 is equal to (13 + 23 + ... + n3).
 */
public class exercise30 {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int tong1 =0;
        int tong2 =0;
        for(int i=1;i<=n;i++){
            tong1 += i;
            tong2 += (int)Math.pow(i,3);
        }
        tong1 = (int)Math.pow(tong1,2);
        boolean result = tong1 == tong2;
        System.out.println(result);
    }
}
