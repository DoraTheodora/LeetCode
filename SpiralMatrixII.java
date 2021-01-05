Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:
Input: n = 1
Output: [[1]]
 
Constraints:
1 <= n <= 20

class Solution {
    public int[][] generateMatrix(int n) 
    {
        int top = 0;
        int bottom = n-1;
        int left = 0; 
        int right = n-1;
        int number = n*n;
        
        int[][] spiral = new int[n][n];
        int element = 1;
        int index = 0;
        while(element <= number)
        {
            index = left;
            while(index <= right)
                spiral[top][index++] = element++;
            top++;
            
            index = top;
            while(index <= bottom)
                spiral[index++][right] = element++;
            right--;
            
            index = right;
            while(index >= left)
                spiral[bottom][index--]= element++;
            bottom--;
            
            index = bottom;
            while(index >= top)
                spiral[index--][left]= element++;
            left++;
    
        }
        prinMatrix(spiral, n);  
        
        return spiral;
    }
    
    public void prinMatrix(int[][] x, int n)
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                System.out.print(x[i][j] + " ");
            System.out.println();
        }
    }
}
