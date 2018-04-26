package algorithms.examples.graph;

public interface Paths {

	boolean hasPathTo(int v);

	Iterable<Integer> pathTo(int v);
}
