/**
 * Created by user on 9/26/2016.
 */
public class Funciones {
    public Funciones() {}

    public static void addBT (BinaryTree<Association<String, String>> tree, Association<String, String> data) {
        if (tree.value() == null){
            tree.setValue(data);
            tree.setLeft(new BinaryTree<>());
            tree.setRight(new BinaryTree<>());
        } else {
            if (data.getKey().compareTo(tree.value().getKey()) <= 0)
                addBT(tree.left(), data);
            else
                addBT(tree.right(), data);
        }
    }
}
