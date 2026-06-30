class Solution {
    public void duplicateZeros(int[] arr) {
        int [] array = arr.clone();

       int l1=0;
       int r1=array.length;

       int l2=0;
       int r2 = arr.length;

       while(l2<r2) {
        if (array[l1]!=0) {
            arr[l2]=array[l1];
            l1++;
            l2++;
        } else if(array[l1]==0) {
            arr[l2]=0;
            l2++;
            if(l2<r2) {
                arr[l2]=0;
                l1++;
                l2++;
            }
        }
       }
        
    }
}