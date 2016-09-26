import java.util.HashMap;

/**
 * Jose Jo Escobar,14343
 * Alejandro Chaclan, 15018
 * Hoja de trabajo No 7
 * Algortimos y estructura de datos
 */
//Dictionary implemented using a Trie Tree.
public class Main {
    private HashMap<Character,Node> roots = new HashMap<Character,Node>();

    /**
     * Search through the dictionary for a word.
     * @param string The word to search for.
     * @return Whether or not the word exists in the dictionary.
     */
    public boolean search(String string) {
        if (roots.containsKey(string.charAt(0))) {
            if (string.length()==1 && roots.get(string.charAt(0)).endOfWord) {
                return true;
            }
            return searchFor(string.substring(1),roots.get(string.charAt(0)));
        } else {
            return false;
        }
    }

    }
}