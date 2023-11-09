package RedSocial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataComentario {
	Connection cx;

	public static void main(String[] ola) {
		DataUsuario da = new DataUsuario();
		da.conectar();
	}

	public DataComentario() {
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

	public boolean insertarComentario(Comentario p) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("INSERT INTO comentario VALUES(null,?,?,?,null)");
			ps.setInt(1, p.getIdUser());
			ps.setInt(2, p.getIdPub());
			ps.setString(3, p.getTexto());
			
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<Comentario> SelectComentario() {
		ArrayList<Comentario> ListaComentarios = new ArrayList<Comentario>();
		try {
			PreparedStatement ps = conectar().prepareStatement("SELECT * FROM comentario");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Comentario x = new Comentario();
				x.setIdCom(rs.getInt(1));
				x.setIdUser(rs.getInt(2));
				x.setIdPub(rs.getInt(3));
				x.setTexto(rs.getString(4));
				x.setFecha(rs.getString(5));
				
				ListaComentarios.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return ListaComentarios;
	}
	public boolean EliminarComentario(int idCom) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("DELETE FROM comentario WHERE idcom=?");
			ps.setInt(1, idCom);
			System.out.println(ps.toString());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	public boolean actualizarComentario(Comentario a) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement(
					"UPDATE comentario SET iduser=?,idpub=?,texto=? WHERE idcom=?");
			ps.setInt(1, a.getIdUser());
			ps.setInt(2, a.getIdPub());
			ps.setString(3, a.getTexto());
			ps.setInt(4, a.getIdCom());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

}
