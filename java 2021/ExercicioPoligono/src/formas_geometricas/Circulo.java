package formas_geometricas;

public class Circulo extends Ponto implements Poligono {  //extends: herança ; implements: interface

	private int raio;
	
	public Circulo(int x, int y, int raio) {
		super(x, y);
		this.raio = raio;
	}
	
	@Override
	public double getArea() {
		return Math.PI * raio * raio;
	}
	
	@Override
		public String toString() {
			return "(" + getX() + ", " + getY() + ", " + raio + ")";	
		}
	
	public static void main(String[] args) {
		Circulo c = new Circulo (10, 20, 30);
		System.out.println(c);
		System.out.println(c.getArea());
	}

}
