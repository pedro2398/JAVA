package model;

public class convert {

	private float ask ;


	public float getAsk() {
		return ask;
	}


	public void setAsk(float ask) {
		this.ask = ask;
	}


	public Float converter(Float value) {
		return value * ask ;
	}
	
}
