package symbolTable;

class Node<K extends Comparable<K>, V> implements Comparable<Node<K, V>>{
    K key; V value;
    Node<K, V> left, right;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        left = right = null;
    }

    public void set(Node<K, V> node) {
        key = node.key;
        value = node.value;
    }

    public void set(Direction direction, Node<K, V> node) {
        if (direction == Direction.LEFT) left = node;
        else if (direction == Direction.RIGHT) right = node;
    }

    @Override
    public int compareTo(Node<K, V> o) {
        return key.compareTo(o.key);
    }

    @Override
    public String toString() {
        return "{" + key + ":" + value + "}";
    }
}
