class Solution {
    public String maxSumOfSquares(int num, int sum) {
            char ch[]= new char[num];
            int i=0,x=sum;
            while(i<num)
            {
                x=Math.min(sum,9);
                sum-=x;
                ch[i]=(char)(x+'0');
                i++;
            }       
        if(sum!=0)
            return "";
        return new String(ch);
    }
}