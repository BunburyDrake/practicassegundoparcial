package RedSocial;

public class Publicacion {
int Idpub;
int Iduser;
String Texto;
String Fecha;
DataPublicacion dp=new DataPublicacion();
public Publicacion() {
}
public boolean insertarPublicacion() {
	if(dp.insertarPublicacion(this)) {
		return true;
	}else {
		return false;
	}
}


public Publicacion(int Idpub, int Iduser, String Texto, String Fecha) {
	
	this.Idpub = Idpub;
	this.Iduser = Iduser;
	this.Texto = Texto;
	this.Fecha = Fecha;
}
public int getIdpub() {
	return Idpub;
}
public void setIdpub(int Idpub) {
	Idpub = Idpub;
}
public int getIduser() {
	return Iduser;
}
public void setIduser(int Iduser) {
	Iduser = Iduser;
}
public String getTexto() {
	return Texto;
}
public void setTexto(String Texto) {
	Texto = Texto;
}
public String getFecha() {
	return Fecha;
}
public void setFecha(String Fecha) {
	Fecha = Fecha;
}




}
