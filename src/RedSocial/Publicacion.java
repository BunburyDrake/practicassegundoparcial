package RedSocial;
public class Publicacion {
int idPub;
int Iduser;
String texto;
String fecha;
DataPublicacion dp=new DataPublicacion();
public Publicacion(){
	
}

public boolean insertarPublicacion() {
	if(dp.insertarPublciacion(this)) {
		return true;
	}else {
		return false;
	}
	
}
public boolean EliminarPublicacion() {
	if(dp.EliminarPublicacion(this.getIdPub())) {
		return true;
	}else {
		return false;
	}
}
public boolean actualizarPublicacion() {
	if(dp.actualizarPublicacion(this)) {
		return true;
	}else {
		return false;
	}
}


public int getIdPub() {
	return idPub;
}
public void setIdPub(int idPub) {
	this.idPub = idPub;
}
public int getIduser() {
	return Iduser;
}
public void setIdUser(int Iduser) {
	this.Iduser = Iduser;
}
public String getTexto() {
	return texto;
}
public void setTexto(String texto) {
	this.texto = texto;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}



}