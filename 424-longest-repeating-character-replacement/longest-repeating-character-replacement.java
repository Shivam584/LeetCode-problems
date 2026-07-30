class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,j=0,ans=0,count=0;
        Map<Character,Integer> mp = new HashMap<>();
        while(j<s.length())
        {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j),0)+1);
            count=Math.max(count,mp.get(s.charAt(j)));
            while(j-i+1-count>k)
            {
                mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i),0)-1);
                i++; 
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}

