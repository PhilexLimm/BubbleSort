import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        // Arr that have to sort and its element bound
        int[] arr = new int[20];
        int bound = 10;

        // Assign each element with random bounded number
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(0, bound);
        }

        // Print the source (not sorted) arr
        System.out.println("Source");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
        Draw(arr, bound); // A function that draws a graph from an array

        // Print sorted array
        // BubbleSort(arr) is a sorting function
        System.out.println("\nSorted:");
        for (int i : BubbleSort(arr)) {
            System.out.print(i + " ");
        }

        System.out.println();
        Draw(arr, bound);
    }

    private static int[] BubbleSort(int[] arr) {
        int loop = arr.length - 1; // Assign a number of iterations

        for (int i = 0; i < loop; i++) {
            /*
            * The 'swapped' variable is needed for checking if array elements swapped or not.
            * If swapped is true this for loop will continue checking and changing our array,
            * else it breaks and this mean that our array is already sorted.
            */
            boolean swapped = false;

            for (int j = 0; j < loop; j++) {
                if ( arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        return arr;
    }

    private static void Draw(int[] arr, int bound) {
        /*
        * 'for' loop means Y axis;
        * And the 'for-each' loop means X axis.
        * Pay attention to 'if (i < j) { ... }' block
        * this means that if 'i' (or x) less than j (or current array element) then we print '#' symbol.
        * Note that 'for' loop has a decrement because we print our array from the end.
        * That's because we visualize our graph from bottom to top, and because of console,
        * that write text in order from bottom to top,
        * we write top line of our graph and draw so every line to the very bottom line.
        */
        for (int i = bound; i >= 0; i--) {
            for (int j : arr) {
                if (i < j) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
