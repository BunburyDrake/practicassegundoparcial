package RedSocial;

public class Usuario {
int iduser;
String correo;
String telefono;
String pasword;
String nombre;
DataUsuario da=new DataUsuario();
private int Iduser;



public Usuario() {
}
public boolean insertarUsuario() {
	if(da.insertarUsuario(this)) {
		return true;
	}else {
		return false;
	}
}
public boolean EliminarUsuario() {
	if(da.EliminarUsuario(this.getIduser())) {
		return true;
	}else {
		return false;
	}
}
public boolean actualizarUsuario() {
	if(da.actualizarUsuario(this)) {
		return true;
	}else {
		return false;
	}
}
public Usuario(int Iduser, String correo, String telefono, String pasword, String nombre) {
	
	this.Iduser = Iduser;
	this.correo = correo;
	this.telefono = telefono;
	this.pasword = pasword;
	this.nombre = nombre;
}
public int getIduser() {
	return Iduser;
}
public void setIduser(int Iduser) {
	this.Iduser = Iduser;
}
public String getCorreo() {
	return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getPasword() {
	return pasword;
}
public void setPasword(String pasword) {
	this.pasword = pasword;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}


}