package Utilities;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreePrinter<T> {

    public void printTree(TNode<T> root) {
        if (root == null) {
            return;
        }

        Queue<TNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            StringBuilder levelNodes = new StringBuilder();
            StringBuilder levelEdges = new StringBuilder();

            while (levelSize > 0) {
                TNode<T> currentNode = queue.poll();

                if (currentNode != null) {
                    levelNodes.append(currentNode.data + " ");
                    queue.add(currentNode.left);
                    queue.add(currentNode.right);

                    if (currentNode.left != null) {
                        levelEdges.append(" /");
                    } else {
                        levelEdges.append("  ");
                    }

                    if (currentNode.right != null) {
                        levelEdges.append("\\ ");
                    } else {
                        levelEdges.append("  ");
                    }
                } else {
                    levelNodes.append("  ");
                    // Adding placeholders for children of a null node
                    queue.add(null);
                    queue.add(null);
                    levelEdges.append("   ");
                }
                levelSize--;
            }

            // Trim the trailing spaces for neat output
            String nodesOutput = levelNodes.toString().trim();
            String edgesOutput = levelEdges.toString().trim();

            // Print nodes and edges if they are not empty
            if (!nodesOutput.isEmpty()) {
                System.out.println(nodesOutput);
            }
            if (!edgesOutput.isEmpty()) {
                System.out.println(edgesOutput);
            }

            // Remove trailing nulls to prevent infinite loop
            while (!queue.isEmpty() && queue.peek() == null) {
                queue.poll();
            }
        }
    }
}

