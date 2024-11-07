/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Arbol;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author cobu-
 * @param <K>
 * @param <T>
 */
public class ArbolBinario<K extends Comparable<K>, T> implements IArbolBusqueda<K, T> {

    protected NodoBinario<K, T> raiz;

    public ArbolBinario() {
    }

    public ArbolBinario(NodoBinario<K, T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public void insertar(K claveAInsertar, T datoAInsertar) {
        this.raiz = insertar(this.raiz, claveAInsertar, datoAInsertar);
    }

    private NodoBinario<K, T> insertar(NodoBinario<K, T> nodoActual, K claveAInsertar, T datoAInsertar) {
        if (claveAInsertar == null || datoAInsertar == null) {
            throw new IllegalArgumentException("valor nulo");
        }

        if (NodoBinario.esNodoVacio(nodoActual)) {
            NodoBinario<K, T> nuevoNodo = new NodoBinario<>(claveAInsertar, datoAInsertar);
            return nuevoNodo;
        }

        if (claveAInsertar.compareTo(nodoActual.getClave()) < 0) {
            NodoBinario<K, T> nuevoHijoIzquierdo = insertar(nodoActual.getHijoIzquierdo(), claveAInsertar, datoAInsertar);
            nodoActual.setHijoIzquierdo(nuevoHijoIzquierdo);
            return nodoActual;
        } else if (claveAInsertar.compareTo(nodoActual.getClave()) > 0) {
            NodoBinario<K, T> nuevoHijoDerecho = insertar(nodoActual.getHijoDerecho(), claveAInsertar, datoAInsertar);
            nodoActual.setHijoDerecho(nuevoHijoDerecho);
            return nodoActual;
        }

        throw new IllegalArgumentException("dato ya existe en el nodo");
    }

    @Override
    public void eliminar(K claveAEliminar) {
        this.raiz = eliminar(this.raiz, claveAEliminar);
    }

    private NodoBinario<K, T> eliminar(NodoBinario<K, T> nodoActual, K claveAEliminar) {
        if (claveAEliminar == null) {
            throw new IllegalArgumentException("valor nulo");
        }

        if (NodoBinario.esNodoVacio(nodoActual)) {
            throw new IllegalArgumentException("dato no existe en el arbol");
        }

        if (claveAEliminar.compareTo(nodoActual.getClave()) < 0) {
            NodoBinario<K, T> nuevoHijoIzquierdo = eliminar(nodoActual.getHijoIzquierdo(), claveAEliminar);
            nodoActual.setHijoIzquierdo(nuevoHijoIzquierdo);
            return nodoActual;
        } else if (claveAEliminar.compareTo(nodoActual.getClave()) > 0) {
            NodoBinario<K, T> nuevoHijoDerecho = eliminar(nodoActual.getHijoDerecho(), claveAEliminar);
            nodoActual.setHijoDerecho(nuevoHijoDerecho);
            return nodoActual;
        }

        //CASO 1 EL NODO ES  HOJA
        if (nodoActual.esHoja()) {
            return NodoBinario.nodoVacio();
        }
        //CASO 2 EL NODO TIENE UN SOLO HIJO
        if (!nodoActual.esVacioHijoIzquierdo() && nodoActual.esVacioHijoDerecho()) {
            return nodoActual.getHijoIzquierdo();
        }
        if (nodoActual.esVacioHijoIzquierdo() && !nodoActual.esVacioHijoDerecho()) {
            return nodoActual.getHijoDerecho();
        }
        //CASO 3 EL NODO TIENE DOS HIJOS
        NodoBinario<K, T> nodoReemplazo = obtenerNodoSucesorInOrden(nodoActual.getHijoDerecho());
        K claveReemplazo = nodoReemplazo.getClave();
        T datoReemplazo = nodoReemplazo.getDato();
        NodoBinario<K, T> supuestoNuevoHD = eliminar(nodoActual.getHijoDerecho(), claveReemplazo);
        nodoActual.setHijoDerecho(supuestoNuevoHD);
        nodoActual.setDato(datoReemplazo);
        nodoActual.setClave(claveReemplazo);
        return nodoActual;

    }

    protected NodoBinario<K, T> obtenerNodoSucesorInOrden(NodoBinario<K, T> nodoActual) {

        NodoBinario<K, T> nodoSucesor = nodoActual;
        while (!nodoSucesor.esVacioHijoIzquierdo()) {
            nodoSucesor = nodoSucesor.getHijoIzquierdo();
        }
        return nodoSucesor;
    }

    @Override
    public boolean esArbolVacio() {
        return this.raiz == NodoBinario.nodoVacio();
    }

    @Override
    public int size() {
        return size(this.raiz);
    }

    private int size(NodoBinario<K, T> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return 0;
        }
        if (nodoActual.esHoja()) {
            return 1;
        }
        int sizeIz = size(nodoActual.getHijoIzquierdo());
        int sizeDer = size(nodoActual.getHijoDerecho());
        int size = sizeIz + sizeDer + 1;
        return size;
    }

    @Override
    public int altura() {
        return altura(this.raiz);
    }

    protected int altura(NodoBinario<K, T> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return 0;
        }
        if (nodoActual.esHoja()) {
            return 1;
        }

