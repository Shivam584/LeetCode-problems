class Solution {
    public boolean isAnagram(String s, String t) {
        int ch[]= new int[26];
        for(char c : s.toCharArray())
            ch[c-'a']++;
        for(char c : t.toCharArray())
        ch[c-'a']--;

            for(int c: ch)
            if(c!=0)
                return false;
        return true;
    }
}