package DoItJava;

public class StringEquaMain {

	public static void main(String[] args) {

		String st1 = "Hello";
		String st2 = "Hello";
		String st3 = "Hello Java";
		
		String sr1 = new String("Hello");
		String sr2 = new String("Hello");
		String sr3 = new String("Hello Java");
		String sr4 = sr1;
		
		System.out.println("1 st1==st2 : " + (st1==st2));
		System.out.println("2 st1.equals(st2) : " + (st1.equals(st2)));
		System.out.println("3 sr1==sr2 : " + (sr1==sr2));
		System.out.println("4 sr1.equals(sr2) : " + (sr1.equals(sr2)));
		
	}
}
