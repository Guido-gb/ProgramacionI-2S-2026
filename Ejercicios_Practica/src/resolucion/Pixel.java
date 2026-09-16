package resolucion;

public class Pixel {
	int rojo;
	int verde;
	int azul;
	
	public Pixel(int rgb) {
		this.rojo = (rgb & 0x00ff0000) >> 16;
	    this.verde = (rgb & 0x0000ff00) >> 8;
	    this.azul = rgb & 0x000000ff;
	}
	
	int aInt()
	{
		int rgb = 0;
		rgb += this.rojo;
		rgb = rgb << 8;
		rgb += this.verde;
		rgb = rgb << 8;
		rgb += this.azul;
		return rgb;	
	}
	
	void colorizar(int r,int g, int b) {
		this.rojo+=r;
		this.azul+=b;
		this.verde+=g;
		this.rojo = ajustar(this.rojo);
		this.azul = ajustar(this.azul);
		this.verde = ajustar(this.verde);
	}
	
	int ajustar(int n){
		if(n < 0) {
			return 0;
		}
		if( n > 255) {
			return 255;
		}
		return n;
	}
	//0,3 × r + 0,6 × v + 0,1 × a,
	void aGrises() {
		this.rojo = (this.rojo *30 + this.verde * 60 + this.azul * 10) / 100;
		this.rojo = ajustar(this.rojo);
		this.azul = this.rojo;
		this.verde = this.rojo;
	}
	
	void invertir() {
		this.rojo = ajustar(255 - this.rojo);
		this.verde = ajustar(255 - this.verde);
		this.azul = ajustar(255 - this.azul);
	}
	
	
}