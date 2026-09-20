class Solution {
    public int countBinarySubstrings(String s) {
        char ch[]=s.toCharArray();
        List<Integer> ls = new ArrayList<>();
        char p=ch[0];
        int c=1;
        int ans=0;
        for(int i=1;i<s.length();i++)
        {
            if(p!=ch[i])
            {ls.add(c);c=1;p=ch[i];}
            else
            c++;
        }
        ls.add(c);
        for(int i=0;i<ls.size()-1;i++)
        {
            ans+=Math.min(ls.get(i),ls.get(i+1));
        }
        return ans;
    }
}