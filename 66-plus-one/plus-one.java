class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int q=1;
        int i=n-1;
        while(i>-1 && q!=0)
        {
            digits[i]+=q;
            q=digits[i]/10;
            digits[i]%=10;
            i--;
        } 
        
        if(q!=0)
        {
            int newDigits[] = new int[n+1];
            newDigits[0]=q;
            for(int j=0;j<n;j++)
                    newDigits[j+1]=digits[j];
                digits=newDigits;
        }
        return digits;
    }
}