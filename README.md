# Сonveyor reconfigurations

This is a graph problem. Finding the optimal path. The graph is one of the most flexible and versatile structures. As a rule, a graph is represented using a diagram in which some vertices are connected by edges. The problem is solved using two algorithms: Dijkstra and Tarjan.

Dijkstra's algorithm works by first adding the starting node to a priority queue. It then takes the top node in the priority queue and looks at all of the nodes surrounding it. If the nodes are valid positions then they are added to the priority queue and the top node in the queue is deleted. These nodes that are added to the queue also have a knowledge of what node they were explored from (ie. their parent node) This process is continued until a node is discovered with the same location as the finish node. From that node, a path is created by retracing the steps to the starting node.

Tarjan's implementation of Dijkstra's algorithmThe algorithm takes a directed graph as input, and produces a partition of the graph's vertices into the graph's strongly connected components. Each vertex of the graph appears in exactly one of the strongly connected components. Any vertex that is not on a directed cycle forms a strongly connected component all by itself: for example, a vertex whose in-degree or out-degree is 0, or any vertex of an acyclic graph.

algorithm tarjan is input: graph G = (V, E) 
output: set of strongly connected components (sets of vertices)
