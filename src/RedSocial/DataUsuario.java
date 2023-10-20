package RedSocial;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hola.Alumno;



public class DataUsuario {
	Connection cx;

	public static void main(String[] ola) {
		DataUsuario da = new DataUsuario();
		da.conectar();
	}

	public DataUsuario() {
	}

	public Connection conectar() {
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/redsocial", "root", "");
			System.out.println("CONEXION EXITOSA");
		} catch (SQLException e) {
			System.out.println("FALLO CONEXION");
			e.printStackTrace();
		}
		return cx;
	}

	public boolean insertarUsuario(Usuario a) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("INSERT INTO usuario VALUES(null,?,?,?,?)");
			ps.setString(1, a.getCorreo());
			ps.setString(2, a.getTelefono());
			ps.setString(3, a.getPasword());
			ps.setString(4, a.getNombre());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	public ArrayList<Usuario> SelectUsuario() {
		ArrayList<Usuario> ListaUsuario = new ArrayList<Usuario>();
		try {
			PreparedStatement ps = conectar().prepareStatement("SELECT * FROM usuario");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Usuario x = new Usuario();
				x.setIduser(rs.getInt(1));
				x.setCorreo(rs.getString(2));
				x.setTelefono(rs.getString(3));
				x.setPasword(rs.getString(4));
				x.setNombre(rs.getString(5));
				ListaUsuario.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return ListaUsuario;
	}
	public boolean EliminarUsuario(int IDUSER) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("DELETE FROM usuario WHERE iduser=?");
			ps.setInt(1, IDUSER);
			System.out.println(ps.toString());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	public boolean actualizarUsuario(Usuario a) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement(
					"UPDATE usuario SET Correo=?,Telefono=?,Pasword=?,Nombre=? WHERE iduser=?");
			ps.setString(1, a.getCorreo());
			ps.setString(2, a.getTelefono());
			ps.setString(3, a.getPasword());
			ps.setString(4, a.getNombre());
			ps.setInt(5, a.getIduser());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}



}

