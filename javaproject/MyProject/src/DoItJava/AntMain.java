package DoItJava;

public class AntMain {

	public static void main(String[] args) {

		Ant ant = new Ant();
		ant.print();
		System.out.println(ant.toString());
		
		WaterAnt wa = new WaterAnt();
		wa.print();
		wa.show();
		System.out.println(wa.toString());
		
		WoodAnt da = new WoodAnt();
		da.print();
		da.hate();
		System.out.println(da.toString());

	}

}
