package formas_geometricas;

public class TrianguloRetangulo implements Poligono {

	private Ponto p1;
	private Ponto p2;
	
	public TrianguloRetangulo(int x1, int y1, int x2, int y2) {
		p1 = new Ponto(x1, y1);
		p2 = new Ponto(x2, y2);
	}
	
	@Override
	public double getArea() {
		return (p2.getX() - p1.getX()) * (p2.getY() - p1.getY())/2;
	}
	
	@Override
	public String toString() {
		return "(" + p1 + " " + p2 + ")";
	}
	
	public static void main(String[] args) {
		TrianguloRetangulo t = new TrianguloRetangulo(0, 10, 10, 20);
		System.out.println(t);
		System.out.println(t.getArea());
	}

}
