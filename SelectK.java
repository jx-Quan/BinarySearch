import java.util.Random;
public class SelectK {
    //非递归实现SelectK
    public int findKthLargest(int []nums,int k){
        Random rnd=new Random();
        return selectK(nums,nums.length-k,rnd);
    }
    private void swap(int[]arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    private int selectK(int[]arr,int k, Random rnd){
        int l=0,r=arr.length-1;
        while(l<=r) {
            int p = partition(arr, l, r, rnd);
            if (k == p)
                return arr[p];
            if (k < p)
                r=p-1;
            else
                l=p+1;
        }
        throw new RuntimeException("No Solution!");
    }
    private int partition(int[]arr,int l,int r,Random rnd){
        //生成[l,r]间的随机索引
        int p=l+rnd.nextInt(r-l+1);
        swap(arr,l,p);
        int i=l+1,j=r;
        while(true){
            while(i<=j&&arr[i]<arr[l])
                i++;
            while(j>=i&&arr[i]>arr[l])
                j--;
            if(i>=j) break;;
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,l,j);
        return j;
    }
}
