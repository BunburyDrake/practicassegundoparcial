package ImprimirTabla;

public class Alumno {
	int ID;
	String NumControl;
	String Nombre;
	String AP;
	String AM;
	String Fecha;
	String Curp;
	String Direccion;
	String Telefono;
	String Correo;
	String Grupo;
	String Carrera;
	DataAlumno da=new DataAlumno();
	public boolean insertarAlumno() {
		if(da.insertarAlumno(this)) {
			return true;
		}else {
			return false;
		}
	}
	
	public Alumno(int iD, String numControl, String nombre, String aP, String aM, String fecha, String curp,
			String direccion, String telefono, String correo, String grupo, String carrera) {

		this.ID = iD;
		this.NumControl = numControl;
		this.Nombre = nombre;
		this.AP = aP;
		this.AM = aM;
		this.Fecha = fecha;
		this.Curp = curp;
		this.Direccion = direccion;
		this.Telefono = telefono;
		this.Correo = correo;
		this.Grupo = grupo;
		this.Carrera = carrera;
	}
public Alumno() {
		
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNumControl() {
		return NumControl;
	}
	public void setNumControl(String numControl) {
		NumControl = numControl;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getAP() {
		return AP;
	}
	public void setAP(String aP) {
		AP = aP;
	}
	public String getAM() {
		return AM;
	}
	public void setAM(String aM) {
		AM = aM;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public String getCurp() {
		return Curp;
	}
	public void setCurp(String curp) {
		Curp = curp;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public String getGrupo() {
		return Grupo;
	}
	public void setGrupo(String grupo) {
		Grupo = grupo;
	}
	public String getCarrera() {
		return Carrera;
	}
	public void setCarrera(String carrera) {
		Carrera = carrera;
	}
	
	
	
}
