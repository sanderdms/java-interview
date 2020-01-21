package be.sanderdms.employer;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import be.sanderdms.utils.MyUtils;





@Entity
public class Employer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Gelieve een naam in te voeren")
	@Size(min=2, max=50, message="Naam moet tussen de 2 en 50 karakters bevatten")
	private String name;
	@NotBlank(message="Gelieve een voornaam in te voeren")
	@Size(min=2, max=50, message="Voornaam moet tussen de 2 en 50 karakters bevatten")
	private String fname; // firstName
	@NotBlank(message="Gelieve een email in te voeren")
	@Email(message ="Email is niet geldig")
	private String email;
	//@NotBlank(message="Gelieve een address in te voeren")
	//@Size(min=5, max=100, message="Adres moet tussen 5 en 100 karakters bevatten")
	private String address;
	
	private Integer availability;
	
	@NotBlank(message="Gelieve een stad in te voeren")
	private String city;
	private String department;
	private String[] License;
	
//https://beanvalidation.org/2.0/
	
protected Employer() {
	
}

public String[] getLicense() {
	return License;
}

public String getLicenseFormatted() {
	String joined = String.join(",", License);
	return joined;
	//return License;
}


public void setLicense(String[] license) {	
	
	License = license;
	
	//this.license = license;
	//https://reversecoding.net/java-8-convert-list-string-comma/
}


public String getFname() {
	return fname;
}


public void setFname(String fname) {
	this.fname = fname;
}


public Integer getAvailability() {
	return availability;
}

public void setAvailability(Integer availability) {
	this.availability = availability;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = MyUtils.capitalize(city);
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = MyUtils.capitalize(name);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
