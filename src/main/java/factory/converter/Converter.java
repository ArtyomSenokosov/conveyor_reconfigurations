package main.java.factory.converter;

import main.java.factory.component.Component;
import main.java.factory.component.Node;

import java.util.List;

public class Converter {

    public static void convertComponentsToGraph(List<Component> components) {
        for (Component component : components) {
            for (Node node : component.nodes) {
                for (Node outgoingEdge : node.outgoingEdges) {
                    if (node.component.lowLink != outgoingEdge.component.lowLink) {
                        component.outgoingEdges.add(outgoingEdge.component);
                        outgoingEdge.component.incomingEdges.add(node.component);
                    }
                }
            }
        }
    }
}
