import java.util.Arrays;

public class LC1011 {
    public int shipWithinDays(int[] weights, int days) {
        int l=Arrays.stream(weights).max().getAsInt(),r= Arrays.stream(weights).sum();
        while(l<r){
            int mid=l+(r-l)/2;
            if(days(weights,mid)<=days)
                r=mid;
            else
                l=mid+1;
        }
        return l;
    }
    private int days(int[]weights,int k){
        int cur=0,res=0;
        for(int weight:weights)
            if(cur+weight<=k)
                cur+=weight;
            else{
                res++;
                cur=weight;
            }
            res++;
            return res;
    }
}
