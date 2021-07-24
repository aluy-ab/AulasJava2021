package model;

public class Quimico extends Produto{
	
	private Boolean infl;
	
	public Quimico() {
		super();
		this.infl = false;	
	}

	public Boolean getInfl() {
		return infl;
	}

	public void setInfl(Boolean infl) {
		this.infl = infl;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Substância inflamável? " + this.getInfl();
	}

}
