public class testing
{
    public static void main (String[] args)
    {
//        Write a function that reverses a string. The input string is given as an array of characters char[].
//        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//        You may assume all the characters consist of printable ascii characters.
//
//        Example 1:
//        Input: ["h","e","l","l","o"]
//        Output: ["o","l","l","e","h"]
//        Example 2:
//
//        Input: ["H","a","n","n","a","h"]
//        Output: ["h","a","n","n","a","H"]

        char[] s = new char[]{'h','e','l','l','o','o'};
        int low = 0;
        int high = s.length-1;
        while(low < high && low != high)
        {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }

        for(int i = 0; i < s.length; i++)
            System.out.print(s[i] + ",");
    }
}
