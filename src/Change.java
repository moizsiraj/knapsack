import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int currentValue = m;
        int tens = 0;
        int fives = 0;
        int ones = 0;
        tens = currentValue / 10;
        currentValue = currentValue % 10;
        fives = currentValue / 5;
        currentValue = currentValue % 5;
        ones = currentValue;
        m = ones + fives + tens;
        return m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }

}

