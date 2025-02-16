import edu.princeton.cs.algs4.Queue;
import java.util.Scanner;

public class Main {
    public static int[] readInts() {
        Scanner in = new Scanner(System.in);
        Queue<Integer> q = new Queue<Integer>();
        System.out.println("Masukkan angka (ketik non-angka untuk selesai):");

        while (in.hasNextInt()) {
            q.enqueue(in.nextInt());
        }
        int N = q.size();
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = q.dequeue();
        return a;
    }

    public static void main(String[] args) {
        int[] numbers = readInts();
        System.out.println("Angka yang Anda masukkan:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
