class Pair{
    int a,b;
    Pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}
class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Pair> dq = new ArrayDeque<>();
        int ans=0,temp=1,c=0;
        char ch[]=s.toCharArray();
        int n = ch.length;
        for(int i=0;i<n;i++)
        {
            if(ch[i]=='(')
            {
                c++;
            }
            else
            {
                c--;
                temp=0;
                while(!dq.isEmpty() && dq.peekLast().a>c)
                {
                temp+=dq.pollLast().b;
                }
                temp = (temp==0) ? 1: temp*2;
                dq.addLast(new Pair(c,temp));
            }          
        }
        temp=0;
        while(!dq.isEmpty())
                temp+=dq.pollLast().b;
        return temp;
    }
}


// (()(()))
// 0,1,2,3,4,5,6,7
// 1,2,1,2,3,2,1,0
//     .     . . .

// (1,1)

// (1,1) (2,1)

// (1,1),(1,2)
// 0,1

// 0,3*2
