/*
Algoritmos y Estructuras de Datos
Hoja de trabajo 7

Integrantes:
Alejandro Chaclan 15018
Jose Javier Jo 14343
*/

public class DiccionarioAssociationTree implements Diccionario<BinaryTree<Association<String, String>>, Association<String, String>>{
    public DiccionarioAssociationTree() {}

    //Metodo para agregar una entrada
    public void add(BinaryTree<Association<String, String>> tree, Association<String, String> data) {
        addS(tree, data);
    }

    //Metodo para buscar una palabra, utilizando el algoritmo InOrder
    public String searchInOrder(BinaryTree<Association<String, String>> tree, String key) {
        return searchInOrderS(tree, key);
    }

    //Metodo para mostrar todas las entradas del diccionario utilizando el algoritmo InOrder
    public String InOrder(BinaryTree<Association<String, String>> tree) {
        return  InOrderS(tree);
    }

    //Metodo estatico para agregar una entrada al arbol de forma recursiva
    private static void addS (BinaryTree<Association<String, String>> tree, Association<String, String> data) {
        //Se estrablece el caso base, que es cuando encuentra un nodo sin valor
        if (tree.value() == null){
            tree.setValue(data);
            tree.setLeft(new BinaryTree<>());
            tree.setRight(new BinaryTree<>());
        } else {
            //Si la palabra es de menor orden alfabetico, se busca en el nodo de la izquierda del arbol, si es mayor, se busca del lado derecho
            if (data.getKey().compareTo(tree.value().getKey()) <= 0)
                addS(tree.left(), data);
            else
                addS(tree.right(), data);
        }
    }

    //Metodo estatico para buscar una palabra con el algoritmo InOrder de forma recursiva
    private static String searchInOrderS(BinaryTree<Association<String, String>> tree, String key) {
        String resp = "";
        //Primero se buscan en los nodos izquierdos
        if (tree.left().value() != null) {
            resp = searchInOrderS(tree.left(), key);
        }
        if (resp.isEmpty()) {
            //Se establece el caso base
            if (tree.value().getKey().equals(key)) {
                resp = tree.value().getValue();
            }
            //Por ultimo, si no se ha encontrado en los nodos anteriores, se busca en los nodos del lado derecho
            if (resp.isEmpty()) {
                if (tree.right().value() != null) {
                    resp = searchInOrderS(tree.right(),key);
                }
            }
        }
        return resp;
    }

    //Metodo estatico para mostrar las entradas del arbol con el algoritmo InOrder de forma recursiva
    private static String InOrderS(BinaryTree<Association<String, String>> tree) {
        if (tree.value() == null)
            return "";
        else
            return InOrderS(tree.left()) + "(" + tree.value().getKey() + ", " + tree.value().getValue() + ")\n" + InOrderS(tree.right());
    }
}
