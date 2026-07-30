class Solution {
    public int lengthOfLongestSubstring(String s) {
      int count[]= new int [256];
      int i=0,j=0,n=s.length(),ans=0;
      while(j<n)
      {
        count[s.charAt(j)]++;
        while(i<j &&count[s.charAt(j)]>1)
        {
            count[s.charAt(i)]--;
            i++;
        }
        ans=Math.max(ans,j-i+1);
        j++;
      }
      return ans;
    }
}