class UnionFind
{
    int arr[];
    int rank[];
    UnionFind(int n)
    {
        arr= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=i;
        rank= new int[n];
    }

    int find(int id)
    {
        if(arr[id]==id)
            return id;
        
        return arr[id]=find(arr[id]);
    }

    boolean union(int a,int b)
    {
        int pa=find(a);
        int pb=find(b);
        if(rank[pa]>rank[pb])
        arr[pa]=arr[pb];
        else if(rank[pa]>rank[pb])
        arr[pb]=arr[pa];
        else
        {
            arr[pb]=arr[pa];
            rank[pa]++;
        }
        return pa==pb;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int ans=0,n=edges.length;
        UnionFind unionFind = new UnionFind(n+1);
        for(int i=0;i<n;i++)
            {
                if(unionFind.union(edges[i][0],edges[i][1]))
                    ans=i;
            }
        return edges[ans];
    }
}