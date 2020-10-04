public class testing
{
    public static void main(String[] args)
    {
//        Write a function that takes a string as input and reverse only the vowels of a string.
//
//        Example 1:
//        Input: "hello"
//        Output: "holle"
//        Example 2:
//
//        Input: "leetcode"
//        Output: "leotcede"
//        Note:
//        The vowels does not include the letter "y".

        String s = "Ae";
        int low = 0;
        int high = s.length() - 1;
        System.out.println(s);
        char[] test = s.toCharArray();
        while (low <= high)
        {
            if(high==low)
                break;

            while (!isVowel(test[low]))
            {
                if(low == test.length-1)
                    break;
                else
                    low++;
            }
            while (!isVowel(test[high]))
            {
                if (high > low)
                {
                    high--;
                }
                else
                    break;
            }
            if(high >= low) {
                char temp = test[low];
                test[low] = test[high];
                test[high] = temp;
            }
            low++;
            high--;
        }
        s = new String(test);

        System.out.println(s);
    }
    static boolean isVowel(char theChar)
    {
        if(theChar == 'a' || theChar == 'e' || theChar=='i' || theChar=='o' || theChar == 'u'
            || theChar == 'A' || theChar == 'E' || theChar=='I' || theChar=='O' || theChar == 'U')
            return true;
        return false;
    }

}

