package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hola.Alumno;
import hola.DataAlumno;

public class DataCustomer {
	Connection cx;

	public static void main(String[] ola) {
		DataCustomer da = new DataCustomer();
		da.conectar();
	}

	public DataCustomer() {
	}

	public Connection conectar() {
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "");
			System.out.println("CONEXION EXITOSA");
		} catch (SQLException e) {
			System.out.println("FALLO CONEXION");
			e.printStackTrace();
		}
		return cx;
	}

	public boolean insertarCustomer(Customer a) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("INSERT INTO customer VALUES(null,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, a.getCompanyName());
			ps.setString(2, a.getContactName());
			ps.setString(3, a.getContactTitle());
			ps.setString(4, a.getAddress());
			ps.setString(5, a.getCity());
			ps.setString(6, a.getRegion());
			ps.setString(7, a.getPostalCode());
			ps.setString(8, a.getCountry());
			ps.setString(9, a.getPhone());
			ps.setString(10, a.getFax());
			
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public ArrayList<Customer> SelectCustomer() {
		ArrayList<Customer> ListaCustomer = new ArrayList<Customer>();
		try {
			PreparedStatement ps = conectar().prepareStatement("SELECT * FROM customer");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer x = new Customer();
				x.setCustomerID(rs.getInt(1));
				x.setCompanyName(rs.getString(2));
				x.setContactName(rs.getString(3));
				x.setContactTitle(rs.getString(4));
				x.setAddress(rs.getString(5));
				x.setCity(rs.getString(6));
				x.setRegion(rs.getString(7));
				x.setPostalCode(rs.getString(8));
				x.setCountry(rs.getString(9));
				x.setPhone(rs.getString(10));
				x.setFax(rs.getString(11));
				
				ListaCustomer.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return ListaCustomer;
	}

	public boolean EliminarCustomer(int customerID) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("DELETE FROM customer WHERE customerID=?");
			ps.setInt(1, customerID);
			System.out.println(ps.toString());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean actualizarCustomer(Customer a) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement(
					"UPDATE customer SET CompanyName=?,ContactName=?,ContactTitle=?,Address=?,City=?,Region=?,PostalCode=?,Country=?,Phone=?,Fax=? WHERE customerID=?");
			ps.setString(1, a.getCompanyName());
			ps.setString(2, a.getContactName());
			ps.setString(3, a.getContactTitle());
			ps.setString(4, a.getAddress());
			ps.setString(5, a.getCity());
			ps.setString(6, a.getRegion());
			ps.setString(7, a.getPostalCode());
			ps.setString(8, a.getCountry());
			ps.setString(9, a.getPhone());
			ps.setString(10, a.getFax());
			ps.setInt(11, a.getCustomerID());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
}
