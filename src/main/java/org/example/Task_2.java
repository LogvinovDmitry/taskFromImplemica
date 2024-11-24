package org.example;

import java.util.*;

public class Task_2 {
    static class Edge {
        int destination, cost;

        Edge(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        while (testCases-- > 0) {
            int n = Integer.parseInt(scanner.nextLine()); // Number of cities
            Map<String, Integer> cityIndexMap = new HashMap<>();
            List<List<Edge>> graph = new ArrayList<>();

            // Read cities and their neighbors
            for (int i = 0; i < n; i++) {
                String cityName = scanner.nextLine();
                cityIndexMap.put(cityName, i);
                int neighbors = Integer.parseInt(scanner.nextLine());
                List<Edge> edges = new ArrayList<>();
                for (int j = 0; j < neighbors; j++) {
                    String[] neighborData = scanner.nextLine().split(" ");
                    int neighborIndex = Integer.parseInt(neighborData[0]) - 1;
                    int cost = Integer.parseInt(neighborData[1]);
                    edges.add(new Edge(neighborIndex, cost));
                }
                graph.add(edges);
            }

            // Number of paths to find
            int queries = Integer.parseInt(scanner.nextLine());
            StringBuilder result = new StringBuilder();

            // Process each query
            for (int q = 0; q < queries; q++) {
                String[] pathQuery = scanner.nextLine().split(" ");
                String sourceCity = pathQuery[0];
                String destinationCity = pathQuery[1];
                int source = cityIndexMap.get(sourceCity);
                int destination = cityIndexMap.get(destinationCity);

                // Find the shortest path using Dijkstra's algorithm
                int cost = dijkstra(graph, source, destination, n);
                result.append(cost).append("\n");
            }

            // Print the result for the current test case
            System.out.print(result);
            if (testCases > 0) scanner.nextLine(); // Read the empty line
        }
    }

    // Dijkstra's algorithm to find the shortest path
    private static int dijkstra(List<List<Edge>> graph, int source, int destination, int n) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        pq.add(new Edge(source, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.destination;

            // If we reached the destination, return the distance
            if (currentNode == destination) {
                return distances[destination];
            }

            // Explore neighbors
            for (Edge neighbor : graph.get(currentNode)) {
                int newDist = distances[currentNode] + neighbor.cost;
                if (newDist < distances[neighbor.destination]) {
                    distances[neighbor.destination] = newDist;
                    pq.add(new Edge(neighbor.destination, newDist));
                }
            }
        }

        return -1; // If there's no path
    }
}
