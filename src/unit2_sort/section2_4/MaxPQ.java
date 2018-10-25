package unit2_sort.section2_4;

/**
 * 优先队列
 * @author beta
 *
 */
public interface MaxPQ <Key /*extends Comparable<Key>*/>{

	public void insert(Key v);
	
	public Key max();
	
	public Key delMax();
	
	public int size();
	
	public boolean isEmpty();
}
