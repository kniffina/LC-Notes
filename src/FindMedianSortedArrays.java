public class FindMedianSortedArrays {

    //complexity is O(n) time and space
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int i = 0, leftIndex = 0, rightIndex = 0, tLength = nums1.length + nums2.length;
        int[] arr = new int[tLength];

        while(leftIndex < nums1.length && rightIndex < nums2.length) {
            if(nums1[leftIndex] <= nums2[rightIndex]) {
                arr[i] = nums1[leftIndex];
                leftIndex++;
            }
            else {
                arr[i] = nums2[rightIndex];
                rightIndex++;
            }
            i++;
        }

        while(leftIndex < nums1.length) {
            arr[i] = nums1[leftIndex];
            leftIndex++;
            i++;
        }

        while(rightIndex < nums2.length) {
            arr[i] = nums2[rightIndex];
            rightIndex++;
            i++;
        }

        double mid = tLength / 2;
        double even = 0;

        //even number so we have to get two middles and divide
        if(tLength % 2 == 0) {
            even = (double) (arr[(int)mid - 1] + arr[(int)mid]) / 2;
        }

        return tLength % 2 == 0 ? even : (double) arr[(int) mid];
    }

    //we should be able to do this in O(log(m + n)) time
    //use binary search type method
    public static double findMedianBetter(int[] arr1, int[] arr2) {

        return 2.0;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 6};
        int arr2[] = {4, 7};

        System.out.println(findMedianSortedArrays(arr, arr2));
    }
}
