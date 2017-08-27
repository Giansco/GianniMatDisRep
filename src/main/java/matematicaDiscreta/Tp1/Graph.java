package main.java.matematicaDiscreta.Tp1;

import java.util.List;

/**
 * Created by Gianni on 8/27/2017.
 */
public interface Graph {
    void agregarVertice(Object x);
    void agregarArista(int v, int w);
    void eliminarArista(int v, int w);
    void eliminarVertice(int v);
    boolean hayArista(int v, int w);
    int orden();
    int cantAristas();
    Object verVertice(int v);
    List<Integer> getListaAdy(int v);
}
