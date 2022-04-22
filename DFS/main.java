package Tugas7;

public class Main {

	public static void main(String[] args) {
		dfs g = new dfs(11);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		g.addEdge(3, 4);
		g.addEdge(3, 6);
		g.addEdge(3, 7);
		g.addEdge(3, 9);
		g.addEdge(4, 6);
		g.addEdge(4, 7);
		g.addEdge(4, 8);
		g.addEdge(4, 9);
		g.addEdge(5, 7);
		g.addEdge(5, 8);
		g.addEdge(6, 7);
		g.addEdge(6, 9);
		g.addEdge(7, 8);
		g.addEdge(7, 9);
		g.addEdge(7, 10);
		
		System.out.println(
				"DFS (NIM : 455449) : ");
			g.DFS(9);

	}

}
