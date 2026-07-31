class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed= Integer.MIN_VALUE-1;
        for(int i=0;i<piles.length;i++)
            maxSpeed=Math.max(maxSpeed, piles[i]);
        int possibleSpeed,minSpeed=1;
        int ans=maxSpeed;
        while(minSpeed<=maxSpeed)
        {
            possibleSpeed= minSpeed + (maxSpeed-minSpeed)/2;
            long calc_h=0;
            for(int pile : piles){
                calc_h+=(pile/possibleSpeed) + ((pile%possibleSpeed!=0) ? 1: 0);
            }

            if(calc_h<=h)
            {ans=Math.min(ans,possibleSpeed);
            maxSpeed=possibleSpeed-1;}
            else
            minSpeed=possibleSpeed+1;
        }
        return ans;
    }
}