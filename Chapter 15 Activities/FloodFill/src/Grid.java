import java.util.Stack;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    Stack<int[]> fill = new Stack<>();

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        int[] coord = new int[]{row, column};
        fill.push(coord);

        int count = 1;
        while(!fill.isEmpty()) {
            coord = fill.pop();
            row = coord[0];
            int col = coord[1];

            if (pixels[row][col] == 0) {
                if (row != 0) {
                    fill.push(new int[]{row-1, col});
                }
                if (col != 9) {
                    fill.push(new int[]{row, col+1});
                }
                if (row != 9) {
                    fill.push(new int[]{row+1, col});
                }
                if (col != 0) {
                    fill.push(new int[]{row, col-1});
                }

                pixels[row][col] = count;
                count++;
            }
        }

        System.out.println(toString());
        
    }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
