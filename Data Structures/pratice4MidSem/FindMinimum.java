public class FindMinimum {

    // Recursive function to find the minimum element
    public static int recursion(int[] arr, int n) {
        // Base case: if the array has only one element, return it
        if (n == 1) {
            return arr[0];
        }
        
        // Compare the current element with the result of the recursive call
        return arr[n - 1] < recursion(arr, n - 1) ? arr[n - 1] : recursion(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 4, 10, 5, 9, 2};
        int n = arr.length;
        System.out.println("Minimum element in the array: " + recursion(arr, n));
    }
}
