
class Solution {
    public int cal(int height[],int n,int id)
    {
        int sum=0;
        int l=0;
        for(int i=0;i<id;i++)
        {
            if(height[i]>l)
                l=height[i];
            sum+=Math.min(l,height[id])-height[i];
        }
        return sum;
    }
    public int trap(int[] height) {
        int id=0,maxHeight=0,n=height.length;
        for(int i=0;i<n;i++)
            {
                if( maxHeight<height[i])
                    {
                        id=i;
                        maxHeight=height[i];
                    }
            }
        int res=cal(height,n,id),temp;
        for(int i=0;i<n/2;i++)
        {
            temp=height[i];
            height[i]=height[n-i-1];
            height[n-i-1]=temp;
        }
        res+=cal(height,n,n-id-1);
        return res;
    }
}