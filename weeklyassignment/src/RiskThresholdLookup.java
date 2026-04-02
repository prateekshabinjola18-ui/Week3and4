public class RiskThresholdLookup {

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};
        int target = 30;

        // Linear Search
        int linearComparisons = 0;
        boolean found = false;

        for (int i = 0; i < risks.length; i++) {
            linearComparisons++;
            if (risks[i] == target) {
                found = true;
                System.out.println("Linear Search: Found at index " + i);
                break;
            }
        }

        if (!found) {
            System.out.println("Linear Search: Not found");
        }

        System.out.println("Comparisons = " + linearComparisons);

        // Binary Search for floor and ceiling
        int low = 0;
        int high = risks.length - 1;
        int binaryComparisons = 0;

        int floor = -1;
        int ceiling = -1;

        while (low <= high) {
            binaryComparisons++;
            int mid = (low + high) / 2;

            if (risks[mid] == target) {
                floor = risks[mid];
                ceiling = risks[mid];
                break;
            } else if (risks[mid] < target) {
                floor = risks[mid];
                low = mid + 1;
            } else {
                ceiling = risks[mid];
                high = mid - 1;
            }
        }

        // Insertion point
        int insertionPoint = low;

        System.out.println("\nBinary Search:");
        System.out.println("Floor = " + floor);
        System.out.println("Ceiling = " + ceiling);
        System.out.println("Insertion Point = " + insertionPoint);
        System.out.println("Comparisons = " + binaryComparisons);
    }
}