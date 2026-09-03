class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        digits[n-1]++;
        if(digits[n-1]==10)
        {
        int q=0,rem=0;
        int i=n-1;

        do{
        digits[i]+=q;
        q=digits[i]/10;
        digits[i]%=10;
        i--;
        }while(i>-1 && q!=0);
        
        if(q!=0)
            {
                int newDigits[] = new int[n+1];
                newDigits[0]=q;
                for(int j=0;j<n;j++)
                      newDigits[j+1]=digits[j];
                    digits=newDigits;
            }
        }
        return digits;
    }
}