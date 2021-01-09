We are given two strings, A and B.
A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false

Note:
A and B will have length at most 100.

class Solution {
    public boolean rotateString(String A, String B) 
    {
        if(A.length() == 0 && B.length() == 0)
            return true;
        else if(A.length() == 0 || B.length() == 0)
            return false;
        else if(A.equals(B))
            return true;
        HashSet<String> shift = new HashSet<>();
        shift = shifting(A);
        
        return check(shift, B);
    }
    
    public boolean check(HashSet<String> s, String B)
    {
        for(String str: s)
            if(str.equals(B))
                return true;
        return false;
    }
    
    public HashSet<String> shifting(String s)
    {
        String initial = s;
        int index = 0;
        HashSet<String> shift = new HashSet<>();
        while(index < s.length())
        {
            s = shift(s);
            shift.add(s);
            index++;
        }
        return shift;
    }
    
    public String shift(String s)
    {
        StringBuilder shifted = new StringBuilder();
        char firstChar = s.charAt(0);
        for(int i = 1; i < s.length(); i++)
            shifted.append(s.charAt(i));
        shifted.append(firstChar);
        return shifted.toString();
    }
}
