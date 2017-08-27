package main.java.matematicaDiscreta.Tp1;

import com.sun.deploy.util.ArrayUtil;

/**
 * Created by Gianni on 8/27/2017.
 */
public class GraphAPI {
    
    public static void showMatAdy(GraphA graph){
        //boolean[][] matAdy = graph.getMatAdy();
        for (int i = 0; i < graph.orden(); i++) {
            for (int j = 0; j < graph.orden(); j++) {
                System.out.print(boolToInt(graph.hayArista(i,j))+"|");
            }
            System.out.println();
        }
    }

    public static boolean[][] calcMatInc(GraphA graph){
        boolean[][] matInc = new boolean[graph.cantAristas()][graph.orden()];
        int counter=0;
        for (int i = 0; i < graph.orden(); i++) {
            for (int j = i; j < graph.orden(); j++) {
                if (graph.hayArista(i,j)){
                    matInc[counter][i] = true;
                    matInc[counter][j] = true;
                    counter++;
                }
            }
        }
        return matInc;
    }

    public static void showMatInc(GraphA graph){
        boolean[][] matInc = calcMatInc(graph);
        for (int i = 0; i < matInc.length; i++) {
            for (int j = 0; j < matInc[i].length; j++) {
                System.out.print(boolToInt(matInc[i][j])+"|");
            }
            System.out.println();
        }
    }

    private static int boolToInt(boolean b) {
        return b ? 1 : 0;
    }

    public static int getAmountOfTies(GraphA graph){
        //boolean[][] matAdy = graph.getMatAdy();
        int counter = 0;
        for (int i = 0; i < graph.orden(); i++) {
            if (graph.hayArista(i,i)) counter++;
        }
        return counter;
    }

    public static Object[] getTiedVertixs(GraphA graph){
        //boolean[][] matAdy = graph.getMatAdy();
        //final Object[] v = graph.getV();
        Object[] tiedVertixes = new Object[getAmountOfTies(graph)];
        int counter = 0;
        for (int i = 0; i < graph.orden(); i++) {
            if (graph.hayArista(i,i)){
                tiedVertixes[counter]=graph.verVertice(i);
                counter++;
            }
        }
        return tiedVertixes;
    }

    public static boolean isVertixIsolated(GraphA graph, int v){//implementar con object??? si tiene lazos es aislado??
        //boolean[][] matAdy = graph.getMatAdy();
        for (int i = 0; i < graph.orden(); i++) {
            if (graph.hayArista(i,v)) return false;
        }
        return true;
    }

    public static int amountOfIsolatedVetrixs(GraphA graph){
        //final Object[] v = graph.getV();
        int counter = 0;
        for (int i = 0; i < graph.orden(); i++) {
            if (isVertixIsolated(graph,i)) counter++;
        }
        return counter;
    }

    public static Object[] getIsolatedVertixs(GraphA graph){
        //final Object[] v = graph.getV();
        Object[] isolatedVertixes = new Object[amountOfIsolatedVetrixs(graph)];
        int counter = 0;
        for (int i = 0; i < graph.orden(); i++) {
            if (isVertixIsolated(graph,i)){
                isolatedVertixes[counter] = graph.verVertice(i);
                counter++;
            }
        }
        return isolatedVertixes;
    }

    public static Graph trimGraph(GraphA graph){
        GraphA newGraph = new GraphA();
        newGraph = graph;//necessary?
        trimTies(newGraph);
        trimIsolated(newGraph);
        return newGraph;
    }

    private static void trimTies(GraphA graph){
        //boolean[][] matAdy = graph.getMatAdy();
        for (int i = 0; i < graph.orden(); i++) {
            graph.eliminarArista(i,i);
        }
    }

    private static void trimIsolated(GraphA graph){
        for (int i = 0; i < graph.orden(); i++) {
            if (isVertixIsolated(graph,i)){
                graph.eliminarVertice(i);
            }
        }
    }

}
