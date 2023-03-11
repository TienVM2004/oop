/*
Lockers. Your are in a locker room with 100 open lockers, numbered 1 to 100.
Toggle all of the lockers that are even. By toggle, we mean close if it is open, and open if it is closed.
Now toggle all of the lockers that are multiples of three. Repeat with multiples of 4, 5, up to 100.
How many lockers are open?
Answer: lockers 1, 4, 9, 16, 25, ..., 100 will be open. Guess you don't need an array once you see the pattern.
 */
public class Lockers {
    public static void main(String[] args){
        boolean[] lockers = new boolean[101];
        for(int i=0;i<101;i++){
            lockers[i]=true;
        }
        for(int i=2;i<101;i++){
            for(int j=i;j<101;j+=i){
                lockers[j] = !lockers[j];
            }
        }
        for(int i=1;i<101;i++){
            if(lockers[i]) {
                System.out.println(i);
            }
        }
    }
}
