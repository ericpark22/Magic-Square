import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MagicSquaresDriver
{
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(new File("squares.txt"));

        int cases = input.nextInt();
        while(cases > 0)
        {
            int n = input.nextInt();
            MagicSquare magicSquare = new MagicSquare(n);

            int i = 0;
            while(i < n*n)
            {
                magicSquare.add(input.nextInt());
                i++;
            }

            System.out.println(magicSquare);
            System.out.println(magicSquare.isMagical() + "\n");

            cases--;
        }
    }
}