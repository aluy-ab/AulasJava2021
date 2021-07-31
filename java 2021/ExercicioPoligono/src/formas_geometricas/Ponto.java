package formas_geometricas;

public class Ponto {

	private int x;
	private int y;
	
	public Ponto() {
		this.x = 0;
		this.y = 0;
	}
	
	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Ponto(Ponto other) {
		this.x = other.x;
		this.y = other.y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void moveTo() {
		this.x = 0;
		this.y = 0;
	}
	
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void moveTo(Ponto other) {
		this.x = other.x;
		this.y = other.y;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	public static void main(String[] args) {
		Ponto p = new Ponto(10,20);
		System.out.println(p);
	}
	
}
