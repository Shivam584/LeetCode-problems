class Pair
{
    int a,b;
    Pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}
class UnionFind
{
    int arr[];
    int rank[];
    int n;
    UnionFind(int n)
    {
        rank= new int[n];
        arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=i;
        }
        this.n=n;
    }

    int parent(int a)
    {
        if(arr[a]==a)
            return a;
        return arr[a]=parent(arr[a]);
    }
    int union(int a,int b)
    {
        int pa=parent(a);
        int pb=parent(b);
        if(pa==pb)
            return 1;

        if(rank[pa]<rank[pb])
            arr[pa]=b;
        else if(rank[pa]>rank[pb])
            arr[pb]=a;
        else
        {
           arr[pa]=b;
           rank[pa]++;  
        }  
        return 0;
    }

    int totalSwapCount()
    {
        Map<Integer,Integer> mp= new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(arr[i]!=i)
                {
                    mp.put(i,mp.getOrDefault(i,0)+1);
                }
        }
         int sum = 0;
        for (int value : mp.values()) {
            sum += value;
        }
        return sum;
    }
}
class Solution {
    int sum(int a)
    {
        int x=0;
        while(a>0)
        {
            x+=a%10;
            a=a/10;
        }
        return x;
    }
 
    public int minSwaps(int[] nums) {
        int n=nums.length;
        List<Pair> rank= new ArrayList<>();
        for(int i=0;i<n;i++)
            rank.add(new Pair(nums[i],i));
        
        Collections.sort(rank, (A,B) -> {
            int x=sum(A.a);
            int y=sum(B.a);
            if(x==y)
                return Integer.compare(A.a,B.a);
            return Integer.compare(x,y);
        });

        int c=0;
        UnionFind unionFind= new UnionFind(n);
        for(int i=0;i<n;i++)
            {
                if(nums[i]!=rank.get(i).a)
                {
                    unionFind.union(i,rank.get(i).b);
                    c++;
                }
            }
        return (c>0) ? unionFind.totalSwapCount() : 0;
    }
}