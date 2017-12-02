package ch11_SoundAPI;

class MyEx extends Exception {}

public class ExTestDrive {
	public static void main(String[] args) {
		String test = args[0];
		try {
			doRisky(test);
			System.out.print("r");
			System.out.print("o");
		} catch (MyEx e) {
			System.out.print("a");
		} finally {
			System.out.print("w");
			System.out.print("s");
		}
		
	}
	
	static void doRisky(String t) throws MyEx {
		System.out.print("t");
		System.out.print("h");
		if ("yes".equals(t)) {
			throw new MyEx();
		}
	}	
}