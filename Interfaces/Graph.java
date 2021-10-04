package Interfaces;

/** Defines the Graph data structure. */
public interface Graph
{
    /** Returns the number of vertices. */
    public int getVertices();

    /** Returns the number of edges. */
    public int getEdges();
    /** Creates a connection between two different vertices.
     * 
     * @param parentVertice The vertice from which the edge starts.
     * @param childVertice The vertice where the edge ends.
     */
    public void connect(int parentVertice, int childVertice);

    /** Gets the vertices to which the passed vertice has a valid direct connection.
     * 
     * @param vertice The vertice which is being checked.
     * @return An Iterable with the adjacent vertices.
     */
    public Iterable<Integer> getAdjacentVertices(int vertice);
}