        int alturaDer = altura(nodoActual.getHijoDerecho());
        int alturaIz = altura(nodoActual.getHijoIzquierdo());
        if (alturaDer > alturaIz) {
            return alturaDer + 1;
        } else {
            return alturaIz + 1;
        }
    }

    @Override
    public int nivel() {
        return altura() - 1;
    }

    @Override
    public K minimo() {
        if (esArbolVacio()) {
            throw new IllegalArgumentException("arbol Vacio");
        }
        NodoBinario<K, T> nodoActual = this.raiz;
        while (!nodoActual.esVacioHijoIzquierdo()) {
            nodoActual = nodoActual.getHijoIzquierdo();
        }
        K minimo = nodoActual.getClave();
        return minimo;

    }

    @Override
    public K maximo() {
        if (esArbolVacio()) {
            throw new IllegalArgumentException("arbol Vacio");
        }
        NodoBinario<K, T> nodoActual = this.raiz;
        while (!nodoActual.esVacioHijoDerecho()) {
            nodoActual = nodoActual.getHijoDerecho();
        }
        K maximo = nodoActual.getClave();
        return maximo;
    }

    @Override
    public List<K> recorridoPreOrden() {
        List<K> recorrido = new LinkedList<>();
        recorridoPreOrden(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoPreOrden(NodoBinario<K, T> nodoActual, List<K> recorrido) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return;
        }
        recorrido.add(nodoActual.getClave());
        recorridoPreOrden(nodoActual.getHijoIzquierdo(), recorrido);
        recorridoPreOrden(nodoActual.getHijoDerecho(), recorrido);
    }

    @Override
    public List<K> recorridoInOrden() {
        List<K> recorrido = new LinkedList<>();
        recorridoInOrden(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoInOrden(NodoBinario<K, T> nodoActual, List<K> recorrido) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return;
        }
        recorridoInOrden(nodoActual.getHijoIzquierdo(), recorrido);
        recorrido.add(nodoActual.getClave());
        recorridoInOrden(nodoActual.getHijoDerecho(), recorrido);
    }

    @Override
    public List<K> recorridoPostOrden() {
        List<K> recorrido = new LinkedList<>();
        recorridoPostOrden(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoPostOrden(NodoBinario<K, T> nodoActual, List<K> recorrido) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return;
        }
        recorridoPostOrden(nodoActual.getHijoIzquierdo(), recorrido);
        recorridoPostOrden(nodoActual.getHijoDerecho(), recorrido);
        recorrido.add(nodoActual.getClave());
    }

    @Override
    public T contiene(K claveABuscar) {
        if (claveABuscar == null) {
            throw new IllegalArgumentException("clave no valida");
        }
        return contiene(this.raiz, claveABuscar);
    }

    private T contiene(NodoBinario<K, T> nodoActual, K claveABuscar) {

        if (NodoBinario.esNodoVacio(nodoActual)) {
            return (T) NodoBinario.datoVacio();
        }

        if (claveABuscar.compareTo(nodoActual.getClave()) < 0) {

            return contiene(nodoActual.getHijoIzquierdo(), claveABuscar);
        } else if (claveABuscar.compareTo(nodoActual.getClave()) > 0) {

            return contiene(nodoActual.getHijoDerecho(), claveABuscar);
        }

        return nodoActual.getDato();

    }

    @Override
    public List<K> recorridoPorNiveles() {
        List<K> recorrido = new LinkedList<>();
        if (!esArbolVacio()) {
            Queue<NodoBinario<K, T>> colaDeNodos = new LinkedList<>();
            colaDeNodos.add(this.raiz);
            while (!colaDeNodos.isEmpty()) {
                NodoBinario<K, T> nodoActual = colaDeNodos.poll();
                if (!nodoActual.esVacioHijoIzquierdo()) {
                    colaDeNodos.add(nodoActual.getHijoIzquierdo());
                }
                if (!nodoActual.esVacioHijoDerecho()) {
                    colaDeNodos.add(nodoActual.getHijoDerecho());
                }
                recorrido.add(nodoActual.getClave());
            }
        }
        return recorrido;
    }

    @Override
    public String toString() {
        return mostrarArbol(this.raiz, "",true);
    }
public String mostrarArbol(NodoBinario<K, T> nodoActual, String prefijo, boolean esHijoIzquierdo) {
  if (NodoBinario.esNodoVacio(nodoActual)) {
        return "";
    }

    StringBuilder representacion = new StringBuilder();
    representacion.append(prefijo).append(nodoActual.getClave()).append("\n");

    // Verificamos si tiene hijos izquierdo o derecho
    if (!nodoActual.esVacioHijoIzquierdo() || !nodoActual.esVacioHijoDerecho()) {

        // Hijo izquierdo: Si tiene hijo izquierdo, imprimimos el formato correcto.
       

        // Hijo derecho: Si tiene hijo derecho, se imprime con el formato adecuado. 
        if (!nodoActual.esVacioHijoDerecho()) {
            representacion.append(mostrarArbol(nodoActual.getHijoDerecho(), prefijo + " ├── ", false)); // Recursión para el hijo derecho
        } else {
            representacion.append(prefijo).append(" ├──  ( - )\n"); // Si no tiene hijo derecho, imprimimos ( - )
        }
         if (!nodoActual.esVacioHijoIzquierdo()) {
            representacion.append(mostrarArbol(nodoActual.getHijoIzquierdo(), prefijo + " └── ", true)); // Recursión para el hijo izquierdo
        } else {
            representacion.append(prefijo).append(" └──  ( - )\n"); // Si no tiene hijo izquierdo, imprimimos ( - )
        }
    }

    return representacion.toString();
}

    @Override
    public void vaciar() {
      this.raiz=NodoBinario.nodoVacio();
    }
   

}
