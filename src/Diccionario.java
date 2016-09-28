/*
Algoritmos y Estructuras de Datos
Hoja de trabajo 7

Integrantes:
Alejandro Chaclan 15018
Jose Javier Jo 14343
*/

public interface Diccionario<E, K> {
    public void add(E entrada, K data);

    public String searchInOrder (E tree, String key);

    public String InOrder (E tree);
}
