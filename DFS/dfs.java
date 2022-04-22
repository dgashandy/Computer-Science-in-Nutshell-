package Tugas7;

import java.util.Iterator;
import java.util.LinkedList;

public class dfs {
	private int vertices;
	private LinkedList adj[];
	private boolean visited[];

public dfs(int j) {
	vertices = j;
	adj = new LinkedList[j+1];
	visited = new boolean[j+1];
	
	for (int i = 0; i < j; ++i)
		adj[i] = new LinkedList();
	}
	public void addEdge(int j, int w){
		adj[j].add(w);
		adj[w].add(j);
	}
	public void DFSUtil(int j, boolean[] visited) {
		this.visited[j] = true;
		System.out.print(j + " ");
		Iterator<Integer> i = adj[j].listIterator();
		while (i.hasNext()){
			int n = i.next();
			if (!this.visited[n])
				DFSUtil(n, this.visited);
			}
	}
	public void DFS(int j){
		boolean visited[] = new boolean[vertices];
		DFSUtil(j, visited);
	}
}
