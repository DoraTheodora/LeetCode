Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Example 3:

Input: digits = [0]
Output: [1]
 

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9

Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
Memory Usage: 37.2 MB, less than 97.20% of Java online submissions for Plus One.

class Solution {
    public int[] plusOne(int[] digits) 
    {
        //printArray(addOne(digits));
        return addOne(digits);
    }
    
    public int[] addOne(int[] digits)
    {
        if(digits.length == 1)
        {
            if(digits[0] < 9)
            {
                digits[0] = digits[0]+1;
                return digits;
            }
            else
            {
                int[] newNumber = new int[digits.length+1];
                int sum = digits[0]+1;
                newNumber[1] = sum%10;
                newNumber[0] = sum/10;
                return newNumber;
            }
            
        }
        int carry = 1;
        int index = digits.length-1;
        while(carry > 0)
        {
            int sum = digits[index] + carry;

            int digit = sum%10;
            carry = sum/10;

            digits[index] = digit;
            index--;
            if(index == 0 && carry == 1 && digits[index] < 9)
            {
                digits[index] = digits[index] + carry;
                return digits;
            }
            else if(index == 0 && carry == 1 && digits[index] == 9)
            {
                int[] newNumber = new int[digits.length+1];
                newNumber[0] = carry;
                newNumber[1] = digit;
                for(int i = 2; i < digits.length; i++)
                {
                    newNumber[i] = digits[i-1];
                }
                return newNumber;   
            } 
        }
        return digits;
    }
    
    
    public void printArray(int[] digits)
    {
        for(int i = 0; i < digits.length; i++)
            System.out.print(digits[i] + "");
    }


}
