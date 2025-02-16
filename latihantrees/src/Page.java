import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;

public class Page<Key extends Comparable<Key>> {
    private final TreeSet<Key> keys;
    private final List<Page<Key>> children;
    private final boolean isExternal;

    public Page(boolean isExternal) {
        this.isExternal = isExternal;
        this.keys = new TreeSet<>();
        this.children = new ArrayList<>();
    }

    public boolean isExternal() {
        return isExternal;
    }

    public boolean contains(Key key) {
        return keys.contains(key);
    }

    public void add(Key key) {
        keys.add(key);
    }

    public void add(Page<Key> page) {
        children.add(page);
    }

    public boolean isFull() {
        return keys.size() > 4;  // Misal batas maksimum 4 elemen per node
    }

    public Page<Key> split() {
        Page<Key> newPage = new Page<>(this.isExternal);
        int half = keys.size() / 2;
        int count = 0;
        for (Key key : keys) {
            if (count++ >= half) {
                newPage.add(key);
            }
        }
        keys.removeAll(newPage.keys);
        return newPage;
    }

    public Page<Key> next(Key key) {
        if (isExternal) return this;
        for (Page<Key> child : children) {
            if (child.contains(key)) return child;
        }
        return this;
    }

    public void close() {
        // Simulasi flush ke storage jika diperlukan
    }
}
