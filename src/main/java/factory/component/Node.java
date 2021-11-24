package main.java.factory.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {

    public int flag;
    public int index;
    public int lowLink;
    public boolean onStack;
    public Node previousNode;
    public Component component;
    public List<Node> outgoingEdges = new ArrayList<>();

    public Node(int flag) {
        this.flag = flag;
        this.index = -1;
        this.lowLink = 0;
        this.onStack = false;
        this.previousNode = null;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Node node = (Node) object;
        return flag == node.flag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flag);
    }
}