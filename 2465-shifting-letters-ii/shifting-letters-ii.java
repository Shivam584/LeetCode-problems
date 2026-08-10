class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int sum=0;
        int t=0,i=0,d,val;
        TreeMap<Integer,Integer> mp= new TreeMap<>();
        for(int []sh : shifts)
        {
            t=(sh[2]==0) ? -1 : 1;
            mp.put(sh[0],mp.getOrDefault(sh[0],0)+t);
            mp.put(sh[1]+1,mp.getOrDefault(sh[1]+1,0)-t);
        }
        char ch[]=s.toCharArray();

        for(int k : mp.keySet())
        {
            if(i<k)
            {
                for(int j=i;j<k;j++)
                {
                    val=sum%26;
                    d=(val<0)? 26: 0;
                        ch[j]=(char)('a'+(d+val+ch[j]-'a')%26);
                }
            }
            sum+=mp.get(k);
            i=k;
        }

        return new String(ch);
    }
}