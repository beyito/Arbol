/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Arbol;

import java.util.Stack;

/**
 *
 * @author cobu-
 * @param <K>
 * @param <T>
 */
public class ArbolB<K extends Comparable<K>, T> extends ArbolMVias<K, T> {

    private int nroMaximoDeDatos;
    private int nroMinimoDeDatos;
    private int nroMinimoDeHijos;

    public ArbolB() {
        super();
        this.nroMaximoDeDatos = 2;
        this.nroMinimoDeDatos = 1;
        this.nroMinimoDeHijos = 2;
    }

    public ArbolB(int orden) {
        super(orden);
        this.nroMaximoDeDatos = super.orden - 1;
        this.nroMinimoDeDatos = this.nroMaximoDeDatos / 2;
        this.nroMinimoDeHijos = this.nroMinimoDeDatos + 1;
    }

    @Override
    public void insertar(K claveAInsertar, T datoAInsertar) {
        if (super.esArbolVacio()) {
            NodoMVias<K, T> nuevaRaiz = new NodoMVias<>(super.orden + 1, claveAInsertar, datoAInsertar);
            this.raiz = nuevaRaiz;
            return;
        }
        Stack<NodoMVias<K, T>> pilaDeAncestros = new Stack<>();
        NodoMVias<K, T> nodoActual = this.raiz;
        while (!NodoMVias.esNodoVacio(nodoActual)) {
            int posicionClaveEnNodo = super.buscarPosicionDeClaveEnNodo(nodoActual, claveAInsertar);
            if (posicionClaveEnNodo != POSICION_INVALIDA) {
                throw new IllegalArgumentException("clave ya existe en el arbol");
            } else {
                if (nodoActual.esHoja()) {
                    super.insertarEnNodoOrdenado(nodoActual, claveAInsertar, datoAInsertar);
                    if (nodoActual.nroDeClavesNoVacias() > nroMaximoDeDatos) {
                        this.dividir(nodoActual, pilaDeAncestros);
                    }
                    nodoActual = NodoMVias.nodoVacio();
                } else {
                    int posicionPorDondeBajar = super.buscarPosicionPorDondeBajar(nodoActual, claveAInsertar);
                    pilaDeAncestros.push(nodoActual);
                    nodoActual = nodoActual.getHijo(posicionPorDondeBajar);
                }
            }
        }
    }

    private void dividir(NodoMVias<K, T> nodoActual, Stack<NodoMVias<K, T>> pilaDeAncestros) {

        do {
            if (nodoActual.nroDeClavesNoVacias() <= nroMaximoDeDatos) {
                return;
            }

            NodoMVias<K, T> nuevoHijoIz = new NodoMVias<>(super.orden + 1);
            NodoMVias<K, T> nuevoHijoDer = new NodoMVias<>(super.orden + 1);
            for (int i = 0; i <= nroMaximoDeDatos; i++) {
                NodoMVias<K, T> hijo = nodoActual.getHijo(i);
                K clave = nodoActual.getClave(i);
                T dato = nodoActual.getDato(i);
                if (i < nroMinimoDeDatos) {
                    nuevoHijoIz.setClave(i, clave);
                    nuevoHijoIz.setDato(i, dato);
                    nuevoHijoIz.setHijo(i, hijo);
                } else if (i > nroMinimoDeDatos) {
                    nuevoHijoDer.setClave(i - nroMinimoDeDatos - 1, clave);
                    nuevoHijoDer.setDato(i - nroMinimoDeDatos - 1, dato);
                    nuevoHijoDer.setHijo(i - nroMinimoDeDatos - 1, hijo);
                } else if (i == nroMinimoDeDatos) {
                    nuevoHijoIz.setHijo(i, hijo);
                }

            }
            nuevoHijoDer.setHijo(nroMaximoDeDatos - nroMinimoDeDatos, nodoActual.getHijo(nroMaximoDeDatos + 1));
            K claveAux = nodoActual.getClave(nroMinimoDeDatos);
            T datoAux = nodoActual.getDato(nroMinimoDeDatos);
            NodoMVias<K, T> nodoPadre;
            if (nodoActual == this.raiz) {
                nodoPadre = new NodoMVias(super.orden + 1, claveAux, datoAux);
                nodoPadre.setHijo(0, nuevoHijoIz);
                nodoPadre.setHijo(1, nuevoHijoDer);
                this.raiz = nodoPadre;
            } else {
                nodoPadre = pilaDeAncestros.pop();
                int posicionHijoIz = super.buscarPosicionPorDondeBajar(nodoPadre, claveAux);
                this.insertarYRecorrerArbol(nodoPadre, claveAux, datoAux);
                nodoPadre.setHijo(posicionHijoIz, nuevoHijoIz);
                nodoPadre.setHijo(posicionHijoIz + 1, nuevoHijoDer);
                nodoActual = nodoPadre;
            }
        } while (!pilaDeAncestros.isEmpty() || nodoActual == this.raiz);

    }

