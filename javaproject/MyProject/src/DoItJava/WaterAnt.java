package DoItJava;

public class WaterAnt extends Ant {

	

		private String where = "water";
		
		public void show() {
			System.out.println(where + "주변");
		}
		
		public void print() {
			System.out.println(getName() + "은 " + where + "에 산다.");
		}

		public static void main(String[] args) {
			
			WaterAnt wa = new WaterAnt();
			
			System.out.println(wa.getName());
			System.out.println(wa.toString());
			wa.print();
			
			System.out.println("========================");
			
			System.out.println(wa.where);
			wa.show();
			wa.print();
			
		}
}
