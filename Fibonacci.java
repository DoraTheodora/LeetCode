public class testing
{
    public static void main (String[] args)
    {
        //Fibonacci
        int a = 1;
        int b = 2;
        for(int i = 0; i < 30; i++) // first 30 numbers from the Fibonacci numbers
        {
            System.out.print(a + ",");
            int c = a+b;
            a = b;
            b = c;
        }
    }
}
