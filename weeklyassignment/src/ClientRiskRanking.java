class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    public String toString() {
        return name + ": risk=" + riskScore + ", balance=" + accountBalance;
    }
}

public class ClientRiskRanking {
    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 10000),
                new Client("clientB", 50, 7000),
                new Client("clientD", 95, 3000)
        };

        // Bubble Sort Ascending by riskScore
        int swaps = 0;

        for (int i = 0; i < clients.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < clients.length - i - 1; j++) {
                if (clients[j].riskScore > clients[j + 1].riskScore) {
                    Client temp = clients[j];
                    clients[j] = clients[j + 1];
                    clients[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        System.out.println("Bubble Sort (Ascending Risk Score):");
        for (Client c : clients) {
            System.out.println(c);
        }

        System.out.println("Swaps = " + swaps);

        // Insertion Sort Descending by riskScore + accountBalance
        Client[] sortedClients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 10000),
                new Client("clientB", 50, 7000),
                new Client("clientD", 95, 3000)
        };

        for (int i = 1; i < sortedClients.length; i++) {
            Client key = sortedClients[i];
            int j = i - 1;

            while (j >= 0 &&
                    (sortedClients[j].riskScore < key.riskScore ||
                            (sortedClients[j].riskScore == key.riskScore &&
                                    sortedClients[j].accountBalance < key.accountBalance))) {

                sortedClients[j + 1] = sortedClients[j];
                j--;
            }

            sortedClients[j + 1] = key;
        }

        System.out.println("\nInsertion Sort (Descending Risk Score):");
        for (Client c : sortedClients) {
            System.out.println(c);
        }

        // Top highest risk clients
        System.out.println("\nTop Highest Risk Clients:");

        int top = Math.min(10, sortedClients.length);

        for (int i = 0; i < top; i++) {
            System.out.println(sortedClients[i]);
        }
    }
}