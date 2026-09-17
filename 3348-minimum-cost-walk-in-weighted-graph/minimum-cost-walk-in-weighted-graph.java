class UnionFind
{
    int t[];
    int rank[];
    public int rs[];

    int n;
    public UnionFind(int n)
    {
        t= new int[n];
        rank= new int[n];
        rs= new int[n];
        this.n=n;
        for(int i=0;i<n;i++)
        {
            t[i]=i;
            rank[i]=0;
            rs[i]=-1;
        }
    }
    int find(int x)
    {
        if(t[x]==x)
            return x;
        return t[x]=find(t[x]);
    }

    void union(int a,int b)
    {
        int pa=find(a);
        int pb=find(b);
        if(rank[pa]>rank[pb])
            t[pb]=t[pa];
        else if(rank[pa]<rank[pb])
            t[pa]=t[pb];
        else
        { 
         t[pb]=t[pa];
           rank[pa]++;
        } 

    }
}
class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        UnionFind uf= new UnionFind(n);
        int ans[] = new int[query.length];
        for(int ed[] : edges )
        {
            int u=ed[0];
            int v=ed[1];
            uf.union(u,v);
        }

           for(int ed[] : edges )
            uf.rs[uf.find(ed[0])]=uf.rs[uf.find(ed[0])]&ed[2];
        

        for(int i=0;i<query.length;i++)
        {
            if(uf.find(query[i][0])==uf.find(query[i][1]))
                ans[i]=uf.rs[uf.find(query[i][0])];
            else 
                ans[i]=-1;

        }

        return ans;
    }
}