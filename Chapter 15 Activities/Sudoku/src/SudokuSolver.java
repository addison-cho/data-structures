import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SudokuSolver {
    private final int M = 3;
    private final int N = M * M;
    private int[][] grid;
    private ArrayList<Set<Integer>> rows;
    private ArrayList<Set<Integer>> cols;
    private ArrayList<Set<Integer>> squares;
    private Set<Integer> nums;

    public SudokuSolver(String fileName) {
        // read the puzzle file
        try (Scanner in = new Scanner(new File(fileName))) {

            this.grid = new int[N][N];

            for (int row = 0; row < N; row++) {
                String line = in.next();

                for (int col = 0; col < N; col++) {
                    String strVal = line.substring(col, col + 1);
                    int number;
                    if (strVal.equals("x")) {
                        number = 0;
                    } else {
                        number = Integer.parseInt(strVal);
                    }
                    this.grid[row][col] = number;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + fileName);
        }


        // create the list of sets for each row (this.rows)
        rows = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Set<Integer> row = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                row.add(this.grid[i][j]);
            }
            rows.add(row);
        }

        // create the list of sets for each col (this.cols)
        cols = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Set<Integer> col = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                col.add(this.grid[j][i]);
            }
            cols.add(col);
        }

        //System.out.println(rows);
        //System.out.println(cols);

        // create the list of sets for each square (this.squares)
        /* the squares are added to the list row-by-row:
            0 1 2
            3 4 5
            6 7 8
        */
        squares = new ArrayList<>();

        /*
         * goes through a row at a time, split into groups of three rows
         * goes through cols, switching which square set is being added to every three
         * after three rows are run through, add squares and reset all for next three rows
         */
        for (int squareRow = 0; squareRow < 3; squareRow++) {

            int startRow = squareRow*3;
            
            Set<Integer> square1 = new HashSet<>();
            Set<Integer> square2 = new HashSet<>();
            Set<Integer> square3 = new HashSet<>();

            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = 0; j < N; j++) {
                    if (j < 3) {
                        square1.add(this.grid[i][j]);
                    }
                    
                    else if (j < 6) {
                        square2.add(this.grid[i][j]);
                    }
                    
                    else {
                        square3.add(this.grid[i][j]);
                    }
                }
            }

            squares.add(square1);
            squares.add(square2);
            squares.add(square3);

        }


        // create a hash set for [1..9] (this.nums)
        this.nums = new HashSet<>();
        for (int x = 1; x <= N; x++) {
            nums.add(x);
        }

        // visually inspect that all the sets are correct
        for (int row = 0; row < N; row++) {
            System.out.println("row " + row + ": " + this.rows.get(row));
        }
        for (int col = 0; col < N; col++) {
            System.out.println("col " + col + ": " + this.cols.get(col));
        }
        for (int square = 0; square < N; square++) {
            System.out.println("square " + square + ": " + this.squares.get(square));
        }
        System.out.println(this.nums);
    }

    public boolean solve() {
        // find an empty location, if any
        boolean finished = true;
        int nextRow = -1;
        int nextCol = -1;
        for (int row = 0; row < N && finished; row++) {
            for (int col = 0; col < N && finished; col++) {
                if (this.grid[row][col] == 0) {
                    finished = false;
                    nextRow = row;
                    nextCol = col;
                }
            }
        }

        // the board is complete; we solved it
        if (finished) {
            return true;
        }

        // get all possible numbers for the row and column we are trying to populate
        /*
            Create a new set based on the this.nums and remove all elements in the sets
            corresponding to nextRow, nextCol, and the corresponding square (use the
            removeAll method).

            Properly indexing the squares list of sets is tricky. Verify that your
            algorithm is correct.
         */
        Set<Integer> possibleNums = new HashSet<Integer>();
        possibleNums.addAll(this.nums);
        
        Set<Integer> row = rows.get(nextRow);
        Set<Integer> col = cols.get(nextCol);

        int squareIndex = nextRow/3*3 + nextCol/3;
        Set<Integer> sq = squares.get(squareIndex);

        // removes duplication nums
        for (int num = 1; num <= 9; num++) {
            if (row.contains(num) || col.contains(num) || sq.contains(num)) {
                possibleNums.remove(num);
            }
        }

        // if there are no possible numbers, we cannot solve the board in its current state
        if (possibleNums.isEmpty()) {
            return false;
        }

        // try each possible number
        for (Integer possibleNum : possibleNums) {
            // update the grid and all three corresponding sets with possibleNum
            
            this.grid[nextRow][nextCol] = possibleNum;
            row.add(possibleNum);
            col.add(possibleNum);
            sq.add(possibleNum);
        
            // recursively solve the board
            if (this.solve()) {
                // the board is solved!
                return true;
            } else {
                /*
                Undo the move before trying another possible number by setting the corresponding
                element in the grid back to 0 and removing possibleNum from all three corresponding
                sets.
                */
                this.grid[nextRow][nextCol] = 0;
                row.remove(possibleNum);
                col.remove(possibleNum);
                sq.remove(possibleNum);
            }
        }

        return false;
    }

    public String toString() {
        String str = "";

        for (int[] row : grid) {
            for (int val : row) {
                str += val + "\t";
            }

            str += "\n";
        }

        return str;
    }

    public static void main(String[] args) {
        String fileName = "Chapter 15 Activities/Sudoku/src/puzzle1.txt";

        SudokuSolver solver = new SudokuSolver(fileName);
        System.out.println(solver);

        if (solver.solve()) {
            System.out.println("Solved!");
            System.out.println(solver);
        } else {
            System.out.println("Unsolveable...");
        }
        
    }
}