    private void insertarYRecorrerArbol(NodoMVias<K, T> nodoActual, K claveAInsertar, T datoAInsertar) {

        int posicionInicial = super.buscarPosicionPorDondeBajar(nodoActual, claveAInsertar);
        for (int i = nodoActual.nroDeClavesNoVacias() - 1; i >= posicionInicial; i--) {
            K clave = nodoActual.getClave(i);
            T dato = nodoActual.getDato(i);
            NodoMVias<K, T> nodoHijo = nodoActual.getHijo(i + 1);
            nodoActual.setClave(i + 1, clave);
            nodoActual.setDato(i + 1, dato);
            nodoActual.setHijo(i + 2, nodoHijo);
        }
        nodoActual.setClave(posicionInicial, claveAInsertar);
        nodoActual.setDato(posicionInicial, datoAInsertar);
    }

    @Override
    public void eliminar(K claveAEliminar) {
        if (claveAEliminar == NodoMVias.Vacio()) {
            throw new IllegalArgumentException("clave invalida");
        }

        Stack<NodoMVias<K, T>> pilaDeAncestros = new Stack<>();
        NodoMVias<K, T> nodoActual = this.buscarNodoDeClave(claveAEliminar, pilaDeAncestros);
        if (NodoMVias.esNodoVacio(nodoActual)) {
            throw new IllegalArgumentException("clave no es encuentra en el arbol");
        }
        int posicionClaveEnNodo = super.buscarPosicionDeClaveEnNodo(nodoActual, claveAEliminar);

        if (nodoActual.esHoja()) {
            super.eliminarClaveEnNodoHoja(nodoActual, claveAEliminar);
            if (nodoActual.nroDeClavesNoVacias() < nroMinimoDeDatos) {
                if (pilaDeAncestros.isEmpty()) {
                    if (nodoActual.nroDeClavesNoVacias() == 0) {
                        this.raiz = NodoMVias.nodoVacio();
                    }
                } else {
                    this.prestarseOFusionarse(nodoActual, pilaDeAncestros);
                }
            }
        } else {

            pilaDeAncestros.push(nodoActual);

            NodoMVias<K, T> nodoDelPredecesor = this.buscarNodoDelPredecesor(nodoActual.getHijo(posicionClaveEnNodo), pilaDeAncestros);

            int posicionDelPredecesor = nodoDelPredecesor.nroDeClavesNoVacias() - 1;

            K clavePredecesor = nodoDelPredecesor.getClave(posicionDelPredecesor);

            T datoPredecesor = nodoDelPredecesor.getDato(posicionDelPredecesor);

            super.eliminarClaveEnNodoHoja(nodoDelPredecesor, clavePredecesor);

            nodoActual.setClave(posicionClaveEnNodo, clavePredecesor);
            nodoActual.setDato(posicionClaveEnNodo, datoPredecesor);

            if (nodoDelPredecesor.nroDeClavesNoVacias() < this.nroMinimoDeDatos) {
                this.prestarseOFusionarse(nodoDelPredecesor, pilaDeAncestros);
            }
        }
    }

