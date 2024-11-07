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
public class ArbolMVias<K extends Comparable<K>, T> implements IArbolBusqueda<K, T> {

    protected NodoMVias<K, T> raiz;
    protected int orden;
    protected static final int POSICION_INVALIDA = -1;
    protected static final int ORDEN_MINIMO = 3;

    public ArbolMVias() {
        this.orden = ORDEN_MINIMO;
    }

    public ArbolMVias(int orden) {
        if (orden < ORDEN_MINIMO) {
            throw new IllegalArgumentException("orden invalido");
        }
        this.orden = orden;
    }

    @Override
    public void insertar(K claveAInsertar, T datoAInsertar) {
        if (claveAInsertar == NodoMVias.Vacio() || datoAInsertar == NodoMVias.Vacio()) {
            throw new IllegalArgumentException("clave o dato a insertar nulo");
        }
        this.raiz = insertar(this.raiz, claveAInsertar, datoAInsertar);
    }

    private NodoMVias<K, T> insertar(NodoMVias<K, T> nodoActual, K claveAInsertar, T datoAInsertar) {

        if (NodoMVias.esNodoVacio(nodoActual)) {
            NodoMVias<K, T> nuevoNodo = new NodoMVias<>(this.orden, claveAInsertar, datoAInsertar);
            return nuevoNodo;
        }

        // Hay que insertar el dato  en nodo Hoja
        if (!nodoActual.estanClavesLlenas()) {
            // el nodo No esta lleno
            this.insertarEnNodoOrdenado(nodoActual, claveAInsertar, datoAInsertar);
            return nodoActual;
        }

        int posicionPorDondeBajar = this.buscarPosicionPorDondeBajar(nodoActual, claveAInsertar);
        NodoMVias<K, T> nuevoNodoHijo = insertar(nodoActual.getHijo(posicionPorDondeBajar), claveAInsertar, datoAInsertar);
        nodoActual.setHijo(posicionPorDondeBajar, nuevoNodoHijo);
        return nodoActual;

    }

    protected int buscarPosicionPorDondeBajar(NodoMVias<K, T> nodoActual, K claveABuscar) {
        for (int i = 0; i < nodoActual.nroDeClavesNoVacias(); i++) {
            K claveActual = nodoActual.getClave(i);
            if (claveABuscar.compareTo(claveActual) < 0) {
                return i;
            }
        }
        return nodoActual.nroDeClavesNoVacias();
    }

    protected void insertarEnNodoOrdenado(NodoMVias<K, T> nodoActual, K claveAInsertar, T datoAInsertar) {
        if (!nodoActual.estanClavesLlenas()) {
            for (int i = nodoActual.nroDeClavesNoVacias(); i > 0; i--) {
                K claveActual = nodoActual.getClave(i - 1);
                T datoActual = nodoActual.getDato(i - 1);
                if (claveAInsertar.compareTo(claveActual) > 0) {
                    nodoActual.setClave(i, claveAInsertar);
                    nodoActual.setDato(i, datoAInsertar);
                    return;
                }
                nodoActual.setClave(i, claveActual);
                nodoActual.setDato(i, datoActual);
            }
            nodoActual.setClave(0, claveAInsertar);
            nodoActual.setDato(0, datoAInsertar);
        }
    }

    @Override
    public void eliminar(K claveAEliminar) {
        if (claveAEliminar == NodoMVias.Vacio()) {
            throw new IllegalArgumentException("clave a eliminar nula");
        }
        this.raiz = eliminar(this.raiz, claveAEliminar);
    }

