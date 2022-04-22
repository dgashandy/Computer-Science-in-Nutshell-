package TugasShortestPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class AdjMatrixGraph {
    private final int numVertex;
    private final int[][] adjMatrix;
    private final Map<Integer, String> indexKota = new HashMap<>();

    //konstruktor dan membuktikan matrix start pada null
    public AdjMatrixGraph(int numVertex) {
        this.numVertex = numVertex;
        this.adjMatrix = new int[numVertex + 1][numVertex + 1];
    }

    public void addEdge(int one, int two, int weight) {
        this.adjMatrix[one][two] = weight;
        this.adjMatrix[two][one] = weight;
    }

//    public void displayGraph() {
//        for (int i = 0; i <= this.numVertex; i++) {
//            for (int j = 0; j <= this.numVertex; j++) {
//                System.out.print(this.adjMatrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

    public void setIndexKota(String kota, int index) {
        this.indexKota.put(index, kota);
    }

    int getMinVertex(boolean [] shortestPath, int [] distance) {
        int minKey = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < this.numVertex; i++) {
            if (!shortestPath[i] && minKey > distance[i]) {
                minKey = distance[i];
                index = i;
            }
        }
        return index;
    }

    public void dijkstra(int sVertex) {
        boolean[] isShortest = new boolean[this.numVertex];
        int [] distance = new int[this.numVertex];
        int [] predecessor = new int[this.numVertex];
        int INF = Integer.MAX_VALUE;

        //jarak untuk semua vertices dibuat infinite dan predecessornya dibuat startVertex
        for (int i = 0; i < this.numVertex; i++) {
            distance[i] = INF;
            predecessor[i] = sVertex;
        }
        distance[sVertex] = 0; //dimulai dari startVertex = Jakarta

        //main shortestpath loop
        for (int i = 0; i < this.numVertex; i++) {
            int minVertex = getMinVertex(isShortest, distance); //index vertex dengan jarak terpendek/terkecil
            isShortest[minVertex] = true; //tanda bahwa sudah jarak terpendek
            //loop untuk mengecek ada tetangga yang lebih pendek/kecil
            for (int neighbor = 0; neighbor < this.numVertex; neighbor++) {
                //cek apakah jarak lebih dari null
                if (adjMatrix[minVertex][neighbor] > 0) {
                    //cek apakah tetangga sudah dalam jarak terpendek dan INF
                    if (!isShortest[neighbor] && adjMatrix[minVertex][neighbor] != INF) {
                        int newKey = adjMatrix[minVertex][neighbor] + distance[minVertex];
                        //cek apakah jika lewat tetangga jarak terpendek,
                        // jika benar maka jarak berubah dan ditandai dengan predecessor
                        if (newKey < distance[neighbor]) {
                            distance[neighbor] = newKey;
                            predecessor[neighbor] = minVertex;
                        }
                    }
                }
            }
        }
        printDijkstra(sVertex, distance, predecessor); //print output
    }

    public void printDijkstra(int sVertex, int [] key, int [] predecessor) {
        System.out.println("Rute Terpendek dari Jakarta menuju beberapa kota di Jawa Barat & Banten");
        for (int i = 0; i < this.numVertex; i++) {
            if (predecessor[i] != sVertex) {
                System.out.println("Lintasan terpendek ke " + indexKota.get(i) + " adalah " + key[i] + " km, lewat kota " + indexKota.get(predecessor[i]));
            } else {
                if (key[i] == 0) {
                    System.out.print("");
                } else {
                    System.out.println("Lintasan terpendek ke " + indexKota.get(i) + " adalah " + key[i] + " km, lewat kota " + indexKota.get(sVertex));
                }
            }
        }
    }

}

public class Main {

    public static void main(String[] args) {
        int numVertex = 21;

        AdjMatrixGraph g = new AdjMatrixGraph(numVertex);
        int[][] temp = new int[21][21];

        try {
            File file = new File("JarakAntarKota");
            Scanner scanner = new Scanner(file);
            for (int i = 0; i < 21; i++)  {
                String namaKota = scanner.next();
                g.setIndexKota(namaKota, i);
                for (int j = 0; j < 21; j++) {
                    temp[i][j]  = scanner.nextInt();
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan!");
        }
        for (int i = 0; i < 21; i++) {
            for (int j = i+1; j < 21; j++) {
                g.addEdge(i, j, temp[i][j]);
            }
        }
        g.dijkstra(0);
    }

}