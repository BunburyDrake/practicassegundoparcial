package ImprimirTabla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataAlumno {
	Connection cx;
	
	public DataAlumno(){
	}
	public Connection conectar() {
		try {
			cx=DriverManager.getConnection("jdbc:mysql://localhost:3306/alumno","root","");
			System.out.println("Conexion Exitosa");
		}catch(SQLException e) {
			System.out.println("conexion fallida");
			e.printStackTrace();
		}
		return cx;
	}
	public static void main(String[]args) {
		DataAlumno da=new DataAlumno();
		da.conectar();
	}
	public boolean insertarAlumno(Alumno a) {
		PreparedStatement ps;
		try {
			ps=conectar().prepareStatement("INSERT INTO alumno VALUES(null,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,a.getNumControl());
			ps.setString(2,a.getNombre());
			ps.setString(3,a.getAP());
			ps.setString(4,a.getAM());
			ps.setString(5,a.getFecha());
			ps.setString(6,a.getCurp());
			ps.setString(7,a.getDireccion());
			ps.setString(8,a.getTelefono());
			ps.setString(9,a.getCorreo());
			ps.setString(10,a.getGrupo());
			ps.setString(11,a.getCarrera());
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
public ArrayList<Alumno> selectalumno(){
	ArrayList<Alumno> listaAlumno=new ArrayList<Alumno>();
	try {
	PreparedStatement ps=conectar().prepareStatement("SELECT * FROM alumno");
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		Alumno x=new Alumno();
		x.setID(rs.getInt(1));
		x.setNumControl(rs.getString(2));
		x.setNombre(rs.getString(3));
		x.setAP(rs.getString(4));
		x.setAM(rs.getString(5));
		x.setCurp(rs.getString(6));
		x.setFecha(rs.getString(7));
		x.setDireccion(rs.getString(8));
		x.setTelefono(rs.getString(9));
		x.setCorreo(rs.getString(10));
		x.setGrupo(rs.getString(11));
		x.setCarrera(rs.getString(12));
	}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return listaAlumno;
}
}
