/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Proyecto_Arbol;

import java.util.List;

/**
 *
 * @author cobu-
 * @param <T>
 */
public interface IArbolBusqueda<K extends Comparable<K>,T> {
    public void insertar(K claveAInsertar,T datoAInsertar);
    public void eliminar(K claveAEliminar);
    public boolean esArbolVacio();
    public T contiene(K claveABuscar);
    public int size();
    public int altura();
    public int nivel();
    public K minimo();
    public K maximo();
    public void vaciar();
    public List<K> recorridoPreOrden();
    public List<K> recorridoInOrden();
    public List<K> recorridoPostOrden();
    public List<K> recorridoPorNiveles();
}
