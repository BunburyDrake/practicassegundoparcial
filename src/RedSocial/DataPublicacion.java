package RedSocial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataPublicacion {
	Connection cx;

	public static void main(String[] ola) {
		DataPublicacion da = new DataPublicacion();
		da.conectar();
	}

	public DataPublicacion() {
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

	public boolean insertarPublicacion(Publicacion a) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("INSERT INTO publicacion VALUES(null,?,?)");
			ps.setString(1, a.getTexto());
			ps.setString(2, a.getFecha());
			
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	public ArrayList<Publicacion> SelectPublicacion() {
		ArrayList<Publicacion> ListaPublicacion = new ArrayList<Publicacion>();
		try {
			PreparedStatement ps = conectar().prepareStatement("SELECT * FROM publicacion");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Publicacion x = new Publicacion();
				x.setIdpub(rs.getInt(1));
				x.setIduser(rs.getInt(2));
				x.setTexto(rs.getString(3));
				x.setFecha(rs.getString(4));
				ListaPublicacion.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return ListaPublicacion;
	}
	public boolean EliminarPublicacion(int IDPUB) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("DELETE FROM publicacion WHERE idpub=?");
			ps.setInt(1, IDPUB);
			System.out.println(ps.toString());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	public boolean actualizarPublicacion(Publicacion a) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement(
					"UPDATE usuario SET Texto=?,Fecha=?,Iduser=? WHERE idpub=?");
			ps.setString(1, a.getTexto());
			ps.setString(2, a.getFecha());
			ps.setInt(4, a.getIduser());
			ps.setInt(5, a.getIdpub());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}



}

