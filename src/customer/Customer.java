package customer;

import hola.DataAlumno;

public class Customer {
int customerID;
String CompanyName;
String ContactName;
String ContactTitle;
String Address;
String City;
String Region;
String PostalCode;
String Country;
String Phone;
String Fax;
public Customer() {
	
}
DataCustomer da=new DataCustomer();

public boolean insertarCustomer() {
	if(da.insertarCustomer(this)) {
		return true;
	}else {
		return false;
	}
}
public boolean EliminarCustomer() {
	if(da.EliminarCustomer(this.getCustomerID())) {
		return true;
	}else {
		return false;
	}
}
public boolean actualizarCustomer() {
	if(da.actualizarCustomer(this)) {
		return true;
	}else {
		return false;
	}
}
public Customer(int customerID, String companyName, String contactName, String contactTitle, String address,
		String city, String region, String postalCode, String country, String phone, String fax) {
	super();
	this.customerID = customerID;
	CompanyName = companyName;
	ContactName = contactName;
	ContactTitle = contactTitle;
	Address = address;
	City = city;
	Region = region;
	PostalCode = postalCode;
	Country = country;
	Phone = phone;
	Fax = fax;
}
public int getCustomerID() {
	return customerID;
}
public void setCustomerID(int customerID) {
	this.customerID = customerID;
}
public String getCompanyName() {
	return CompanyName;
}
public void setCompanyName(String companyName) {
	CompanyName = companyName;
}
public String getContactName() {
	return ContactName;
}
public void setContactName(String contactName) {
	ContactName = contactName;
}
public String getContactTitle() {
	return ContactTitle;
}
public void setContactTitle(String contactTitle) {
	ContactTitle = contactTitle;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getCity() {
	return City;
}
public void setCity(String city) {
	City = city;
}
public String getRegion() {
	return Region;
}
public void setRegion(String region) {
	Region = region;
}
public String getPostalCode() {
	return PostalCode;
}
public void setPostalCode(String postalCode) {
	PostalCode = postalCode;
}
public String getCountry() {
	return Country;
}
public void setCountry(String country) {
	Country = country;
}
public String getPhone() {
	return Phone;
}
public void setPhone(String phone) {
	Phone = phone;
}
public String getFax() {
	return Fax;
}
public void setFax(String fax) {
	Fax = fax;
}

}
