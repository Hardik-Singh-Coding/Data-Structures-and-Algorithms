public class Array_02_Find_Second_Largest {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};

        int L = arr[0];
        int SL = Integer.MIN_VALUE;

        for(int i=1; i<arr.length; i++){
            if(arr[i]>L){
                SL = L;
                L = arr[i];
            }
            else if(arr[i] == L)
                continue;
            else if(arr[i] != L && arr[i] > SL)
                SL = arr[i];
        }

        System.out.println(L);
        System.out.println(SL);
    }
}
