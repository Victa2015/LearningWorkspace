package generics;

public class StringList<T> implements IList<T>{
	private T[] datastore;
	private int size;
	private int pos;
	public StringList(int numElements){
		size = numElements;
		pos = 0;
		datastore = (T[]) new Object[size];
	}

	public void add(T element) {
		// TODO Auto-generated method stub
		datastore[pos] = element;
		++pos;
	}

	public T get(int n) {
		// TODO Auto-generated method stub
		
		return datastore[n];
	}
	
}

/*
 * Generic Classes rely on the types provided when creating objects of that class.
 * 
 */
