package Graphs;

import java.util.ArrayList;

import Interfaces.Graph;

public class UndirectedGraph implements Graph
{
    /** The number of vertices inside the graph. */
    public int vertices;

    /** The number of edges in the graph. */
    public int edges;

    /** The graph is represented with an array that contains arrays.
     * A Bag can be used instead.
     */
    private ArrayList<Integer>[] graph;
    
    /** Creates a new isntance of the UndirectedGraph with the specified ammount of vertices.
     * 
     * @param numberOfVertices How many vertices will the graph has.
     */
    public UndirectedGraph(int numberOfVertices)
    {
        vertices = numberOfVertices;
        edges = 0;
        graph = (ArrayList<Integer>[]) new ArrayList[numberOfVertices];
        for (int i = 0; i < vertices; i++)
            graph[i] = new ArrayList<Integer>();
    }

    @Override
    public void connect(int parentVertice, int childVertice) 
    {
        if (!graph[parentVertice].contains(childVertice))
        {
            graph[parentVertice].add(childVertice);
            graph[childVertice].add(parentVertice);
            edges++;
        }
        else { System.out.println("Vertices are already connected."); }
    }

    @Override
    public Iterable<Integer> getAdjacentVertices(int vertice) 
    {
        return graph[vertice];
    }

    @Override
    public int getVertices() { return vertices; }

    @Override
    public int getEdges() { return edges; }
    
}
