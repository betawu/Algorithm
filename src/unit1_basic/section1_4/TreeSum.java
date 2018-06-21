package unit1_basic.section1_4;
/**
 * 
 * @author beta
 *统计数组里3个数和为0的所有组合的个数
 */
public class TreeSum {
	public static int count(int[] arr) {
		int count =0;
		int n = arr.length;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					if((arr[i]+arr[j]+arr[k])==0) {
						System.out.println(arr[i]+"+"+arr[j]+"+"+arr[k]);
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = {-1, 0, 1, 2, -1, -4};
		System.out.println(TreeSum.count(arr));
	}
}
