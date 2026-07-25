class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> ls= new ArrayList<>();
        double slope,ang,qd=0;
        int self=0;
        for(List<Integer> point : points)
        {
            int y=point.get(1)-location.get(1);
            int x=point.get(0)-location.get(0);
            if(x==0)
                {
                    if(y==0)
                        self++;
                    else
                        ls.add(y>0 ? 90.0 : 270.0);
                }
            else
                {
                qd=Math.toDegrees(Math.atan2(y,x));
                if (qd < 0)
                    qd += 360;
                ls.add(qd);
                }
           
        }
        Collections.sort(ls);
        int i=0,j=0;
        
        int c=0,max_c=0,n=ls.size();

         while(j<n)
        {
            ls.add(360+ls.get(j));
            j++;
        }
        j=0;
        while(j<ls.size())
        {
            c++;
                while(i<j && (ls.get(j)-ls.get(i))>angle)
                {
                    c--;
                    i++;
                }
            // System.out.println(ls.get(j)+" "+(ls.get(i)+angle));
            max_c=Math.max(max_c,c);
            j++;
        }
        return max_c+self;
    }
}