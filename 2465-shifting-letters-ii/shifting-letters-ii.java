class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int sum=0;
        int t,d,v;
        int val[]= new int[s.length()+1];
        for(int[] sh : shifts)
        {
            t=(sh[2]==0) ? -1: 1;
            val[sh[0]]+=t;
            val[sh[1]+1]-=t;
        }
        char ch[]=s.toCharArray();

        for(int i=0;i<s.length();i++)
        {
            sum+=val[i];
            if(sum!=0)
            {
                v=sum%26;
                d=(v<0)? 26: 0;
                ch[i]=(char)('a'+(d+v+ch[i]-'a')%26);
            }
            
        }

        return new String(ch);
    }
}