package formas_geometricas;

public class Retangulo implements Poligono {
	
	private Ponto p1;
	private Ponto p2;
	
	public Retangulo(int x1, int y1, int x2, int y2) {
		p1 = new Ponto(x1, y1);
		p2 = new Ponto(x2, y2);
	}
	
	@Override
	public double getArea() {
		return (p2.getX() - p1.getX()) * (p2.getY() - p1.getY());
	}
	
	@Override
	public String toString() {
		return "(" + p1 + " " + p2 + ")";
	}
	
	public static void main(String[] args) {
		Retangulo r = new Retangulo(0, 10, 10, 20);
		System.out.println(r);
		System.out.println(r.getArea());
	}

}
