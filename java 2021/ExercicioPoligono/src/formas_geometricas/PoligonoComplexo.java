package formas_geometricas;

public class PoligonoComplexo {
	
	private Poligono[] array = new Poligono[10];
	
	private int n = 0;
	
	public PoligonoComplexo() {
		
	}
	
	public void add(Poligono p) {
		array[n++] = p;
	}
	
	public void show() {
		for (int i = 0 ; i<n ; i++) {
			System.out.println(array[i].getArea());
		}
	}
	
	public static void main(String[] args) {
		
		PoligonoComplexo pc = new PoligonoComplexo();
		
		pc.add(new Circulo(10, 20, 30));
		pc.add(new Retangulo(10, 20, 30, 40));
		pc.add(new TrianguloRetangulo(10, 20, 30, 40));
		
		pc.show();
	}

}
