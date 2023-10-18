package hola;

public class Alumno {
	int ID;
	String numControl;
	String nombre;
	String apellidoP;
	String apellidoM;
	String curp;
	String fecha;
	String direccion;
	String Telefono;
	String correo;
	String grupo;
	String carrera;
	DataAlumno da=new DataAlumno();
	public boolean insertarAlumno() {
		if(da.insertarAlumno(this)) {
			return true;
		}else {
			return false;
		}
	}
	public boolean EliminarAlumno() {
		if(da.EliminarAlumno(this.getID())) {
			return true;
		}else {
			return false;
		}
	}
	public boolean actualizarAlumno() {
		if(da.actualizarAlumno(this)) {
			return true;
		}else {
			return false;
		}
	}
	
	public Alumno() {
	}
	public Alumno(int ID, String numControl, String nombre, String apellidoP, String apellidoM, String curp,
			String fecha, String direccion, String Telefono, String correo, String grupo, String carrera) {
		
		this.ID = ID;
		this.numControl = numControl;
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.fecha = fecha;
		this.curp = curp;
		this.direccion = direccion;
		this.Telefono = Telefono;
		this.correo = correo;
		this.grupo = grupo;
		this.carrera = carrera;
	}
	public int getID() {
		return ID;
	}
	public void setid(int ID) {
		this.ID = ID;
	}
	public String getNumControl() {
		return numControl;
	}
	public void setNumControl(String numControl) {
		this.numControl = numControl;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	public String getApellidoM() {
		return apellidoM;
	}
	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String Telefono) {
		this.Telefono = Telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	

}