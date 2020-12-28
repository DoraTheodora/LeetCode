Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]

class Solution 
{
    public String reverseStr(String s, int k) 
    {
        StringBuilder reversed = new StringBuilder();
        boolean reversing = true;
        int index = 0;
        while(index < s.length())
        {
            if(reversing)
            {
                if((index+k) < s.length())
                {
                    reversed.append(reverse(s.substring(index, index+k)));
                    reversing = false;
                }
                else
                    reversed.append(reverse(s.substring(index)));
            }
            else
            {
                if((index+k) < s.length())
                {
                    reversed.append(s.substring(index, index+k));
                    reversing = true;
                }
                else
                {
                    reversed.append(s.substring(index));
                }
            }
            index = index+k;
        }
        System.out.println(reversed);
        return reversed.toString();
    }
    public String reverse(String s)
    {
        StringBuilder r = new StringBuilder();
        r.append(s);
        r.reverse();
        return r.toString();
    }
}
