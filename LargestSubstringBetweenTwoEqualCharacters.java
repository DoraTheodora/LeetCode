Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.

A substring is a contiguous sequence of characters within a string.

Example 1:
Input: s = "aa"
Output: 0
Explanation: The optimal substring here is an empty substring between the two 'a's.

Example 2:
Input: s = "abca"
Output: 2
Explanation: The optimal substring here is "bc".

Example 3:
Input: s = "cbzxy"
Output: -1
Explanation: There are no characters that appear twice in s.

Example 4:
Input: s = "cabbac"
Output: 4
Explanation: The optimal substring here is "abba". Other non-optimal substrings include "bb" and "".

Constraints:
1 <= s.length <= 300
s contains only lowercase English letters.

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) 
    {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            if(!map.containsKey(s.charAt(i)))
            {
                ArrayList<Integer> IndexDuplicate = new ArrayList<>();
                IndexDuplicate.add(i);
                IndexDuplicate.add(0);
                IndexDuplicate.add(1);
                map.put(s.charAt(i), IndexDuplicate);
            }
            else
            {
                ArrayList<Integer> IndexDuplicate = new ArrayList<>();
                IndexDuplicate = map.get(s.charAt(i));
                IndexDuplicate.set(1, i); 
                IndexDuplicate.set(2, 2);
                map.put(s.charAt(i), IndexDuplicate);
            }
        }
        for(Character key: map.keySet())
            System.out.println("Key: " + key + "-->" + map.get(key));
        return maxSubstring(map);
    }
    public int maxSubstring(HashMap<Character, ArrayList<Integer>> map)
    {
        int this_max = -1;
        int max = -1;
        
        for(Character key: map.keySet())
        {
            ArrayList<Integer> IndexDuplicate = new ArrayList<>();
            IndexDuplicate = map.get(key);
            if(IndexDuplicate.get(2) == 2)
            {
                this_max = IndexDuplicate.get(1) - IndexDuplicate.get(0) -1;
                if(this_max > max)
                    max = this_max;
            }
        }
        return max;
    }
}
