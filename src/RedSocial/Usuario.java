package RedSocial;

import hola.DataAlumno;

public class Usuario {
int iduser;
String correo;
String telefono;
String pasword;
String nombre;
DataUsuario da=new DataUsuario();


public boolean insertarUsuario() {
	if(da.insertarUsuario(this)) {
		return true;
	}else {
		return false;
	}
}


public Usuario() {
}
public Usuario(int iduser, String correo, String telefono, String pasword, String nombre) {
	
	this.iduser = iduser;
	this.correo = correo;
	this.telefono = telefono;
	this.pasword = pasword;
	this.nombre = nombre;
}
public int getIduser() {
	return iduser;
}
public void setIduser(int iduser) {
	this.iduser = iduser;
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
