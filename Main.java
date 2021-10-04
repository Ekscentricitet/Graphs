import Interfaces.Graph;

import Graphs.UndirectedGraph;

public class Main 
{
    public static void main(String args[])
    {
        System.out.println("Enter an Integer specifying the number of vertices that the graph will have.");
        int vertices;
        while(true)
        {
            vertices = getPositiveIntegerInputFromUser();
            if (vertices <= 1) 
                System.out.println("Don't try to bug the application, man. I am just trying to practice the data structures...");
            else { break;}
        }
        Graph graph = new UndirectedGraph(vertices);
        mainLoop(graph);
    }

    private static int getPositiveIntegerInputFromUser()
    {
        while (true)
        {
            var errorMessage = "Please enter a valid positive Integer.";
            try
            { 
                var userInput = Integer.parseInt(System.console().readLine());
                if (userInput < 0) { System.out.println(errorMessage); }
                else { return userInput; }
            }
            catch (Exception e) { System.out.println(errorMessage); }
        }
    }

    private static void mainLoop(Graph graph)
    {
        System.out.println("Now you can manipulate the graph and see the output."); 
        System.out.println("Enter 1 to add a link between two edges.");
        System.out.println("Enter 2 to print the number of edges.");
        System.out.println("Enter 3 to get all adjacent edges to a specified one.");
        System.out.println("Enter 0 to exit the loop.");
        var stop = false;
        while (!stop)
        {
            System.out.println("What would you like to do now?");
            var userInput = getPositiveIntegerInputFromUser();
            switch (userInput)
            {
                case 0:
                    stop = true;
                    System.out.println("Byeee! If you have any questions - feel free to ask me at the interview!");
                    break;
                case 1:
                    createUserRequestedEdge(graph);
                    break;
                case 2:
                    System.out.println("Number of edges in the graph: " + graph.getEdges());
                    break;
                case 3:
                    System.out.println("The adjacent vertices of which vertice do you want to see?");
                    var vertice = getPositiveIntegerInputFromUser();
                    System.out.println("Vertice " + vertice + 
                        " is connected to vertices " + graph.getAdjacentVertices(vertice));
                    break;
                default:
                    System.out.println("Please enter one of the provided options.");
                    break;
            }
        }
    }

    private static void createUserRequestedEdge(Graph graph)
    {
        while (true)
        {
            System.out.println("Give me the parent vertice.");
            var parent = getPositiveIntegerInputFromUser();
            System.out.println("Give me the child vertice.");
            var child = getPositiveIntegerInputFromUser();
            try
            {
                graph.connect(parent, child);
                System.out.println("Connected " + parent + " to " + child);
                break;
            }
            catch (Exception e)
            {
                System.out.println("Really? You are again trying to break the application?"); 
                System.out.println("Please enter valid vertices. Remember that the count starts from 0."); 
            }
        }
    }
}
