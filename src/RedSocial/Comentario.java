package RedSocial;

public class comentario {
int IdCom;
int IdPub;
int IdUser;
String texto;
String fecha;
DataComentario dh=new DataComentario();
public comentario() {}

public boolean insertarComentario() {
	if(dh.insertarComentario(this)) {
		return true;
	}else {
		return false;
	}
}
public boolean EliminarComentario() {
	if(dh.EliminarComentario(this.getIdCom())) {
		return true;
	}else {
		return false;
	}
}
public boolean actualizarComentario() {
	if(dh.actualizarComentario(this)) {
		return true;
	}else {
		return false;
	}
}

public int getIdCom() {
	return IdCom;
}

public void setIdCom(int idCom) {
	IdCom = idCom;
}

public int getIdPub() {
	return IdPub;
}

public void setIdPub(int idPub) {
	IdPub = idPub;
}

public int getIdUser() {
	return IdUser;
}

public void setIdUser(int idUser) {
	IdUser = idUser;
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

public DataComentario getDh() {
	return dh;
}

public void setDh(DataComentario dh) {
	this.dh = dh;
}


}
