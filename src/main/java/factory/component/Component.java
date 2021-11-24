package main.java.factory.component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Component implements Comparable<Component> {

    public int lowLink;
    public List<Node> nodes = new ArrayList<>();
    public int distanceFromCentral = Integer.MAX_VALUE;
    public List<Component> outgoingEdges = new LinkedList<>();
    public List<Component> incomingEdges = new LinkedList<>();

    public Component(int lowLink) {
        this.lowLink = lowLink;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Component component = (Component) object;
        return lowLink == component.lowLink;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lowLink);
    }

    @Override
    public int compareTo(Component component) {
        return Integer.compare(this.distanceFromCentral, component.distanceFromCentral);
    }
}