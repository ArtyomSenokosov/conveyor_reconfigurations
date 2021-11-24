package main.java.factory.algorithms;

import main.java.factory.component.Component;
import main.java.factory.component.Node;

import java.util.PriorityQueue;

public class Dijkstra {

    private final Node[] graph;
    private final int centralStore;

    public Dijkstra(Node[] graph, int centralStore) {
        this.graph = graph;
        this.centralStore = centralStore;
    }

    public void run() {

        PriorityQueue<Component> priorityQueue = new PriorityQueue<>();

        Component storeComponent = graph[centralStore].component;
        storeComponent.distanceFromCentral = 0;
        priorityQueue.offer(storeComponent);

        while (!priorityQueue.isEmpty()) {
            Component componentElement = priorityQueue.poll();

            for (Component incomingEdge : componentElement.incomingEdges) {
                if (componentElement.distanceFromCentral + 1 < incomingEdge.distanceFromCentral) {
                    incomingEdge.distanceFromCentral = componentElement.distanceFromCentral + 1;
                    priorityQueue.offer(incomingEdge);
                }
            }

            for (Component outgoingEdge : componentElement.outgoingEdges) {
                if (componentElement.distanceFromCentral < outgoingEdge.distanceFromCentral) {
                    outgoingEdge.distanceFromCentral = componentElement.distanceFromCentral;
                    priorityQueue.offer(outgoingEdge);
                }
            }
        }
    }
}