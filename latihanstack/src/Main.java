import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.println("Masukkan angka (ketik angka -1 untuk selesai):");
        // Membaca input hingga EOF (Ctrl + Z di Windows, Ctrl + D di Linux/macOS)
        while (true) {
            int input = scanner.nextInt();
            if (input == -1) {
                break; // Berhenti jika input adalah -1
            }
            stack.push(input);
        }
        scanner.close();
        // Cetak dalam urutan terbalik
        System.out.println("Hasil output dalam urutan terbalik:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