    private NodoMVias<K, T> buscarNodoDelPredecesor(NodoMVias<K, T> nodoActual, Stack<NodoMVias<K, T>> pilaDeAncestros) {

        while (!nodoActual.esHijoVacio(nodoActual.nroDeClavesNoVacias())) {
            pilaDeAncestros.push(nodoActual);
            nodoActual = nodoActual.getHijo(nodoActual.nroDeClavesNoVacias());
        }
        return nodoActual;
    }

    private void prestarseOFusionarse(NodoMVias<K, T> nodoActual, Stack<NodoMVias<K, T>> pilaDeAncestros) {

        if (nodoActual == this.raiz) {
            if (this.raiz.nroDeClavesNoVacias() > 0) {
                return;
            } else {
                this.raiz = NodoMVias.nodoVacio();
            }
        } else {

            do {
                NodoMVias<K, T> nodoPadre = pilaDeAncestros.pop();

                if (nodoActual.nroDeClavesNoVacias() < this.nroMinimoDeDatos) {

                    int posicionHijo = this.buscarPosicionDeHijoEnNodo(nodoPadre, nodoActual);

                    if ((posicionHijo == 0 && !NodoMVias.esNodoVacio(nodoPadre.getHijo(posicionHijo + 1)) && nodoPadre.getHijo(posicionHijo + 1).nroDeClavesNoVacias() > this.nroMinimoDeDatos)
                            || (!NodoMVias.esNodoVacio(nodoPadre.getHijo(posicionHijo + 1)) && nodoPadre.getHijo(posicionHijo + 1).nroDeClavesNoVacias() > this.nroMinimoDeDatos)
                            || (posicionHijo > 0 && !NodoMVias.esNodoVacio(nodoPadre.getHijo(posicionHijo - 1)) && nodoPadre.getHijo(posicionHijo - 1).nroDeClavesNoVacias() > this.nroMinimoDeDatos)) {

                        this.prestarse(nodoActual, nodoPadre);
                    } else {

                        this.fusionarse(nodoActual, nodoPadre);
                    }
                }
                nodoActual = nodoPadre;
            } while (!pilaDeAncestros.isEmpty());
        }
    }

    private void fusionarse(NodoMVias<K, T> nodoActual, NodoMVias<K, T> nodoPadre) {

        int posicionHijo = this.buscarPosicionDeHijoEnNodo(nodoPadre, nodoActual);

        if (posicionHijo == 0 || !nodoPadre.esHijoVacio(posicionHijo + 1)) {

            NodoMVias<K, T> nodoAPrestar = nodoPadre.getHijo(posicionHijo + 1);
            this.fusionarDer(nodoActual, nodoPadre, nodoAPrestar);

            this.recorrerNodoHaciaIz(nodoPadre, posicionHijo);
            nodoPadre.setHijo(posicionHijo, nodoActual);

        } else{

            NodoMVias<K, T> nodoAPrestar = nodoPadre.getHijo(posicionHijo - 1);
            NodoMVias<K, T> nuevoNodo = this.fusionarIz(nodoAPrestar, nodoPadre, nodoActual);
            this.recorrerNodoHaciaIz(nodoPadre, posicionHijo - 1);

            if (nodoActual == this.raiz && nodoActual.nroDeClavesNoVacias() == 0) {
                this.raiz = nuevoNodo;
            } else {

                nodoPadre.setHijo(posicionHijo - 1, nuevoNodo);

                nodoPadre.setHijo(posicionHijo , NodoMVias.nodoVacio());
            }

        }

    }

