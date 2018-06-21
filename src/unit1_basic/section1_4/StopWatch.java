package unit1_basic.section1_4;
/**
 * 计时器
 * 用于算法分析
 * @author beta
 *
 */
public class StopWatch {
	private final long start;
	
	public StopWatch() {
		start = System.currentTimeMillis();
	}
	
	public double elapsedTime() {
		long now = System.currentTimeMillis();
		return (now-start)/1000.0;
	}
	
	public static void main(String[] args) {
		StopWatch watch = new StopWatch();
		for(long i=0;i<100000000L;i++) {
			
		}
		System.out.println(watch.elapsedTime());
		
	}
}
