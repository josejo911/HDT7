import java.util.HashMap;

/**
 * Jose Jo Escobar,14343
 * Alejandro Chaclan, 15018
 * Hoja de trabajo No 7
 * Algortimos y estructura de datos
 */
public class Node {
    public Node parent;
    public Boolean endOfWord = false; //Does this Node mark the end of a particular word?
    public HashMap<Character,Node> children = new HashMap<Character,Node>();
}
