package symbolTable;

public class BinarySearchTree<K extends Comparable<K>, V> implements SymbolTable<K, V>{

    public BinarySearchTree() {
        root = null;
    }

    Node<K, V> root;

    @Override
    public void put(K key, V value) {

        Node<K, V> newNode = new Node<>(key, value);

        if(root == null) {
            root = newNode;
        }

        Node<K, V> currentNode = root;
        Node<K, V> lastNode = root;
        Direction lastDirection = Direction.LEFT; // 0: left, 1: right

        while(true) {

            if(currentNode == null) {
                lastNode.set(lastDirection, newNode);
                break;
            }
            int compare = newNode.compareTo(currentNode);

            if (compare < 0) {
                lastNode = currentNode;
                currentNode = currentNode.left;
                lastDirection = Direction.LEFT;
            }
            else if (compare > 0) {
                lastNode = currentNode;
                currentNode = currentNode.right;
                lastDirection = Direction.RIGHT;
            }
            else {
                currentNode.set(newNode);
                break;
            }
        }
    }

    @Override
    public V get(K key) {

        if(root == null) {
            return null;
        }

        Node<K, V> currentNode = root;

        while(currentNode != null) {

            int compare = key.compareTo(currentNode.key);

            if (compare < 0) {
                currentNode = currentNode.left;
            }
            else if (compare > 0) {
                currentNode = currentNode.right;
            }
            else {
                break;
            }
        }

        return currentNode == null ? null : currentNode.value;
    }

    // 중위순회 => 정렬된 결과를 반환한다면 put이 제대로 실행되었음을 보임.
    void iterate(Node<K,V> currentNode, StringBuilder sb) {

        if(currentNode == null) return;

        if(currentNode.left != null) {
            iterate(currentNode.left, sb);
        }

        sb.append(currentNode);
        sb.append("\n");

        if(currentNode.right != null) {
            iterate(currentNode.right, sb);
        }
    }

    public void print() {

        StringBuilder sb = new StringBuilder();
        iterate(root, sb);
        System.out.println(sb);
    }
}
