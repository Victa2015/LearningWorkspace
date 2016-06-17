package generics;

public class NumberList<T> implements IList<T> {
	private T[] datastore;
	private int size;
	private int pos;
	public NumberList(int numElements){
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
