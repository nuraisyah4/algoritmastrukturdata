import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdOut;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;  // Keluar dari loop jika Enter ditekan
            try {
                numbers.add(Double.parseDouble(line));
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, coba lagi.");
            }
        }
        int N = numbers.size();
        double sum = 0.0;
        for (double x : numbers)
            sum += x;
        double mean = sum / N;

        sum = 0.0;
        for (double x : numbers)
            sum += (x - mean) * (x - mean);
        double std = Math.sqrt(sum / (N - 1));

        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
