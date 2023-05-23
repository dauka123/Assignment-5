import java.util.ArrayList;
import java.util.List;

public class BST <K extends Comparable<K>, V>{
    private Node root;
    private int size;
    private class Node{
        private K key;
        private V val;
        private Node left, right;
        public Node (K key, V val){
            this.key = key;
            this.val = val;
        }
    }
    public int size() {
        return size;
    }
    public void put(K key, V val){
        root = put(root, key, val);
    }

    private Node put(Node node, K key, V val){
        if (node == null){
            size++;
            return new Node(key, val);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            node.left = put(node.left, key, val);
        }
        else if (cmp > 0){
            node.right = put(node.right, key, val);
        }
        else {
            node.val = val;
        }
        return node;
    }

    public V get (K key){
        return get(root, key);
    }

    private V get(Node node, K key){
        if (node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            return get(node.left, key);
        }
        else if (cmp > 0){
            return get(node.right, key);
        }
        else {
            return node.val;
        }
    }

    public void delete(K key){
        root = delete(root, key);
    }

    private Node delete(Node node, K key){
        if (node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            node.left = delete(node.left, key);
        }
        else if (cmp > 0){
            node.right = delete(node.right, key);
        }
        else{
            if (node.left == null && node.right == null){
                return null;
            } else if (node.left == null){
                return node.right;
            } else if (node.right == null){
                return node.left;
            } else {
                Node minNode = findMin(node);
                node.key = minNode.key;
                node.val = minNode.val;
                node.right = delete(node.right, node.key);
            }
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Iterable<Node> iterator() {
        List<Node> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);
        return nodes;
    }
    private void inorderTraversal(Node node, List<Node> nodes) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, nodes);
        nodes.add(node);
        inorderTraversal(node.right, nodes);
    }
}
