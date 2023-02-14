package Algorithm.Search;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author hui
 */
public class FirstSearchByHui {

    public Optional<Node<Object>> breadthFirstSearch(Node<Object> node, Object value){
        if (node.getValue().equals(value)) {
            return Optional.of(node);
        }

        List<Node<Object>> queue = new ArrayList<>(node.getSubNodes());

        while (!queue.isEmpty()) {
            final Node current = queue.get(0);

            if (current.getValue().equals(value)) {
                return Optional.of(current);
            }

            queue.addAll(current.getSubNodes());

            queue.remove(0);
        }

        return Optional.empty();
    }

    public static Optional<Node<Object>> depthFirstSearch( Node<Object> node, Object value) {
        if (node.getValue().equals(value)) {
            return Optional.of(node);
        }

        for (Node<Object> subNode : node.getSubNodes()) {
            final Optional<Node<Object>> result = depthFirstSearch(subNode, value);
            if (result.isPresent()) {
                return result;
            }
        }

        return Optional.empty();

    }



}
