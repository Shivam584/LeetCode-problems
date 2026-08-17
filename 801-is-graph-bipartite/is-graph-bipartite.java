class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        boolean v[]= new boolean[n];
        int color[] = new int[n];
        for(int i=0;i<n;i++)
            if(!v[i])
            {
                v[i]=true;
                Deque<Integer> dq= new ArrayDeque<Integer>();
                dq.addLast(i);
                v[i]=true;
                while(!dq.isEmpty())
                {
                    int l=dq.size();
                    for(int j=0;j<l;j++)
                    {
                    int k=dq.pollFirst();
                    int newColor=1-color[k];
                        for(int pt: graph[k])
                        {
                            if(v[pt]==false)
                                {
                                    color[pt]=newColor;
                                    v[pt]=true;
                                    dq.addLast(pt);
                                }
                            else if(color[pt]==color[k])
                                return false;
                        }
                    }
                }
            }
        return true;
    }
}