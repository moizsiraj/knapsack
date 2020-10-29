import java.util.*;

public class LargestNumber {

    private static String largestNumber(String[] a) {
        Vector<String> numbers = new Vector<String>();
        for (int i = 0; i < a.length; i++) {
            numbers.add(a[i]);
        }
        numbers.sort(new Comparator<String>() {
            @Override
            public int compare(String X, String Y) {
                // first append Y at the end of X
                String XY = X + Y;
                // then append X at the end of Y
                String YX = Y + X;

                int XYint = Integer.parseInt(XY);
                int YXint = Integer.parseInt(YX);

                // Now see which of the two formed numbers
                // is greater
                return Integer.compare(YXint, XYint);
            }
        });
        StringBuilder x = new StringBuilder();
        for (String number : numbers) {
            x.append(number);
        }
        return x.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

