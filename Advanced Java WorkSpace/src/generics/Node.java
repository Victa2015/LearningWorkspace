package generics;

public class Node <T>{
	private T data;
	public Node next, prev;
	
	public Node(T data){
		this.data = data;
		next = null;
		prev = null;
	}
	T getData(){
		return data;
	}
}
