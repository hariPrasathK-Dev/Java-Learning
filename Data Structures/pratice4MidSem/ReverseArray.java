public class ReverseArray {

    // Recursive function to reverse the array
    public static void reverseArray(int[] A, int i, int n) {
        // Base case: if there is only one element or no more elements to swap
        if (n <= 1) {
            return;
        }

        // Swap the elements at the start and the end of the current section
        int temp = A[i];
        A[i] = A[i + n - 1];
        A[i + n - 1] = temp;

        // Recursive call to reverse the rest of the array
        reverseArray(A, i + 1, n - 2);
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6};
        int n = A.length;
        reverseArray(A, 0, 6);
        System.out.println("Reversed array:");
        for (int num : A) {
            System.out.print(num + " ");
        }
    }
}
