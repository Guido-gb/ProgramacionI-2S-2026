package resolucion;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagen {
	Pixel[][] pixels;
	int alto;
	int ancho;
	
	Imagen(String archivo)
	{
		File file= new File(archivo);
		try {
			BufferedImage image = ImageIO.read(file);
			ancho = image.getWidth();
			alto = image.getHeight();
			pixels = new Pixel[alto][ancho];
			for(int i=0; i<alto; i++)
			{
				for(int j=0; j<ancho; j++)
				{
					pixels[i][j]=new Pixel(image.getRGB(j, i));
				}
			}
		} catch (IOException e) {
			System.err.println("No se encontro el archivo " + archivo);
			System.exit(0);
		}
	}


	/**
	 * Guarda la imagen en un archivo seg�n el formato indicado
	 * @param archivo El nombre de archivo, e.g., "lena.bmp"
	 * @param formato El formato de imagen: "bmp", "png", "jpg", etc. 
	 */
	void guardar(String archivo, String formato)
	{
		BufferedImage image = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
		for(int i=0; i<alto; i++)
		{
			for(int j=0; j<ancho; j++)
				image.setRGB(j,i, pixels[i][j].aInt());
		}
		
		try {
			ImageIO.write(image, formato, new File(archivo));
		} catch (IOException e) {
			System.err.println("Error al guardar en el archivo " + archivo);
			e.printStackTrace();
		}
	}
	
	void colorizar(int r,int g, int b) {
		for(int i=0; i<alto; i++)
		{
			for(int j=0; j<ancho; j++)
			{
				pixels[i][j].colorizar(r, g, b);
			}
		}
	}
	void aGrises() {
		for(int i=0; i<alto; i++)
		{
			for(int j=0; j<ancho; j++)
			{
				pixels[i][j].aGrises();
			}
		}
	}
	
	void invertir() {
		for(int i=0; i<alto; i++)
		{
			for(int j=0; j<ancho; j++)
			{
				pixels[i][j].invertir();
			}
		}
	}
	
	void espejar() {
		Pixel[][] pixels2 = new Pixel[this.alto][this.ancho];
		for(int i=0; i<alto; i++)
		{
			for(int j=0; j<ancho; j++)
			{
				pixels2[i][j]=pixels[i][this.ancho-j-1];
			}
		}
		pixels = pixels2;
	}
	
	void borrar() {
		for(int i=0; i<alto; i++)
		{
			for(int j=0; j<ancho; j++)
			{
				if(j > 169 && j < 186 && i > 147 && i < 165) {
					pixels[i][j]=pixels[i][169];
				}
				if(distancia(280, 40, i, j) < 8) {
					pixels[i][j]= new Pixel(985957441);
				}
			}
		}
	}
	
	public static double distancia(int i1,int j1, int i2, int j2) {
		return Math.sqrt((i1 - i2) * (i1 - i2) + (j1 - j2) * (j1 - j2));
	}

	
}
