class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ch[] =new int [256];
        int i=0,j=0;
        int ans=0;
        while(j<s.length())
        {
            ch[s.charAt(j)]++;
            while(ch[s.charAt(j)]>1 && i<j)
            {
                ch[s.charAt(i)]--;
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}