class Solution {
    public String maxSumOfSquares(int num, int sum) {
            StringBuilder sb= new StringBuilder();
            int i=0,x=sum;
            while(i<num)
            {
                x=Math.min(sum,9);
                sum-=x;
                sb.append((char)(x+'0'));
                i++;
            }       
        if(sum!=0)
            return "";
        return sb.toString();
    }
}