package main.java.factory;

import main.java.factory.component.Component;
import main.java.factory.component.Node;
import main.java.factory.algorithms.Dijkstra;
import main.java.factory.algorithms.Tarjan;
import main.java.factory.reader.Reader;

import java.io.IOException;
import java.util.List;

import static main.java.factory.converter.Converter.convertComponentsToGraph;

public class Main {

    public static void main(String[] args) throws IOException {

        Reader reader = new Reader();

        int numPoints = reader.nextInt();
        int numConveyor = reader.nextInt();
        int centralStore = reader.nextInt();

        Node[] graph = new Node[numPoints];

        for (int i = 0; i < numPoints; i++)
            graph[i] = new Node(i);


        for (int i = 0; i < numConveyor; i++) {
            int source = reader.nextInt();
            int destination = reader.nextInt();

            graph[source].outgoingEdges.add(graph[destination]);
        }

        Tarjan tarjan = new Tarjan(graph, numPoints);
        tarjan.findSCC();

        convertComponentsToGraph(tarjan.components);

        Dijkstra dijkstra = new Dijkstra(graph, centralStore);
        dijkstra.run();

        int sum = getCount(tarjan.components);

        System.out.println("result: " + sum);
    }

    private static int getCount(List<Component> components) {
        int cost = 0;
        for (Component component : components) {
            if (component.incomingEdges.size() == 0)
                cost += component.distanceFromCentral;
        }
        return cost;
    }
}