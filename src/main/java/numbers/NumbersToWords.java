package numbers;

public class NumbersToWords {

	public static void main(String[] args) {
		
//		new NumberParser(Long.MAX_VALUE).parse();
		long start = System.currentTimeMillis();
//		new NumberToTextConverter(0).parse();
//		new NumberToTextConverter(1).parse();
//		new NumberToTextConverter(10).parse();
//		new NumberToTextConverter(100).parse();
//		new NumberToTextConverter(1000).parse();
//		new NumberToTextConverter(10000).parse();
//		new NumberToTextConverter(100000).parse();
//		new NumberToTextConverter(1000000).parse();
		
		System.out.println(new N2T(1201301004));

		System.out.println("Total time in ms: "+(System.currentTimeMillis()-start));
		
	}

}
