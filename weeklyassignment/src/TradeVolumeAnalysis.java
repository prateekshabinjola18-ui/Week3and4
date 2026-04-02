class Trade {
    String name;
    int volume;

    Trade(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    public String toString() {
        return name + ":" + volume;
    }
}

public class TradeVolumeAnalysis {

    // Merge Sort Ascending
    static void mergeSort(Trade[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    static void merge(Trade[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Trade[] L = new Trade[n1];
        Trade[] R = new Trade[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i].volume <= R[j].volume) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Quick Sort Descending
    static void quickSort(Trade[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Trade[] arr, int low, int high) {
        int pivot = arr[high].volume;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].volume >= pivot) {
                i++;

                Trade temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Trade temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        Trade[] trades1 = {
                new Trade("trade3", 500),
                new Trade("trade1", 100),
                new Trade("trade2", 300)
        };

        // Merge Sort Ascending
        mergeSort(trades1, 0, trades1.length - 1);

        System.out.println("Merge Sort (Ascending):");
        for (Trade t : trades1) {
            System.out.println(t);
        }

        // Quick Sort Descending
        Trade[] trades2 = {
                new Trade("trade3", 500),
                new Trade("trade1", 100),
                new Trade("trade2", 300)
        };

        quickSort(trades2, 0, trades2.length - 1);

        System.out.println("\nQuick Sort (Descending):");
        for (Trade t : trades2) {
            System.out.println(t);
        }

        // Merge two sorted lists
        Trade[] morning = {
                new Trade("m1", 100),
                new Trade("m2", 300)
        };

        Trade[] afternoon = {
                new Trade("a1", 500)
        };

        int totalVolume = 0;

        System.out.println("\nMerged Morning + Afternoon:");

        for (Trade t : morning) {
            System.out.println(t);
            totalVolume += t.volume;
        }

        for (Trade t : afternoon) {
            System.out.println(t);
            totalVolume += t.volume;
        }

        System.out.println("Total Volume = " + totalVolume);
    }
}
