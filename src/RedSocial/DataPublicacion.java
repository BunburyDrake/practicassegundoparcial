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
		DataUsuario da = new DataUsuario();
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

	public boolean insertarPublciacion(Publicacion p) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("INSERT INTO publicacion VALUES(null,?,?,null)");
			ps.setInt(1, p.getIduser());
			ps.setString(2, p.getTexto());
			
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<Publicacion> SelectPublicaciones() {
		ArrayList<Publicacion> ListaPublicaciones = new ArrayList<Publicacion>();
		try {
			PreparedStatement ps = conectar().prepareStatement("SELECT * FROM publicacion");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Publicacion x = new Publicacion();
				x.setIdPub(rs.getInt(1));
				x.setIdUser(rs.getInt(2));
				x.setTexto(rs.getString(3));
				x.setFecha(rs.getString(4));
				
				ListaPublicaciones.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return ListaPublicaciones;
	}
	public boolean EliminarPublicacion(int idPub) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("DELETE FROM publicacion WHERE idpub=?");
			ps.setInt(1, idPub);
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
					"UPDATE publicacion SET iduser=?,texto=? WHERE idpub=?");
			ps.setInt(1, a.getIduser());
			ps.setString(2, a.getTexto());
			ps.setInt(3, a.getIdPub());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	}