public class TextGraphic {
    private char[][] grid;

    private static TextGraphic instance;

    public static TextGraphic getInstance() {
        if (instance == null) {
            instance = new TextGraphic();
        }
        return instance;
    }

    public void init(int width, int height) {
        grid = new char[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public void drawPoint(char c, int x, int y) {
        int wid = grid.length;
        int hei = grid[0].length;
        if ((x >= 0 && x < wid) && (y >= 0 && y < hei)) {
            grid[x][y] = c;
        }
    }

    public void drawLine(char c, int x1, int y1, int x2, int y2) {
        int wid = grid.length;
        int hei = grid[0].length;
        if (x1 < 0 || x2 < 0 || x1 >= wid || x2 >= wid || y1 < 0 || y2 < 0 || y1 >= hei || y2 >= hei) return;

        while (x1 <= x2 || y1 <= y2) {
            grid[x1][y1] = c;
            x1++;
            y1++;
        }
        while (x1 <= x2) {
            grid[x1][y1] = c;
            x1++;
        }
        while (y1 <= y2) {
            grid[x1][y1] = c;
            y1++;
        }
    }

    public void fillRect(char c, int x, int y, int width, int height) {
        for (int i = x; i < width + x; i++) {
            for (int j = y; j < height + y; j++) {
                grid[i][j] = c;
            }
        }
    }

    public void render() {
        int wid = grid.length;
        int hei = grid[0].length;
        for (int i = 0; i < wid; i++) {
            for (int j = 0; j < hei; j++) {
                System.out.print(grid[i][j]);
                //line.append(grid[i][j] + ' ');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TextGraphic graphics = TextGraphic.getInstance();
        graphics.init(15, 10);
        graphics.drawPoint('*', 1, 1);
        graphics.fillRect('o', 5, 5, 3, 2);
        graphics.render();
    }
}