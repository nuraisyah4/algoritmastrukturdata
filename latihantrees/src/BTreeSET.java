public class BTreeSET<Key extends Comparable<Key>> {
    private Page<Key> root = new Page<>(true);

    public BTreeSET(Key sentinel) {
        add(sentinel);
    }
    public boolean contains(Key key) {
        return contains(root, key);
    }
    private boolean contains(Page<Key> h, Key key) {
        if (h.isExternal()) return h.contains(key);
        return contains(h.next(key), key);
    }
    public void add(Key key) {
        add(root, key);
        if (root.isFull()) {
            Page<Key> lefthalf = root;
            Page<Key> righthalf = root.split();
            root = new Page<>(false);
            root.add(lefthalf);
            root.add(righthalf);
        }
    }
    private void add(Page<Key> h, Key key) {
        if (h.isExternal()) {
            h.add(key);
            return;
        }
        Page<Key> next = h.next(key);
        add(next, key);
        if (next.isFull()) {
            h.add(next.split());
        }
        next.close();
    }
}
