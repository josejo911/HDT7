/*
Algoritmos y Estructuras de Datos
Hoja de trabajo 7

Integrantes:
Alejandro Chaclan 15018
Jose Javier Jo 14343

Este programa simula un diccionario de ingles a espaÃ±ol, utilizando arboles binarios y el algoritmo de InOrder para encontrar las palabras
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String linea, key, value;
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();
        Diccionario diccionario = new DiccionarioAssociationTree();

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
                diccionario.add(tree,temp);

                //Se lee una nueva linea
                linea = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Se muestra el contenido del arbol usando el algoritmo InOrder
        System.out.println("Recorrido del arbol usando el algoritmo InOrder:\n" + diccionario.InOrder(tree));

        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\texto.txt"))) {
            //Se lee la linea de texto y se eliminan los separadores de linea
            StringBuilder sb = new StringBuilder();
            linea = br.readLine();
            sb.append(linea);

            //Se muestra en pantalla el texto sin traducir
            System.out.println("El texto sin traducir:\n" + linea);

            //Se convierten todas las letras a minusculas
            linea = linea.toLowerCase();

            //Variables para guardar la traduccion final y cada palabra leida del texto
            String traduccion = "";
            String palabra = "";
            int i = 0;
            //Ciclo que recorre todo el texto buscando palabras
            while (i < linea.length()) {
                char c = linea.charAt(i);
                //Cada vez que encuentra una letra la agrega al string
                if (Character.isLetter(c)) {
                    palabra += c;
                    //Cuando encuentra algo que no es una letra, se usa la palabra que se fue construyendo para buscarla en el diccionario y traducirla
                } else  if (palabra.length() > 0){
                    //Se busca la palabra en el diccionario
                    String temp = diccionario.searchInOrder(tree, palabra);
                    //Si no la encontro en el diccionario, deja la palabra en ingles y le agrega asteriscos
                    if (temp.isEmpty())
                        traduccion += "*" + palabra + "* ";
                        //De lo contrario, usa la palabra traducida
                    else
                        traduccion += temp + " ";
                    palabra = "";
                }
                i++;
            }

            //Se arreglan partes del texto (Suponiendo que solo se va a ingresar una oracion para traducir)
            int cont = 0;
            while (!Character.isLetter(traduccion.charAt(cont))) {
                cont++;
            }
            traduccion = traduccion.substring(0,cont) + Character.toUpperCase(traduccion.charAt(cont)) + traduccion.substring(cont+1, traduccion.length()-1) + ".";

            //Se muestra el texto traducido
            System.out.println("El texto traducido es:\n" + traduccion);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
