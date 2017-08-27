package main.java.matematicaDiscreta.Tp1;

/**
 * Created by Gianni on 8/27/2017.
 */
public class Main {
    public static void main(String[] args) {
        GraphA graph = new GraphA(5);
        graph.agregarVertice(0);
        graph.agregarVertice(1);
        graph.agregarVertice(2);
        graph.agregarVertice(3);
        graph.agregarVertice(4);
        graph.agregarArista(0,1);
        graph.agregarArista(0,4);
        graph.agregarArista(2,3);
        graph.agregarArista(4,4);

        GraphAPI.showMatAdy(graph);
        System.out.println("");
        GraphAPI.showMatInc(graph);
        System.out.println("");
        System.out.println(GraphAPI.getAmountOfTies(graph));
        System.out.println("");
        System.out.println(GraphAPI.amountOfIsolatedVetrixs(graph));

        GraphAPI.trimGraph(graph);
        System.out.println("");
        GraphAPI.showMatAdy(graph);

    }
}
