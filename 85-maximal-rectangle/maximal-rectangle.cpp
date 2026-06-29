class Solution {
public:
    int mah(int n,vector<int> &a)
    {
        int ans=0;
        stack<int> s;
        vector<int> v;
         for(int i=n-1;i>=0;i--)
        {
            while(!s.empty()&&a[s.top()]>=a[i])
                s.pop();
            if(s.empty())
                v.push_back(n);
            else
                v.push_back(s.top());
        s.push(i);
         }
        reverse(v.begin(),v.end());
  
        while(!s.empty())
            s.pop();
        
         for(int i=0;i<n;i++)
         {
              while(!s.empty()&&a[s.top()]>=a[i])
                s.pop();
             
                if(s.empty())
                v[i]=v[i]*a[i];
            else
                v[i]=(v[i]-s.top()-1)*a[i];
             
             s.push(i);
             
             ans=max(ans,v[i]);
        }
        return ans;
    }
    int maximalRectangle(vector<vector<char>>& b) {
        int ans=0,n=b.size(),m=b[0].size(),i=0;
        vector<int> a(m);
        while(i<n)
        {
            for(int j=0;j<m;j++)
            {
                if(b[i][j]=='0')
                    a[j]=0;
                else
                    a[j]+=1;
            }

            ans=max(ans,mah(m,a));
            i++;
        }
        return ans;
    }
};