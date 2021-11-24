package main.java.factory.algorithms;

import main.java.factory.component.Component;
import main.java.factory.component.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Tarjan {

    private final Node[] graph;
    private final int pointer;
    private final Deque<Integer> stack = new ArrayDeque<>();
    private int nextId = 0;
    private final int notVisited = -1;

    public int sccCount = 0;
    public List<Component> components = new ArrayList<>();

    public Tarjan(Node[] graph, int pointer) {
        this.graph = graph;
        this.pointer = pointer;
    }

    public void findSCC() {
        for (int i = 0; i < pointer; i++) {
            if (graph[i].index == notVisited)
                dfs(graph[i]);
        }
    }

    public void dfs(Node node) {
        stack.addFirst(node.flag);
        node.onStack = true;
        node.index = node.lowLink = nextId++;

        for (Node n : node.outgoingEdges) {
            if (n.index == notVisited)
                dfs(n);
            if (n.onStack) {
                node.lowLink = Math.min(node.lowLink, n.lowLink);
            }
        }

        if (node.index == node.lowLink) {
            Component component = new Component(node.lowLink);
            for (Integer actualNode = stack.removeFirst(); ; actualNode = stack.removeFirst()) {
                graph[actualNode].lowLink = node.index;
                graph[actualNode].onStack = false;
                component.nodes.add(graph[actualNode]);
                graph[actualNode].component = component;
                if (actualNode == node.flag) {
                    components.add(component);
                    break;
                }
            }
            sccCount++;
        }
    }
}