    private NodoMVias<K, T> eliminar(NodoMVias<K, T> nodoActual, K claveAEliminar) {

        if (NodoMVias.esNodoVacio(nodoActual)) {
            throw new IllegalArgumentException("Clave no se encuentra en el Arbol");
        }

        int posicionClaveEnNodo = this.buscarPosicionDeClaveEnNodo(nodoActual, claveAEliminar);
        if (posicionClaveEnNodo == POSICION_INVALIDA) {
            int posicionPorDondeBajar = this.buscarPosicionPorDondeBajar(nodoActual, claveAEliminar);
            NodoMVias<K, T> nuevoNodoHijo = eliminar(nodoActual.getHijo(posicionPorDondeBajar), claveAEliminar);
            nodoActual.setHijo(posicionPorDondeBajar, nuevoNodoHijo);
            return nodoActual;
        }

        // Pillo la clave en nodoActual
        if (nodoActual.esHoja()) {
            // si el Nodo Es Hoja

            if (nodoActual.nroDeClavesNoVacias() == 1) {
                return NodoMVias.nodoVacio();
            } else {
                this.eliminarClaveEnNodoHoja(nodoActual, claveAEliminar);
                return nodoActual;
            }
        }

        if (exiteHijosPosteriores(nodoActual, posicionClaveEnNodo)) {
            K claveSucesorInOrden = buscarClaveSucesorInOrden(nodoActual, posicionClaveEnNodo);
            T datoSucesorInOrden = buscarDatoSucesorInOrden(nodoActual, posicionClaveEnNodo);
            nodoActual = eliminar(nodoActual, claveSucesorInOrden);
            nodoActual.setClave(posicionClaveEnNodo, claveSucesorInOrden);
            nodoActual.setDato(posicionClaveEnNodo, datoSucesorInOrden);
            return nodoActual;
        }
        K clavePredecesorInOrden = buscarClavePredecesorInOrden(nodoActual, posicionClaveEnNodo);
        T datoPredecesorInOrden = buscarDatoPredecesorInOrden(nodoActual, posicionClaveEnNodo);
        nodoActual = eliminar(nodoActual, clavePredecesorInOrden);
        nodoActual.setClave(posicionClaveEnNodo, clavePredecesorInOrden);
        nodoActual.setDato(posicionClaveEnNodo, datoPredecesorInOrden);
        return nodoActual;

    }

    protected K buscarClavePredecesorInOrden(NodoMVias<K, T> nodoActual, int posicionActual) {
        if (nodoActual.esHijoVacio(posicionActual)) {
            return nodoActual.getClave(posicionActual - 1);
        }
        NodoMVias<K, T> nodoPredecesor = nodoActual.getHijo(posicionActual);
        while (!nodoPredecesor.esHijoVacio(0)) {
            nodoPredecesor = nodoPredecesor.getHijo(0);
        }
        return nodoPredecesor.getClave(nodoPredecesor.nroDeClavesNoVacias() - 1);
    }

    protected T buscarDatoPredecesorInOrden(NodoMVias<K, T> nodoActual, int posicionActual) {
        if (nodoActual.esHijoVacio(posicionActual)) {
            return nodoActual.getDato(posicionActual - 1);
        }
        NodoMVias<K, T> nodoPredecesor = nodoActual.getHijo(posicionActual);
        while (!nodoPredecesor.esHijoVacio(0)) {
            nodoPredecesor = nodoPredecesor.getHijo(0);
        }
        return nodoPredecesor.getDato(nodoPredecesor.nroDeClavesNoVacias() - 1);

    }

    protected K buscarClaveSucesorInOrden(NodoMVias<K, T> nodoActual, int posicionActual) {
        if (nodoActual.esHijoVacio(posicionActual + 1)) {
            return nodoActual.getClave(posicionActual + 1);
        }
        NodoMVias<K, T> nodoSucesor = nodoActual.getHijo(posicionActual + 1);
        while (!nodoSucesor.esHijoVacio(0)) {
            nodoSucesor = nodoSucesor.getHijo(0);
        }
        return nodoSucesor.getClave(0);
    }

    protected T buscarDatoSucesorInOrden(NodoMVias<K, T> nodoActual, int posicionActual) {
        if (nodoActual.esHijoVacio(posicionActual + 1)) {
            return nodoActual.getDato(posicionActual + 1);
        }
        NodoMVias<K, T> nodoSucesor = nodoActual.getHijo(posicionActual + 1);
        while (!nodoSucesor.esHijoVacio(0)) {
            nodoSucesor = nodoSucesor.getHijo(0);
        }
        return nodoSucesor.getDato(0);
    }

    private boolean exiteHijosPosteriores(NodoMVias<K, T> nodoActual, int posicionClaveEnNodo) {
        for (int i = posicionClaveEnNodo + 1; i <= nodoActual.nroDeClavesNoVacias(); i++) {
            if (!nodoActual.esHijoVacio(i)) {
                return true;
            }
        }
        return false;
    }

