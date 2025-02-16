public class Main {
    public static void main(String[] args) {
        BTreeSET<Integer> btree = new BTreeSET<>(0);

        // Tambahkan elemen ke dalam B-Tree
        btree.add(10);
        btree.add(20);
        btree.add(5);
        btree.add(6);
        btree.add(12);
        btree.add(30);
        btree.add(7);
        btree.add(17);

        // Cek apakah elemen tertentu ada dalam tree
        System.out.println(STR."Contains 6? \{btree.contains(6)}");
        System.out.println(STR."Contains 15? \{btree.contains(15)}");

        // Menampilkan hasil
        System.out.println("B-Tree implementation is running successfully!");
    }
}
