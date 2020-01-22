package be.sanderdms.employer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import be.sanderdms.utils.MyUtils;


@Entity
public class Employer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Gelieve een naam in te voeren")
	@Size(min=2, max=50, message="Naam moet tussen de 2 en 50 karakters bevatten")
	@Pattern(regexp = "^$|(^[^0-9]+$)", message = "Naam kan geen nummers bevatten")
	private String name;

	@NotBlank(message="Gelieve een voornaam in te voeren")
	@Size(min=2, max=50, message="Voornaam moet tussen de 2 en 50 karakters bevatten")
	@Pattern(regexp = "^$|(^[^0-9]+$)", message = "Voornaam kan geen nummers bevatten")
	private String fname; // firstName

	@NotBlank(message="Gelieve een email in te voeren")
	@Email(message ="Email is niet geldig")
	private String email;

	private Integer availability;
	
	@NotBlank(message="Gelieve een stad in te voeren")
	@Pattern(regexp = "^$|(^[^0-9]+$)", message = "Stad kan geen nummers bevatten")
	private String city;

	//TODO: enumerate departments or fetch from departments table
	private String department;
	

	private String[] License;
	//https://thoughts-on-java.org/jpa-21-how-to-implement-type-converter/
	//https://github.com/vladmihalcea/hibernate-types

	protected Employer() {
		
		// set this.licenceStringArray = License.split(",");
		
	}

	public String[] getLicense() {
		return License;
	}

	public void setLicense(final String[] license) {
		License = license;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(final String fname) {
		this.fname = MyUtils.capitalize(fname).trim();
	}

	public Integer getAvailability() {
		return availability;
	}

	public void setAvailability(final Integer availability) {
		this.availability = availability;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = MyUtils.capitalize(city).trim();
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(final String department) {
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = MyUtils.capitalize(name).trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

}
