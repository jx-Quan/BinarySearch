public class Solution3 {
    public static int search(int[]data,int target){
        int l=0,r=data.length;
        //在data[l.r)的范围中查找target  注意右侧为开区间
        while(l<r){
            int mid=l+(r-l)/2;
            if(data[mid]==target)
                return mid;
            else if(data[mid]<target)
                l=mid+1;//继续在data[mid+1,r)范围里寻找
            else
                r=mid;//继续在data[l，mid)范围里寻找
        }
        return -1;
    }
}
