import java.util.ArrayList;

class Transaction {
    String id;
    double fee;
    String timestamp;

    Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    public String toString() {
        return id + ": fee=" + fee + ", ts=" + timestamp;
    }
}

public class TransactionAudit {
    public static void main(String[] args) {

        ArrayList<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));
        transactions.add(new Transaction("id4", 60.0, "11:00"));

        // Bubble Sort
        ArrayList<Transaction> bubbleList = new ArrayList<>(transactions);

        int swaps = 0;
        int passes = 0;

        for (int i = 0; i < bubbleList.size() - 1; i++) {
            boolean swapped = false;
            passes++;

            for (int j = 0; j < bubbleList.size() - i - 1; j++) {
                if (bubbleList.get(j).fee > bubbleList.get(j + 1).fee) {
                    Transaction temp = bubbleList.get(j);
                    bubbleList.set(j, bubbleList.get(j + 1));
                    bubbleList.set(j + 1, temp);

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        System.out.println("Bubble Sort Result:");
        for (Transaction t : bubbleList) {
            System.out.println(t);
        }

        System.out.println("Passes = " + passes);
        System.out.println("Swaps = " + swaps);

        // Insertion Sort
        ArrayList<Transaction> insertionList = new ArrayList<>(transactions);

        for (int i = 1; i < insertionList.size(); i++) {
            Transaction key = insertionList.get(i);
            int j = i - 1;

            while (j >= 0 &&
                    (insertionList.get(j).fee > key.fee ||
                            (insertionList.get(j).fee == key.fee &&
                                    insertionList.get(j).timestamp.compareTo(key.timestamp) > 0))) {

                insertionList.set(j + 1, insertionList.get(j));
                j--;
            }

            insertionList.set(j + 1, key);
        }

        System.out.println("\nInsertion Sort Result:");
        for (Transaction t : insertionList) {
            System.out.println(t);
        }

        // Outliers
        System.out.println("\nHigh Fee Outliers (>50):");

        boolean found = false;

        for (Transaction t : transactions) {
            if (t.fee > 50) {
                System.out.println(t);
                found = true;
            }
        }

        if (!found) {
            System.out.println("None");
        }
    }
}