    public void fusionarDer(NodoMVias<K, T> nodoIz, NodoMVias<K, T> nodoPadre, NodoMVias<K, T> nodoDer) {

        int posicionPadre = this.buscarPosicionDeHijoEnNodo(nodoPadre, nodoIz);
        K clave = nodoPadre.getClave(posicionPadre);
        T dato = nodoPadre.getDato(posicionPadre);
        nodoIz.setClave(nroMinimoDeDatos - 1, clave);
        nodoIz.setDato(nroMinimoDeDatos - 1, dato);
        for (int i = 0; i < nroMinimoDeDatos; i++) {
            clave = nodoDer.getClave(i);
            dato = nodoDer.getDato(i);
            NodoMVias<K, T> hijo = nodoDer.getHijo(i);
            if (!NodoMVias.esNodoVacio(hijo)) {
                nodoIz.setHijo(i + nroMinimoDeDatos, hijo);
            }
            nodoIz.setClave(i + nroMinimoDeDatos, clave);
            nodoIz.setDato(i + nroMinimoDeDatos, dato);

        }
        nodoIz.setHijo(nodoIz.nroDeClavesNoVacias() + 1, nodoDer.getHijo(nodoDer.nroDeClavesNoVacias()));
        nodoPadre.setHijo(posicionPadre + 1, NodoMVias.nodoVacio());

    }

    public NodoMVias<K, T> fusionarIz(NodoMVias<K, T> nodoIz, NodoMVias<K, T> nodoPadre, NodoMVias<K, T> nodoDer) {

        int posicionPadre = this.buscarPosicionDeHijoEnNodo(nodoPadre, nodoIz);

        NodoMVias<K, T> nuevoNodo = new NodoMVias<>(super.orden + 1);
        K clave;
        T dato;
        NodoMVias<K, T> hijo;
        for (int i = 0; i < nodoIz.nroDeClavesNoVacias(); i++) {
            clave = nodoIz.getClave(i);
            dato = nodoIz.getDato(i);
            hijo = nodoIz.getHijo(i);
            nuevoNodo.setClave(i, clave);
            nuevoNodo.setDato(i, dato);
            nuevoNodo.setHijo(i, hijo);
        }
        nuevoNodo.setHijo(nuevoNodo.nroDeClavesNoVacias(), nodoIz.getHijo(nodoIz.nroDeClavesNoVacias()));
        clave = nodoPadre.getClave(posicionPadre);
        dato = nodoPadre.getDato(posicionPadre);
        nuevoNodo.setClave(nuevoNodo.nroDeClavesNoVacias(), clave);
        nuevoNodo.setDato(nuevoNodo.nroDeClavesNoVacias(), dato);

        for (int i = 0; i < nodoDer.nroDeClavesNoVacias(); i++) {
            int posicionActual = nuevoNodo.nroDeClavesNoVacias();
            clave = nodoDer.getClave(i);
            dato = nodoDer.getDato(i);
            hijo = nodoDer.getHijo(i);
            nuevoNodo.setClave(posicionActual, clave);
            nuevoNodo.setDato(posicionActual, dato);
            nuevoNodo.setHijo(posicionActual, hijo);
        }
        nuevoNodo.setHijo(nuevoNodo.nroDeClavesNoVacias(), nodoDer.getHijo(nodoDer.nroDeClavesNoVacias()));
        return nuevoNodo;
    }

    public void recorrerNodoHaciaIz(NodoMVias<K, T> nodoActual, int posicionInicial) {
        int posicionFinal = nodoActual.nroDeClavesNoVacias();
        for (int i = posicionInicial; i < posicionFinal; i++) {
            K clave = nodoActual.getClave(i + 1);
            T dato = nodoActual.getDato(i + 1);
            nodoActual.setClave(i, clave);
            nodoActual.setDato(i, dato);
            NodoMVias<K, T> hijo = nodoActual.getHijo(i + 1);
            nodoActual.setHijo(i, hijo);
        }
        nodoActual.setHijo(posicionFinal, NodoMVias.nodoVacio());
    }