    protected void eliminarClaveEnNodoHoja(NodoMVias<K, T> nodoActual, K claveAEliminar) {

        int posicionActual = this.buscarPosicionDeClaveEnNodo(nodoActual, claveAEliminar);
        int posicionFinal = nodoActual.nroDeClavesNoVacias();
        for (int i = posicionActual; i < posicionFinal; i++) {

            if (!nodoActual.esClaveVacia(i + 1)) {
                K clave = nodoActual.getClave(i + 1);
                T dato = nodoActual.getDato(i + 1);
                nodoActual.setClave(i, clave);
                nodoActual.setDato(i, dato);
            } else {
                nodoActual.setClave(i, (K) NodoMVias.Vacio());
                nodoActual.setDato(i, (T) NodoMVias.Vacio());
            }
        }

    }

    protected int buscarPosicionDeClaveEnNodo(NodoMVias<K, T> nodoActual, K claveABuscar) {
        for (int i = 0; i < nodoActual.nroDeClavesNoVacias(); i++) {
            if (nodoActual.getClave(i).equals(claveABuscar)) {
                return i;
            }
        }
        return POSICION_INVALIDA;
    }

    @Override
    public boolean esArbolVacio() {
        return this.raiz == NodoMVias.Vacio();
    }

    @Override
    public int size() {
        return size(this.raiz);
    }

