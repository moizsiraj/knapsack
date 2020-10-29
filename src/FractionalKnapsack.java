import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double[] weightsX = new double[weights.length];
        for (int i = 0; i < weightsX.length; i++) {
            weightsX[i] = weights[i];
        }
        double value = 0;
        double totalWeightAvailable = 0;
        double spaceLeft = capacity;
        double currentWeight = 0;
        int maxVPWIndex = 0;
        double maxVPW = 0;
        double[] valuePerWeight = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            valuePerWeight[i] = (double) values[i] / weightsX[i];
            totalWeightAvailable = totalWeightAvailable + weightsX[i];
            if (valuePerWeight[i] > maxVPW) {
                maxVPW = valuePerWeight[i];
                maxVPWIndex = i;
            }
        }
        while (currentWeight < capacity && totalWeightAvailable > 0) {
            double weightOfItemTaken;
            double valueAdded;
            double weightAdded;
            if (weightsX[maxVPWIndex] > spaceLeft) {
                weightOfItemTaken = (double) capacity / weightsX[maxVPWIndex];
                valueAdded = weightOfItemTaken * values[maxVPWIndex];
                weightAdded = weightOfItemTaken * weightsX[maxVPWIndex];
                value = value + valueAdded;
                spaceLeft = spaceLeft - weightAdded;
                currentWeight = currentWeight + weightAdded;
                weightsX[maxVPWIndex] = weightsX[maxVPWIndex] - weightAdded;
                totalWeightAvailable = totalWeightAvailable - weightAdded;
            } else {
                valueAdded = values[maxVPWIndex];
                weightAdded = weightsX[maxVPWIndex];
                value = value + valueAdded;
                spaceLeft = spaceLeft - weightAdded;
                currentWeight = currentWeight + weightAdded;
                weightsX[maxVPWIndex] = weightsX[maxVPWIndex] - weightAdded;
                totalWeightAvailable = totalWeightAvailable - weightAdded;
                valuePerWeight[maxVPWIndex] = -1;
                //Updating maxVPWIndex
                for (int i = 0; i < valuePerWeight.length; i++) {
                    if (valuePerWeight[i] > valuePerWeight[maxVPWIndex]) {
                        maxVPWIndex = i;
                    }
                }
            }
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.printf("%.4f",getOptimalValue(capacity, values, weights));
    }
} 
