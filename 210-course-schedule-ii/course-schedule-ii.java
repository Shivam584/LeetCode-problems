class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
           Deque<Integer> dq= new ArrayDeque<>();       
       int ans[] = new int[numCourses];
        int inDegree[]=new int[numCourses];
        List<List<Integer>> ls =new  ArrayList<List<Integer>>();
        for(int i=0;i<numCourses;i++)
            ls.add(new ArrayList<Integer>());
        for(int ed[] : prerequisites)
            {
                ls.get(ed[1]).add(ed[0]);
                inDegree[ed[0]]++;
            }
        int l=0;
        for(int i=0;i<numCourses;i++)
        {
            
            if(inDegree[i]==0)
                {
                    ans[l++]=i;
                    dq.addLast(i);
                }
        }
        while(!dq.isEmpty())
        {
            int node = dq.pollFirst();
            for( int u : ls.get(node))
            {
                inDegree[u]--;
                if(inDegree[u]==0)
                {
                    dq.addLast(u);
                    ans[l++]=u;
                }
            }
        }
        if(l!=numCourses)
            ans=new int[0];
            return ans;
    }
}