    private int size(NodoMVias<K, T> nodoActual) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return 0;
        }
        int sizeHijo = 0;
        for (int i = 0; i <= nodoActual.nroDeClavesNoVacias(); i++) {
            sizeHijo += size(nodoActual.getHijo(i));
        }
        int total = nodoActual.nroDeClavesNoVacias() + sizeHijo;
        return total;
    }

    @Override
    public int altura() {
        return altura(this.raiz);
    }

    private int altura(NodoMVias<K, T> nodoActual) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return 0;
        }
        if (nodoActual.esHoja()) {
            return 1;
        }

        int mayor = altura(nodoActual.getHijo(0));
        for (int i = 1; i <= nodoActual.nroDeClavesNoVacias(); i++) {
            int supuestoMayor = altura(nodoActual.getHijo(i));
            if (supuestoMayor > mayor) {
                mayor = supuestoMayor;
            }
        }
        return mayor + 1;
    }

    @Override
    public int nivel() {
        return this.altura() - 1;
    }

    @Override
    public K minimo() {
        if (this.esArbolVacio()) {
            return (K) NodoMVias.Vacio();
        }
        return minimo(this.raiz);
    }

    private K minimo(NodoMVias<K, T> nodoActual) {
        if (nodoActual.esHijoVacio(0)) {
            return nodoActual.getClave(0);
        }

        K minimo = minimo(nodoActual.getHijo(0));
        return minimo;
    }

    @Override
    public K maximo() {
        if (this.esArbolVacio()) {
            return (K) NodoMVias.Vacio();
        }
        return maximo(this.raiz);
    }

    private K maximo(NodoMVias<K, T> nodoActual) {
        if (nodoActual.esHijoVacio(nodoActual.nroDeClavesNoVacias())) {
            return nodoActual.getClave(nodoActual.nroDeClavesNoVacias() - 1);
        }

        K maximo = maximo(nodoActual.getHijo(nodoActual.nroDeClavesNoVacias()));
        return maximo;
    }

    @Override
    public List<K> recorridoPreOrden() {
        List<K> recorrido = new LinkedList<>();
        recorridoPreOrden(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoPreOrden(NodoMVias<K, T> nodoActual, List<K> recorrido) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return;
        }

        for (int i = 0; i < nodoActual.nroDeClavesNoVacias(); i++) {
            recorrido.add(nodoActual.getClave(i));
            recorridoPreOrden(nodoActual.getHijo(i), recorrido);

        }

        NodoMVias<K, T> ultimaClave = nodoActual.getHijo(nodoActual.nroDeClavesNoVacias());
        recorridoPreOrden(ultimaClave, recorrido);
    }

    @Override
    public List<K> recorridoInOrden() {
        List<K> recorrido = new LinkedList<>();
        recorridoInOrden(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoInOrden(NodoMVias<K, T> nodoActual, List<K> recorrido) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return;
        }

        for (int i = 0; i < nodoActual.nroDeClavesNoVacias(); i++) {
            recorridoInOrden(nodoActual.getHijo(i), recorrido);
            recorrido.add(nodoActual.getClave(i));
        }
        NodoMVias<K, T> ultimaClave = nodoActual.getHijo(nodoActual.nroDeClavesNoVacias());
        recorridoInOrden(ultimaClave, recorrido);
    }

    @Override
    public List<K> recorridoPostOrden() {
        List<K> recorrido = new LinkedList<>();
        recorridoPostOrden(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoPostOrden(NodoMVias<K, T> nodoActual, List<K> recorrido) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return;
        }

        for (int i = 0; i < nodoActual.nroDeClavesNoVacias(); i++) {

            if (i == 0) {
                recorridoPostOrden(nodoActual.getHijo(i), recorrido);
                recorridoPostOrden(nodoActual.getHijo(i + 1), recorrido);
                recorrido.add(nodoActual.getClave(i));
            } else {
                recorridoPostOrden(nodoActual.getHijo(i + 1), recorrido);
                recorrido.add(nodoActual.getClave(i));
            }

        }
    }

    @Override
    public T contiene(K claveABuscar) {
        if (claveABuscar == NodoMVias.Vacio()) {
            throw new IllegalArgumentException("clave a eliminar nula");
        }
        return contiene(this.raiz, claveABuscar);
    }

    protected T contiene(NodoMVias<K, T> nodoActual, K claveABuscar) {

        if (NodoMVias.esNodoVacio(nodoActual)) {
            return (T) NodoMVias.Vacio();
        }

        int posicionClaveEnNodo = this.buscarPosicionDeClaveEnNodo(nodoActual, claveABuscar);

        if (posicionClaveEnNodo == POSICION_INVALIDA) {
            int posicionPorDondeBajar = this.buscarPosicionPorDondeBajar(nodoActual, claveABuscar);
            return contiene(nodoActual.getHijo(posicionPorDondeBajar), claveABuscar);
        }
        return nodoActual.getDato(posicionClaveEnNodo);
    }

    @Override
    public List<K> recorridoPorNiveles() {
        List<K> recorrido = new LinkedList<>();
        if (!esArbolVacio()) {
            Queue<NodoMVias<K, T>> colaDeNodos = new LinkedList<>();
            colaDeNodos.add(this.raiz);
            while (!colaDeNodos.isEmpty()) {
                NodoMVias<K, T> nodoActual = colaDeNodos.poll();
                for (int i = 0; i < nodoActual.nroDeClavesNoVacias(); i++) {
                    recorrido.add(nodoActual.getClave(i));
                    if (!nodoActual.esHijoVacio(i)) {
                        colaDeNodos.add(nodoActual.getHijo(i));
                    }
                }
                if (!nodoActual.esHijoVacio(nodoActual.nroDeClavesNoVacias())) {
                    colaDeNodos.add(nodoActual.getHijo(nodoActual.nroDeClavesNoVacias()));
                }
            }
        }
        return recorrido;
    }

    @Override
    public String toString() {
        String datos = "";
        if (!esArbolVacio()) {
            NodoMVias<K, T> nodoActual = this.raiz;
            int nivel = 0;
            Queue<NodoMVias<K, T>> colaDeNodos = new LinkedList<>();
            colaDeNodos.add(this.raiz);

            while (nivel <= this.nivel()) {
                datos = datos + "nivel : " + nivel + "  ";
                Queue<NodoMVias<K, T>> colaDeNodosHijos = new LinkedList<>();
                int cantNodo = colaDeNodos.size();

                for (int i = 0; i < cantNodo; i++) {
                    nodoActual = colaDeNodos.poll();

                    for (int j = 0; j < this.orden; j++) {
                        if (!NodoMVias.esNodoVacio(nodoActual)) {
                            NodoMVias<K, T> nodoAux = nodoActual.getHijo(j);
                            colaDeNodosHijos.add(nodoAux);
                        }
                    }

                    datos = datos + this.mostrarNodo(nodoActual);

                }
                datos = datos + "\n";
                colaDeNodos = colaDeNodosHijos;
                nivel++;
            }

        }
        return datos;
    }

    private String mostrarNodo(NodoMVias<K, T> nodoActual) {

        if (NodoMVias.esNodoVacio(nodoActual)) {
            return "[-]";
        }

        String datos = "";
        for (int i = 0; i < this.orden - 1; i++) {
            if (nodoActual.esClaveVacia(i)) {
                datos = datos + "-,";
            } else {
                datos = datos + nodoActual.getClave(i) + ",";
            }
        }
        datos = datos.substring(0, datos.length() - 1);
        return "[ " + datos + " ]";
    }

    @Override
    public void vaciar() {
      this.raiz=NodoMVias.nodoVacio();
    }

}
