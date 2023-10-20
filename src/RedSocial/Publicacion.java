package RedSocial;

public class Publicacion {
int Idpub;
int Iduser;
String Texto;
String Fecha;
public Publicacion() {
	
}
public boolean insertarPublicacion() {
	if(da.insertarPublicacion(this)) {
		return true;
	}else {
		return false;
	}
}
public boolean EliminarPublicacion() {
	if(da.EliminarUsuario(this.getIdpub())) {
		return true;
	}else {
		return false;
	}
}
public boolean actualizarPublicacion() {
	if(da.actualizarPublicacion(this)) {
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
public void setIdpub(int idpub) {
	Idpub = idpub;
}
public int getIduser() {
	return Iduser;
}
public void setIduser(int iduser) {
	Iduser = iduser;
}
public String getTexto() {
	return Texto;
}
public void setTexto(String texto) {
	Texto = texto;
}
public String getFecha() {
	return Fecha;
}
public void setFecha(String fecha) {
	Fecha = fecha;
}




}
