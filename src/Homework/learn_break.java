package Homework;

public class learn_break {
    public static void main(String[] argv)
    {
        final int N = 10;
        out:
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                System.out.print("*");
                if((i+1)*(j+1)==49)
                {
                    break out;
                }
            }
            System.out.println();
        }

    }
}