package Tabla;

public class Pokemon {
String Marca;
String Modelo;
String Color;
String Textura;
String Procesador;
public Pokemon() {
	
}



public Pokemon(String marca, String modelo, String color, String textura, String procesador) {
	super();
	Marca = marca;
	Modelo = modelo;
	Color = color;
	Textura = textura;
	Procesador = procesador;
}



public String getMarca() {
	return Marca;
}



public void setMarca(String marca) {
	Marca = marca;
}



public String getModelo() {
	return Modelo;
}



public void setModelo(String modelo) {
	Modelo = modelo;
}



public String getColor() {
	return Color;
}



public void setColor(String color) {
	Color = color;
}



public String getTextura() {
	return Textura;
}



public void setTextura(String textura) {
	Textura = textura;
}



public String getProcesador() {
	return Procesador;
}



public void setProcesador(String procesador) {
	Procesador = procesador;
}







}
