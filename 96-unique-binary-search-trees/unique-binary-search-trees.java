class Solution {
    public int numTrees(int n) {
        int nums[]= new int[n+1];
        nums[0]=1;
        nums[1]=1;
        
        for(int j=2;j<=n;j++)
        {
            int i=0,k=j-1;
            while(i<k)
            {
                nums[j]+=2*nums[i]*nums[k];
                i++;
                k--;
            }
            if(j%2==1)
                nums[j]+=nums[j/2]*nums[j/2];
            
        }
        return nums[n];
    }
}

// 1 -> 1, 1
// 2 -> 2, 2*n(0,1)
// 3->  5, 2*n(2,0) + n(1,1) 
// 4 -> 14 , 2*(n(3,0) + n(2,1)) = 5 + 2*1 + 1*2 + 5 = 14
// 5->  2*(4,0 3,1) + (2,2) 