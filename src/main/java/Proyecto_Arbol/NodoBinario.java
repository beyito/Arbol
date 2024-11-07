/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Arbol;

/**
 *
 * @author cobu-
 */
public class NodoBinario<K,T> {
    private K clave;
    private T dato;
    private NodoBinario<K,T> hijoIzquierdo;
    private NodoBinario<K,T> hijoDerecho;

    public NodoBinario(K clave, T dato) {
        this.clave = clave;
        this.dato = dato;
    }

    public NodoBinario(K clave, T dato, NodoBinario<K, T> hijoIzquierdo, NodoBinario<K, T> hijoDerecho) {
        this.clave = clave;
        this.dato = dato;
        this.hijoIzquierdo = hijoIzquierdo;
        this.hijoDerecho = hijoDerecho;
    }

    

    public NodoBinario() {
    }

    public static NodoBinario nodoVacio(){
        return null;
    }
    
    public  static Object claveVacia(){
        return null;
    }
    public static Object datoVacio(){
        return null;
    }
 public static boolean esNodoVacio(NodoBinario nodo){
     return nodo==null;
 }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setClave(K clave) {
        this.clave = clave;
    }

    public void setHijoIzquierdo(NodoBinario<K, T> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setHijoDerecho(NodoBinario<K, T> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public T getDato() {
        return dato;
    }

    public K getClave() {
        return clave;
    }

    public NodoBinario<K, T> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public NodoBinario<K, T> getHijoDerecho() {
        return hijoDerecho;
    }
 
 public boolean esVacioHijoIzquierdo(){
     return this.esNodoVacio(hijoIzquierdo);
 }
 public boolean esVacioHijoDerecho(){
     return this.esNodoVacio(hijoDerecho);
 }
 public boolean esHoja(){
     return (esVacioHijoIzquierdo() && esVacioHijoDerecho());
 }
 public boolean esNodoCompleto(){
     return !esVacioHijoIzquierdo() && !esVacioHijoDerecho();
 } 
 
}
