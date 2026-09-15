class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length, n2=nums2.length;
            if(n1>n2)
                return findMedianSortedArrays(nums2,nums1);
            int p=(n1+n2+1)/2;
            int l=Math.min(p,p-n1),h=Math.max(p,p-n1);
            int mid1=0,mid2=0,l1=0,l2=0,r1=0,r2=0;
            while(l<=h)
            {
                mid2=l+(h-l)/2;
                mid1=p-mid2;
                l1=mid1-1>=0 && mid1-1<n1 ? nums1[mid1-1] : Integer.MIN_VALUE;
                r1=mid1>=0 && mid1<n1 ? nums1[mid1] : Integer.MAX_VALUE;
                l2=mid2-1>=0 && mid2-1<n2 ? nums2[mid2-1] : Integer.MIN_VALUE;
                r2=mid2>=0 && mid2<n2 ? nums2[mid2] : Integer.MAX_VALUE;
                if(l1<=r2 && l2<=r1)
                    break;
                else if(l1>r2)
                    l=mid2+1;
                else
                    h=mid2-1;               
            }
        if((n1+n2)%2==1)
            return Math.max(l1,l2);
        
        return (Math.max(l2,l1)+Math.min(r2,r1))/2.0;
    }
}