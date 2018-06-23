package unit1_basic.section1_5;
/**
 * 并查集接口
 * @author beta
 *
 */
public interface UF {
	void union(int p,int q);
	int find(int p);
	boolean connected(int p,int q);
	int count();
}
