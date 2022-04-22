package Tugas8;

class AdjMatrixGraph {
	private int nVertex;
	private int[][] adjMatrix;
	
	public AdjMatrixGraph(int nVertex) {
		this.nVertex = nVertex;
		this.adjMatrix = new int[nVertex][nVertex];
		}

	public void addEdge(int one, int two, int weight) {
		this.adjMatrix[one][two] = weight;
		this.adjMatrix[two][one] = weight;
		}
	
	public void displayGraph() {
		System.out.println("Adjacency Matrix : ");
			for (int i=0 ; i<this.nVertex ; i++) {
				for (int j=0 ; j<this.nVertex ; j++) {
					System.out.print(this.adjMatrix[i][j] + " ");
				}
				System.out.println();
			}	
	}

	final static int INF = 99999;

	public void floydWarshall() {
		int V = this.nVertex;
		int[][] distance = new int[V][V];
		int i, j, k;
		for (i=0; i<V; i++)
			for (j=0; j<V; j++) {
				if(adjMatrix[i][j]== 0 && i!=j)
					distance[i][j] = INF;
				else
					distance[i][j] = adjMatrix[i][j];
			}

		for (k=0 ; k<V ; k++) {
			for (i=0 ; i<V ; i++) {
				for (j=0 ; j<V ; j++) {
					if (distance[i][k] + distance[k][j] < distance[i][j])
						distance[i][j] = distance[i][k] +
						distance[k][j];
					}
				}
		}

		printResult(distance);
		
	}

	void printResult(int[][] distance) {
		int V = this.nVertex;
		System.out.println("\nClosest Range: ");
		for (int i=0 ; i<V ; i++) {
			for (int j=0 ; j<V ; j++) {
				if (distance[i][j]==INF)
					System.out.print("INF ");
				else
					System.out.print(distance[i][j]+" ");
				}
			System.out.println();
			}
		}
	}

	public class AdjMtrxGrph {
		public static void main(String[] args) {
			int nVertex = 10;
			AdjMatrixGraph graph = new AdjMatrixGraph(nVertex);

			graph.addEdge(0, 5, 3);
			graph.addEdge(0, 6, 4);
			graph.addEdge(0, 7, 4);
			graph.addEdge(0, 9, 4);
			graph.addEdge(1, 3, 3);
			graph.addEdge(1, 8, 1);
			graph.addEdge(2, 4, 1);
			graph.addEdge(2, 5, 1);
			graph.addEdge(2, 7, 2);
			graph.addEdge(3, 4, 1);
			graph.addEdge(3, 5, 2);
			graph.addEdge(3, 9, 4);
			graph.addEdge(4, 5, 2);
			graph.addEdge(4, 8, 2);
			graph.addEdge(5, 8, 1);

			graph.displayGraph();
			graph.floydWarshall();
		}
	}
