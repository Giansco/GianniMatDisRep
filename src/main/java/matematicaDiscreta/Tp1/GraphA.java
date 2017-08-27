package main.java.matematicaDiscreta.Tp1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gianni on 8/27/2017.
 */
public class GraphA implements Graph {
    private Object[] V;
    private boolean[][] A;
    private int n;
    private int alfa;
    private int capacity;

    GraphA() {
        V = new Object[10];
        A = new boolean[10][10];
        capacity=10;
        n = 0;
        alfa = 0;
    }
    GraphA(int capacidad) {
        this.capacity=capacidad;
        V = new Object[capacity];
        A = new boolean[capacity][capacity];
        n = 0;
        alfa = 0;
    }

    @Override
    public void agregarVertice(Object x) {
        if (n<capacity){
            V[n] = x;
            n++;
        }else {
            grow();
            agregarVertice(x);
        }
    }

    private void grow(){
        Object[] newArray = new Object[capacity*2];
        System.arraycopy(V,0,newArray,0,capacity);
        boolean[][] new2DArray = new boolean[capacity*2][capacity*2];
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity; j++) {
                new2DArray[i][j] = A[i][j];
            }
        }
        V=newArray;
        A=new2DArray;
        capacity=capacity*2;
    }

    @Override
    public void agregarArista(int v, int w) {
        A[v][w]=A[w][v] = true;
        alfa++;
    }

    @Override
    public void eliminarArista(int v, int w) {
        A[v][w]=A[w][v] = false;
        alfa--;
    }

    @Override
    public void eliminarVertice(int v) {
        //implement
    }

    @Override
    public boolean hayArista(int v, int w) {
        return A[v][w];
    }

    @Override
    public int orden() {
        return n;
    }

    @Override
    public int cantAristas() {
        return alfa;
    }

    @Override
    public Object verVertice(int v) {
        return V[v];
    }

    @Override
    public List<Integer> getListaAdy(int v) {
        List<Integer> lst = new ArrayList<Integer>(n);
        for (int w = 0; w < n ; w++)
            if (A[v][w])
                lst.add(w);
        return lst;
    }

    /*
    public boolean[][] getMatAdy(){
        return A;
    }

    public Object[] getV() {
        return V;
    }
    */
}
