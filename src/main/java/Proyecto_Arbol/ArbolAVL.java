/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Arbol;

/**
 *
 * @author cobu-
 * @param <K>
 * @param <T>
 */
public class ArbolAVL<K extends Comparable<K>, T> extends ArbolBinario<K, T> {

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
            return balancear(nodoActual);
        } else if (claveAInsertar.compareTo(nodoActual.getClave()) > 0) {
            NodoBinario<K, T> nuevoHijoDerecho = insertar(nodoActual.getHijoDerecho(), claveAInsertar, datoAInsertar);
            nodoActual.setHijoDerecho(nuevoHijoDerecho);
            return balancear(nodoActual);
        }

        throw new IllegalArgumentException("dato ya existe en el nodo");

    }

    private int peso(NodoBinario<K, T> nodo) {
        return altura(nodo.getHijoDerecho()) - altura(nodo.getHijoIzquierdo());
    }

    private NodoBinario<K, T> balancear(NodoBinario<K, T> nodoActual) {

        int peso = peso(nodoActual);

        if (peso < -1) {
            NodoBinario<K, T> nuevoNodo = nodoActual.getHijoIzquierdo();
            peso = peso(nuevoNodo);
            if (peso > 0) {
                return rotacionDobleDer(nodoActual);
            } else {
                return rotacionSimpleDer(nodoActual);
            }
        } else if (peso > 1) {
            NodoBinario<K, T> nuevoNodo = nodoActual.getHijoDerecho();
            peso = peso(nuevoNodo);
            if (peso < 0) {
                return rotacionDobleIz(nodoActual);
            } else {
                return rotacionSimpleIz(nodoActual);
            }
        }

        return nodoActual;

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
            return balancear(nodoActual);
        } else if (claveAEliminar.compareTo(nodoActual.getClave()) > 0) {
            NodoBinario<K, T> nuevoHijoDerecho = eliminar(nodoActual.getHijoDerecho(), claveAEliminar);
            nodoActual.setHijoDerecho(nuevoHijoDerecho);
            return balancear(nodoActual);
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

    private NodoBinario<K, T> rotacionSimpleIz(NodoBinario<K, T> nodoActual) {
        NodoBinario<K, T> nuevoNodo = nodoActual.getHijoDerecho();
        nodoActual.setHijoDerecho(nuevoNodo.getHijoIzquierdo());
        nuevoNodo.setHijoIzquierdo(nodoActual);
        return nuevoNodo;
    }

    private NodoBinario<K, T> rotacionSimpleDer(NodoBinario<K, T> nodoActual) {
        NodoBinario<K, T> nuevoNodo = nodoActual.getHijoIzquierdo();
        nodoActual.setHijoIzquierdo(nuevoNodo.getHijoDerecho());
        nuevoNodo.setHijoDerecho(nodoActual);
        return nuevoNodo;
    }

    private NodoBinario<K, T> rotacionDobleIz(NodoBinario<K, T> nodoActual) {
        NodoBinario<K, T> nuevoHijoDerecho = rotacionSimpleDer(nodoActual.getHijoDerecho());
        nodoActual.setHijoDerecho(nuevoHijoDerecho);
        return rotacionSimpleIz(nodoActual);
    }

    private NodoBinario<K, T> rotacionDobleDer(NodoBinario<K, T> nodoActual) {
        NodoBinario<K, T> nuevoHijoIzquierdo = rotacionSimpleIz(nodoActual.getHijoIzquierdo());
        nodoActual.setHijoIzquierdo(nuevoHijoIzquierdo);
        return rotacionSimpleDer(nodoActual);

    }

}
