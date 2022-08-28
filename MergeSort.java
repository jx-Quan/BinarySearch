import java.util.Arrays;

public class MergeSort {
    //改变定义重写归并排序
    private MergeSort(){}

    public static <E extends Comparable<E>>void sort(E[] arr){
        //sort(arr,0,arr.length-1,0);
        E []temp= Arrays.copyOf(arr,arr.length);
        sort(arr,0,arr.length,temp);
    }
    private static <E extends Comparable<E>>void sort(E[] arr,int l,int r,E[]temp){
        if(r-l<=1) return;

        int mid=l+(r-l)/2;//防止超出整型变量范围
        sort(arr,l,mid,temp);
        sort(arr,mid,r,temp);
        if(arr[mid-1].compareTo(arr[mid])>0)
            merge(arr,l,mid,r,temp);
    }
    private static <E extends Comparable<E>>void merge(E[]arr,int l,int mid,int r,E[]temp){
        System.arraycopy(arr,l,temp,l,r-l);
        int i=l,j=mid;
        //每轮循环为arr[k]赋值
        for(int k=l;k<r;k++){
            if(i>=mid){
                arr[k]=temp[j];
                j++;
            }
            else if(j>=r){
                arr[k]=temp[i];
                i++;
            }
            else if(temp[i].compareTo(temp[j])<=0){
                arr[k]=temp[i];
                i++;
            }
            else{
                arr[k]=temp[j];
                j++;
            }
        }
    }
}
