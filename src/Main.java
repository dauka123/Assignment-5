public class Main {
    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();

        for (int i = 0; i < 12; i++) {
            bst.put(i, i+1);
        }

        Iterable it = bst.iterator();
        for(Object el: it) {
            System.out.println(el);
        }
    }
}