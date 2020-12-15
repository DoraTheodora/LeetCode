Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.


class Solution {
    public boolean isValid(String s) 
    {
        if(s.length() == 1)
            return false;
        Stack<Character> myStack = new Stack<>();
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
                myStack.push(s.charAt(i));
            else if(s.charAt(i) == '[')
                myStack.push(s.charAt(i));
            else if(s.charAt(i) == '{')
                myStack.push(s.charAt(i));
            
            else if(s.charAt(i) == ')')
            {
                if(myStack.isEmpty())
                    return false;
                char fromStack = myStack.pop();
                if(fromStack != '(')
                   return false;
            }
            else if(s.charAt(i) == ']')
            {
                if(myStack.isEmpty())
                    return false;
                char fromStack = myStack.pop();
                if(fromStack != '[')
                   return false;
            }
            else if(s.charAt(i) == '}')
            {
                if(myStack.isEmpty())
                    return false;
                char fromStack = myStack.pop();
                if(fromStack != '{')
                   return false;
            }
        }
        if(myStack.isEmpty())
            return true;
        else
            return false;
    }
}
