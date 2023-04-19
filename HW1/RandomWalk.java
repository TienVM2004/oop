public class RandomWalk {

    public static void main(String[] args) {
        int n = Integer.parseInt("9");
        StdDraw.setScale(-n - 0.5, n + 0.5);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        int x = 0, y = 0;
        int steps = 0;
        int num=1;
        while (Math.abs(x) < n && Math.abs(y) < n) {
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(x, y, 0.45);
            for(int i=1;i<=num;i++){
                y += Math.pow(-1,num);
                StdDraw.filledSquare(x, y, 0.45);
            }
            for(int i=1;i<=num;i++){
                x += Math.pow(-1,num);
                StdDraw.filledSquare(x, y, 0.45);
            }
            num++;
            steps++;
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledSquare(x, y, 0.45);
            StdDraw.show();
            StdDraw.pause(400);
        }
        StdOut.println("Total steps = " + steps);
    }

}