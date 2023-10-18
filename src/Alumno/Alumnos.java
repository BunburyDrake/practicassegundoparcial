package Alumno;

public class Alumnos {
	String NumControl;
	String Nom;
	String Ap;
	String Am;
	String Grupo;
	String Carrera;
	String Turno;
	public String getNumControl(){
	  return NumControl;
	}
	public void setNumControl(String NumControl){
	  this.NumControl=NumControl;
	}
	public String getNom(){
	  return Nom;
	}
	public void setNom(String Nom){
	  this.Nom=Nom; 
	}
	public String getAp(){
	  return Ap;
	}
	public void setAp(String Ap){
	  this.Ap=Ap;
	}
	public String getAm(){
	  return Am;
	}
	public void setAm(String Am){
	  this.Am=Am;
	}
	public String getGrupo(){
	  return Grupo;
	}
	public void setGrupo(String Grupo){
	  this.Grupo=Grupo;
	}
	public String getCarrera(){
	  return Carrera;
	}
	public void setCarrera(String Carrera){
	 this.Carrera=Carrera;
	}
	public String getTurno(){
	  return Turno;
	}
	public void setTurno(String Turno){
	  this.Turno=Turno;
	}
	public void tuString(){
	  System.out.println("Numero de Control: "+NumControl);
	  System.out.println("Nombre: "+Nom);
	  System.out.println("Apellido Paterno: "+Ap);
	  System.out.println("Apellido Materno: "+Am);
	  System.out.println("Grupo: "+Grupo);
	  System.out.println("Carrera: "+Carrera);
	  System.out.println("Turno: "+Turno);
	}
	}

