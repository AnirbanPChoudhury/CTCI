package Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GNode<T> {
    T data;
    boolean isVisited;
    List<GNode<T>> adjNodes = new ArrayList<>();

    public GNode() {

    }

    public GNode(T data, GNode<T> adjNode) {
        this.data = data;
        adjNodes.add(adjNode);
    }

    public GNode(T data) {
        this.data = data;
    }

    @SafeVarargs
    public final void addAdjNodes(GNode<T>... nodes) {
        adjNodes.addAll(Arrays.asList(nodes));
    }
}
