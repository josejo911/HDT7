import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String linea, key, value;
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();

        //Se trata de leer el archivo en el directorio actual, donde se encuentran los archivos .java
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\diccionario.txt"))) {

            StringBuilder sb = new StringBuilder();
            linea = br.readLine();

            //Se hace un ciclo para leer todo el archivo
            while(linea!=null) {

                //Se eliminan los separadores de linea
                sb.append(linea);

                //Se buscan en cada linea el value y key
                linea = linea.toLowerCase();
                key = "";
                value = "";
                boolean keyFlag = false;
                for (int i = 0; i < linea.length(); i++) {
                    char c = linea.charAt(i);
                    if (Character.isLetter(c)) {
                        if (!keyFlag)
                            key += c;
                        else
                            value += c;
                    } else {
                        if (!key.isEmpty())
                            keyFlag = true;
                    }
                }

                //Se agrega la entrada al arbol
                Association<String, String> temp = new Association<>(key, value);
                Funciones.addBT(tree,temp);

                //Se lee una nueva linea
                linea = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\texto.txt"))) {
            StringBuilder sb = new StringBuilder();
            linea = br.readLine();
            sb.append(linea);

            //En 'linea' esta el texto en ingles, cambiar las palabras

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Funciones.inOrder(tree));
    }
}
