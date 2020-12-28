Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

Example:
Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
 
Note:
1 <= paragraph.length <= 1000.
0 <= banned.length <= 100.
1 <= banned[i].length <= 10.
The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
There are no hyphens or hyphenated words.
Words only consist of letters, never apostrophes or other punctuation symbols.

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) 
    {
        paragraph = paragraph.toLowerCase();
        paragraph = stripSigns(paragraph);
        paragraph = paragraph.trim().replaceAll(" +", " ");
        String[] p = paragraph.split(" ");
        
        HashMap<String, Integer> words = new HashMap<>();
        HashSet<String> ban = new HashSet<>();
        ban = bannedWords(banned);
        words = wordsFreq(p, words);
        
        return mostFreqWord(ban, words);
    }
    
    public String mostFreqWord(HashSet<String> banned, HashMap<String, Integer> words)
    {
        String answer ="";
        int max = 0;
        for(String key: words.keySet())
        {
            if(words.get(key) > max && !banned.contains(key))
            {
                max = words.get(key);
                answer = key;
            }
        }
        return answer;
    }
    
    public HashSet<String> bannedWords(String[] b)
    {
        HashSet<String> s = new HashSet<>();
        for(int i = 0; i < b.length; i++)
        {
            if(!s.contains(b[i]))
                s.add(b[i]);
        }
        return s;
    }
    
    public String stripSigns(String p)
    {
        StringBuilder stripped = new StringBuilder();
        for(int i = 0; i < p.length(); i++)
        {
            if((p.charAt(i) >= 'a' && p.charAt(i) <= 'z'))
                stripped.append(p.charAt(i));
            else
                stripped.append(" ");
        }
        return stripped.toString();
    }
    
    public HashMap<String, Integer> wordsFreq(String[] p, HashMap<String, Integer> freq)
    {
        for(int i = 0; i < p.length; i++)
        {
            if(freq.containsKey(p[i]))
            {
                int count = freq.get(p[i]);
                count++;
                freq.put(p[i], count);
            }
            else
                freq.put(p[i], 1);
        }
        
        for(String key: freq.keySet())
            System.out.println("Key: " + key + " : " + freq.get(key));
        return freq;
    }
}
