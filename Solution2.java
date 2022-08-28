public class Solution2 {
    public static int search(int[]data,int target){
        int l=0,r=data.length-1;
        //在data[l.r]的范围中查找target
        while(l<=r){
            int mid=l+(r-l)/2;
            if(data[mid]==target)
                return mid;
            else if(data[mid]<target)
                l=mid+1;
            else
                r=mid-1;
        }
        return -1;
    }
}
