package tool;

public class TimeUtil {
	
	static long start;
	
	public static void startTiming() {
		System.out.println("------------------------");
		System.out.println("start Timing");
		System.out.println("------------------------");
		start = System.currentTimeMillis();
	}
	
	public static void endTiming() {
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("------------------------");
		System.out.println("end Timing, costTime: " + time + " ms");
		System.out.println("------------------------");
	}
	

}
