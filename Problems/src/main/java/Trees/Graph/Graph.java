package Trees.Graph;

/*
Print all paths from a given source to a destination

Given a directed graph, a source vertex ‘s’ and a destination vertex ‘d’, print all paths from given ‘s’ to ‘d’.
Consider the following directed graph.
Let the s be 2 and d be 3.
There are 3 different paths from 2 to 3.
*/

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Graph {
    Node source;

    static class Node {
        int value;
        LinkedList<Node> targets;

        public Node(int value) {
            this.value = value;
            this.targets = new LinkedList<>();
        }
    }

    public Graph(Node source) {
        this.source = source;
    }

    public Node getSource() {
        return source;
    }
    public static void findAllPaths(Node current, Node target, LinkedHashSet<Node> visited) {

        visited.add(current);

        if (current.value == target.value) {
            StringBuilder path = new StringBuilder();
            visited.forEach((k)->{
                path.append(k.value).append(" -> ");
            });
            path.delete(path.length()-4, path.length()-1);
            System.out.println(path);
            return;
        }
        for (Node n : current.targets) {
            if (!visited.contains(n)) {
                findAllPaths(n, target, visited);
                visited.remove(n);
            }
        }
    }

    public static void main(String[] args) {
        Node source = new Node(2);
        Node m0 = new Node(0);
        Node m1 = new Node(1);
        Node target = new Node(3);

        source.targets.add(m0);
        source.targets.add(m1);

        m0.targets.add(source);
        m0.targets.add(m1);
        m0.targets.add(target);

        m1.targets.add(target);

        findAllPaths(source, target, new LinkedHashSet<>());
    }
}
