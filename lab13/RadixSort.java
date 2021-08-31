import java.util.Arrays;

/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        // TODO: Implement LSD Sort
        String[] copy = asciis.clone();
        int max = 0;
        for (String str : copy) {
            max = max > str.length() ? max : str.length();
        }
        for (int i = max-1; i >= 0; i--) {
            sortHelperLSD(copy, i);
        }

        return copy;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        // Optional LSD helper method for required LSD radix sort
        String[][] temp = new String[257][asciis.length];
        int m = 0;
        for (String str : asciis) {
            if (str.length() <= index) {
                temp[0][m++] = str;
            }
            else {
                int num = 0;
                while (temp[(int) str.charAt(index)+1][num] != null) {
                    num++;
                }
                temp[ (int) str.charAt(index)+1][num] = str;
            }

        }
        int k = 0;
        for (int i = 0; i < 257; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (temp[i][j] != null) {
                    asciis[k++] = temp[i][j];
                }
            }
        }
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }
    public static void main(String[] args) {
        String[] ass = new String[5];
        ass[0] = "1ab";
        ass[1] = "ba";
        ass[2] = "bca";
        ass[3] = "aba";
        ass[4] = "12aba";
        System.out.println(Arrays.toString(sort(ass)));
    }
}
