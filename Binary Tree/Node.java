package latihanJava;

public class Node {
	private int value;
	public Node leftchild;
	public Node rightchild;
	
	Node(int value){
		this.value = value;
	}
	public int getValue(){
		return value;
	}
	public void enterValue(int value){
		this.value = value;
	}
}
