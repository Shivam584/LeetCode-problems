class Solution {
    double bfs( Map<Double,List<double[]>> mp, double a,double b)
    {
        Set<Double> s=new HashSet<>();
        Deque<double[]> q= new ArrayDeque<>();
        q.addLast(new double[]{a,1.0});
        s.add(a);
        while(!q.isEmpty())
        {
            int n=q.size();
            for(int i=0;i<n;i++)
            {
               double node[]=q.pollFirst();
               List<double[]> ls = mp.get(node[0]);
                for(double[] p : ls)
                {
                    if(p[0]==b)
                        return node[1]*p[1];
                    if(!s.contains(p[0]))
                        {
                            s.add(p[0]);
                            q.addLast(new double[]{p[0],p[1]*node[1]});
                        }
                }
            }
        }
        return -1;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Double> lookup= new HashMap<>();
        Map<Double,List<double[]>> mp = new HashMap<>();
        int l=0,i=0;
        for(List<String> eq : equations)
        {
            Double a=lookup.get(eq.get(0));
            if(a==null)
                a=1.0*l++;
            Double b=lookup.get(eq.get(1));
            if(b==null)
                b=1.0*l++;
            lookup.put(eq.get(0),a);
            lookup.put(eq.get(1),b);
            double val=values[i];
            double invVal=1.0/val;
            List<double[]> ls1=mp.get(a);
            if(ls1==null)
                ls1= new ArrayList<double[]>();   
            List<double[]> ls2=mp.get(b);      
            if(ls2==null)
                ls2= new ArrayList<double[]>();    
            ls1.add(new double[]{b,val});       
            ls2.add(new double[]{a,invVal});  
            mp.put(a,ls1);
            mp.put(b,ls2);      
            i++;    
        }
        int n=queries.size();
        double ans[]= new double[n];
        i=0;
        for(List<String> q : queries)
        {
            Double a= lookup.get(q.get(0));
            Double b= lookup.get(q.get(1));
            if(a==null || b==null)
                ans[i]=-1.0;
            else
                ans[i]=bfs(mp,a,b);
            i++;
        }

        return ans;
    }
}