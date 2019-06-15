/*
This program determines if the given square  is a "magical square". A square is magical if all the values added up horizontally, vertically, and diagonally are the same. A square
is created based on the int n^2 and is filled through numbers in a text file. Different methods to check the rows, columns, and diagonal values are used to determine
if the square is magical.
*/
public class MagicSquare
{
    private int[][] square;
    private int row; // used to determine next board position open
    private int column; // used to determine next board position open

    /**
     * Constructs an n by n MagicSquare
     * @param n
     */
    public MagicSquare(int n)
    {
        square = new int[n][n];
        row = 0;
        column = 0;
    }

    /**
     * Inserts x at the index i, the next available
     *  slot following row-major order.
     * @param x
     */
    public void add(int x)
    {
        square[row][column] = x; // inserts x value into open position
        column++;

        if(column >= square[0].length) // if column reaches the length of the array
        {
            column = 0; // sets back to 0
            row++; // goes to new row
        }
    }

    /**
     * @param nums
     * @return The sum of nums
     */
    private int sum(int[] nums)
    {
        int sum = 0;

        for(int i = 0; i < nums.length; i++)
            sum += nums[i]; // adds each number in nums to sum

        return sum;
    }

    /**
     * @return The constant that each row, column,
     *          and diagonal should add-up to.
     */
    private int getConstant()
    {
        int sum = 0;

        for(int r = 0; r < square[0].length; r++) // gets first row sum
            sum += square[0][r]; // adds each number in the first row to sum

        return sum;
    }

    /**
     * @return true if each row, column, and diagonal
     *          add-up to the constant; false otherwise
     */
    public boolean isMagical()
    {
        if(isMagicalColumns() && isMagicalDiagonals() && isMagicalRows()) // if the columns, diagonals, and rows are all magical
            return true;

        return false;
    }

    /**
     * @return true if each row adds-up to the constant;
     *          false otherwise
     */
    private boolean isMagicalRows()
    {
        for(int r = 0; r < square.length; r++) // goes through each row
            if(sum(square[r]) != getConstant()) // if all the sums in the row do not add up to the magical number
                return false; // not magical

        return true;
    }

    /**
     * @return true if each column adds-up to the constant;
     *          false otherwise
     */
    private boolean isMagicalColumns()
    {
        int sum = 0;

        for(int c = 0; c < square[0].length; c++) // column major order
        {
            for (int r = 0; r < square.length; r++)
                sum += square[r][c]; // adds the column values to num

            if(sum != getConstant()) // if the column values do not add up to the magical number
                return false; // not magical

            sum = 0; // sum set back to 0 for the next column test
        }

        return true;
    }

    /**
     * @return true if each diagonal adds-up to the constant;
     *          false otherwise
     */
    private boolean isMagicalDiagonals()
    {
        int indexFirst = 0; // index for first diagonal spot ([0][0], [1][1], [2][2], etc.)
        int sumFirst = 0; // sum for first diagonal

        // [1][3], [2][2], [3][1], etc.
        int indexSecondRow = 0; // index for second diagonal spot (row)
        int indexSecondColumn = square.length - 1; // index for second diagonal spot (column)
        int sumSecond = 0; // sum for second diagonal


        for(int i = 0; i < square.length; i++) // amount of diagonal numbers = length of square
        {
            sumFirst += square[indexFirst][indexFirst]; // adds the diagonal number to sum
            sumSecond += square[indexSecondRow][indexSecondColumn]; // adds the second diagonal number to sum
            indexFirst++; // increments diagonal index
            indexSecondRow++; // decreases row index for the second diagonal
            indexSecondColumn--; // decreased column index for the second diagonal
        }



        if(sumFirst != getConstant() || sumSecond != getConstant()) // if the sum of all the diagonal numbers do not add up to the magical number
            return false; // not magical

        return true;
    }

    /**
     * @return A String representation of this MagicSquare.
     */
    public String toString()
    {
        String rtn = "";

        for(int[] row : square)
        {
            for (int element : row)
                rtn += element + "\t";
            rtn += "\n";
        }

        return rtn;
    }
}