    private void prestarse(NodoMVias<K, T> nodoActual, NodoMVias<K, T> nodoPadre) {

        int posicionHijo = this.buscarPosicionDeHijoEnNodo(nodoPadre, nodoActual);
        if (posicionHijo == 0 || (!nodoPadre.esHijoVacio(posicionHijo + 1) && nodoPadre.getHijo(posicionHijo + 1).nroDeClavesNoVacias() > nroMinimoDeDatos)) {

            NodoMVias<K, T> nodoAPrestar = nodoPadre.getHijo(posicionHijo + 1);

            K claveAPrestar = nodoAPrestar.getClave(0);
            T datoAPrestar = nodoAPrestar.getDato(0);

            if (!nodoAPrestar.esHoja()) {

                NodoMVias<K, T> hijoAPrestar = nodoAPrestar.getHijo(0);
                nodoActual.setHijo(nroMinimoDeDatos, hijoAPrestar);
            }
            nodoActual.setClave(nroMinimoDeDatos - 1, nodoPadre.getClave(posicionHijo));
            nodoActual.setDato(nroMinimoDeDatos - 1, nodoPadre.getDato(posicionHijo));
            nodoPadre.setClave(posicionHijo, claveAPrestar);
            nodoPadre.setDato(posicionHijo, datoAPrestar);

            this.recorrerNodoHaciaIz(nodoAPrestar, 0);

        } else if (posicionHijo == nodoPadre.nroDeClavesNoVacias() || !nodoPadre.esHijoVacio(posicionHijo - 1)) {

            NodoMVias<K, T> nodoAPrestar = nodoPadre.getHijo(posicionHijo - 1);
            K claveAPrestar = nodoAPrestar.getClave(nodoAPrestar.nroDeClavesNoVacias() - 1);
            T datoAPrestar = nodoAPrestar.getDato(nodoAPrestar.nroDeClavesNoVacias() - 1);
            K clavePadre = nodoPadre.getClave(posicionHijo - 1);
            T datoPadre = nodoPadre.getDato(posicionHijo - 1);

            if (!nodoAPrestar.esHoja()) {
                NodoMVias<K, T> hijoAPrestar = nodoAPrestar.getHijo(nodoAPrestar.nroDeClavesNoVacias());
                this.insertarYRecorrerArbol(nodoActual, clavePadre, datoPadre);
                nodoActual.setHijo(0, hijoAPrestar);
            }
            nodoActual.setClave(nroMinimoDeDatos - 1, clavePadre);
            nodoActual.setDato(nroMinimoDeDatos - 1, datoPadre);

            nodoPadre.setClave(posicionHijo - 1, claveAPrestar);
            nodoPadre.setDato(posicionHijo - 1, datoAPrestar);

            int posicionFinal = nodoAPrestar.nroDeClavesNoVacias();

            nodoAPrestar.setClave(posicionFinal - 1, (K) NodoMVias.Vacio());
            nodoAPrestar.setDato(posicionFinal - 1, (T) NodoMVias.Vacio());
            nodoAPrestar.setHijo(posicionFinal, NodoMVias.nodoVacio());

        }
    }

    private int buscarPosicionDeHijoEnNodo(NodoMVias<K, T> nodoActual, NodoMVias<K, T> nodoABuscar) {
        for (int i = 0; i <= nodoActual.nroDeClavesNoVacias(); i++) {
            if (!nodoActual.esHijoVacio(i) && nodoActual.getHijo(i).equals(nodoABuscar)) {
                return i;
            }
        }
        return POSICION_INVALIDA;
    }

    private NodoMVias<K, T> buscarNodoDeClave(K claveABuscar, Stack<NodoMVias<K, T>> pilaDeAncestros) {

        NodoMVias<K, T> nodoActual = this.raiz;
        while (!NodoMVias.esNodoVacio(nodoActual)) {

            if (super.buscarPosicionDeClaveEnNodo(nodoActual, claveABuscar) != POSICION_INVALIDA) {
                return nodoActual;
            }
            pilaDeAncestros.push(nodoActual);
            int posicionPorDondeBajar = super.buscarPosicionPorDondeBajar(nodoActual, claveABuscar);

            nodoActual = nodoActual.getHijo(posicionPorDondeBajar);

        }

        return NodoMVias.nodoVacio();
    }

}
