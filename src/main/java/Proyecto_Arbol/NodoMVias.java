/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Arbol;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author cobu-
 * @param <K>
 * @param <T>
 */
public class NodoMVias<K, T> {

    private List<K> listaDeClaves;
    private List<T> listaDeDatos;
    private List<NodoMVias<K, T>> listaDeHijos;

    public NodoMVias(int orden) {
        listaDeClaves = new LinkedList<>();
        listaDeDatos = new LinkedList<>();
        listaDeHijos = new LinkedList<>();

        for (int i = 0; i < orden - 1; i++) {
            listaDeClaves.add((K) Vacio());
            listaDeDatos.add((T) Vacio());
            listaDeHijos.add(nodoVacio());
        }
        listaDeHijos.add(nodoVacio());
    }

    public NodoMVias(int orden, K clave, T dato) {
        this(orden);
        listaDeClaves.set(0, clave);
        listaDeDatos.set(0, dato);
    }

    public static NodoMVias nodoVacio() {
        return null;
    }

    public static Object Vacio() {
        return null;
    }

    public T getDato(int posicion) {
        return this.listaDeDatos.get(posicion);
    }

    public K getClave(int posicion) {
        return this.listaDeClaves.get(posicion);
    }

    public NodoMVias<K, T> getHijo(int posicion) {
        return this.listaDeHijos.get(posicion);
    }

    public void setClave(int posicion, K clave) {
        this.listaDeClaves.set(posicion, clave);
    }

    public void setDato(int posicion, T dato) {
        this.listaDeDatos.set(posicion, dato);
    }

    public void setHijo(int posicion, NodoMVias<K, T> hijo) {
        this.listaDeHijos.set(posicion, hijo);
    }

    public boolean esHoja() {
        for (int i = 0; i < this.listaDeHijos.size(); i++) {
            if (!esHijoVacio(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean esClaveVacia(int posicion) {
        return this.listaDeClaves.get(posicion) == Vacio();
    }

    public boolean esHijoVacio(int posicion) {
        return this.listaDeHijos.get(posicion) == nodoVacio();
    }

    public int nroDeClavesNoVacias() {

        int nroClavesNoVacias = 0;
        for (int i = 0; i < this.listaDeClaves.size(); i++) {
            if (!esClaveVacia(i)) {
                nroClavesNoVacias++;
            }
        }
        return nroClavesNoVacias;
    }

    public boolean estanClavesLlenas() {
        return nroDeClavesNoVacias() == this.listaDeClaves.size();
    }

    public static boolean esNodoVacio(NodoMVias nodo) {
        return nodo == NodoMVias.nodoVacio();
    }

    public boolean verificarExisteClaveEnNodo(K clave) {
      return this.listaDeClaves.contains(clave);
    }
    
}
