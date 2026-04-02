import java.util.Arrays;

public class AccountIdLookup {

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        // Linear Search for first and last occurrence
        String target = "accB";
        int first = -1;
        int last = -1;
        int linearComparisons = 0;

        for (int i = 0; i < logs.length; i++) {
            linearComparisons++;
            if (logs[i].equals(target)) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }

        System.out.println("Linear Search:");
        System.out.println("First occurrence = " + first);
        System.out.println("Last occurrence = " + last);
        System.out.println("Comparisons = " + linearComparisons);

        // Sort for Binary Search
        Arrays.sort(logs);

        System.out.println("\nSorted Logs:");
        for (String log : logs) {
            System.out.print(log + " ");
        }

        // Binary Search
        int low = 0;
        int high = logs.length - 1;
        int binaryComparisons = 0;
        int index = -1;

        while (low <= high) {
            binaryComparisons++;
            int mid = (low + high) / 2;

            if (logs[mid].equals(target)) {
                index = mid;
                break;
            } else if (logs[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Count duplicates
        int count = 0;
        for (String log : logs) {
            if (log.equals(target)) {
                count++;
            }
        }

        System.out.println("\nBinary Search:");
        System.out.println("Index = " + index);
        System.out.println("Comparisons = " + binaryComparisons);
        System.out.println("Count = " + count);
    }
}