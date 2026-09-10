class Solution {
    public int maxProfit(int k, int[] prices) {
        int b[]= new int[k];
        int s[]= new int[k];
        
        for(int i=0;i<k;i++)
        {
            b[i]=Integer.MIN_VALUE;
            s[i]=Integer.MIN_VALUE;
        }
        
        for(int price : prices)
        {
            int temp=0;
            for(int j=0;j<k;j++)
            {
                b[j]=Math.max(b[j],temp-price);
                s[j]=Math.max(s[j],price+b[j]);
                temp=s[j];
            }
        }

        return s[k-1];
    }
}