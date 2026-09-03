class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
            digits[n-1]++;
        if(digits[n-1]<10)
            return digits;
        int newDigits[] = new int[n+1];
        int q=0,rem=0;
        int i=n-1,l=0;
        do{
        digits[i]+=q;
        rem=digits[i]%10;
        q=digits[i]/10;
        newDigits[l]=rem;
        l++;
        i--;
        }while(i>-1 && q!=0);
        
        if(q!=0)
            {newDigits[l]=q;l++;}

        while(i>-1)
        {
          newDigits[l]=digits[i];
          l++;
          i--;   
        }
        if(l==n)
        {
            for(int j=0;j<n;j++)
                digits[j]= newDigits[n-j-1];
            return digits;
        }
         for(int j=0;j<newDigits.length/2;j++)
         {
            int temp= newDigits[j];
            newDigits[j]= newDigits[n-j];
            newDigits[n-j]=temp;
         }
        return newDigits;
    }
}