class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(sx<tx && sy<ty)
        {
            if(tx>ty)
            tx=tx%ty;
            else
            ty=ty%tx;
        }

        if(tx==sx && ty==sy || (ty>sy && sx==tx && (ty-sy)%tx==0))
            return true;
        return (tx>sx && sy==ty && (tx-sx)%ty==0);
    }
}