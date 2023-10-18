package hola;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataAlumno {
	Connection cx;

	public static void main(String[] ola) {
		DataAlumno da = new DataAlumno();
		da.conectar();
	}

	public DataAlumno() {
	}

	public Connection conectar() {
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/alumno", "root", "");
			System.out.println("CONEXION EXITOSA");
		} catch (SQLException e) {
			System.out.println("FALLO CONEXION");
			e.printStackTrace();
		}
		return cx;
	}

	public boolean insertarAlumno(Alumno a) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("INSERT INTO alumno VALUES(null,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, a.getNumControl());
			ps.setString(2, a.getNombre());
			ps.setString(3, a.getApellidoP());
			ps.setString(4, a.getApellidoM());
			ps.setString(5, a.getCurp());
			ps.setString(6, a.getDireccion());
			ps.setString(7, a.getTelefono());
			ps.setString(8, a.getCorreo());
			ps.setString(9, a.getGrupo());
			ps.setString(10, a.getCarrera());
			ps.setString(11, a.getFecha());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public ArrayList<Alumno> SelectAlumno() {
		ArrayList<Alumno> ListaAlumnos = new ArrayList<Alumno>();
		try {
			PreparedStatement ps = conectar().prepareStatement("SELECT * FROM alumno");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Alumno x = new Alumno();
				x.setid(rs.getInt(1));
				x.setNumControl(rs.getString(2));
				x.setNombre(rs.getString(3));
				x.setApellidoP(rs.getString(4));
				x.setApellidoM(rs.getString(5));
				x.setFecha(rs.getString(6));
				x.setCurp(rs.getString(7));
				x.setDireccion(rs.getString(8));
				x.setTelefono(rs.getString(9));
				x.setCorreo(rs.getString(10));
				x.setGrupo(rs.getString(11));
				x.setCarrera(rs.getString(12));
				ListaAlumnos.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return ListaAlumnos;
	}

	public boolean EliminarAlumno(int ID) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("DELETE FROM alumno WHERE id=?");
			ps.setInt(1, ID);
			System.out.println(ps.toString());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean actualizarAlumno(Alumno a) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement(
					"UPDATE alumno SET NumControl=?,Nombre=?,AP=?,AM=?,Fecha=?,Curp=?,Dirreccion=?,Telefono=?,Correo=?,Grupo=?,Carrera=? WHERE id=?");
			ps.setString(1, a.getNumControl());
			ps.setString(2, a.getNombre());
			ps.setString(3, a.getApellidoP());
			ps.setString(4, a.getApellidoM());
			ps.setString(5, a.getCurp());
			ps.setString(6, a.getDireccion());
			ps.setString(7, a.getTelefono());
			ps.setString(8, a.getCorreo());
			ps.setString(9, a.getGrupo());
			ps.setString(10, a.getCarrera());
			ps.setString(11, a.getFecha());
			ps.setInt(12, a.getID());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
}
