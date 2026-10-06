class Solution {
    void reverse (char ch[],int n)
    {
        int i=0,j=n-1;
        char temp;
        while(i<j)
        {
            temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            i++;
            j--;
        }
    }
    public int minInsertions(String s) {
        char ch1[]= s.toCharArray();
        char ch2[]= s.toCharArray();
        int n=ch1.length;
        reverse(ch2,n);
        int ans[][]= new int[n+1][n+1];

        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0 || j==0)
                    ans[i][j]=0;
                else if(ch1[i-1]==ch2[j-1])
                    ans[i][j]=1+ans[i-1][j-1];
                else
                    ans[i][j]=Math.max(ans[i][j-1],ans[i-1][j]);
            }
        }
        return n-ans[n][n];
    }
}
