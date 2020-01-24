package be.sanderdms.employer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import be.sanderdms.utils.MyUtils;

@Entity
@Table(name="Employer")
public class Employer {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * The last name of the employee.
	 */
	@NotBlank(message="Gelieve een naam in te voeren")
	@Size(min=2, max=50, message="Naam moet tussen de 2 en 50 karakters bevatten")
	@Pattern(regexp = "^$|(^[^0-9]+$)", message = "Naam kan geen nummers bevatten")
	private String name;
	
	/**
	 * The first name of the employee.
	 */
	@NotBlank(message="Gelieve een voornaam in te voeren")
	@Size(min=2, max=50, message="Voornaam moet tussen de 2 en 50 karakters bevatten")
	@Pattern(regexp = "^$|(^[^0-9]+$)", message = "Voornaam kan geen nummers bevatten")
	private String fname; // firstName
	
	/**
	 * The email address of the employee.
	 */
	@NotBlank(message="Gelieve een email in te voeren")
	@Email(message ="Email is niet geldig")
	private String email;
	
	/**
	 * A status indicating weather the employee is available for work or not.
	 */
	private Integer availability;
	
	/**
	 * The city of residence of the employee.
	 */
	@NotBlank(message="Gelieve een stad in te voeren")
	@Pattern(regexp = "^$|(^[^0-9]+$)", message = "Stad kan geen nummers bevatten")
	private String city;

	/**
	 * The company department the employee is employed in.
	 */
	private String department; // TODO: consider enumerate
	
	/**
	 * A list containing the employers driver license permits.
	 */
	private String[] License; // TODO: implement type converter
	
	
	// ==== GETTERS and SETTERS ====
	
	
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
		this.fname =  MyUtils.capitalize(fname.trim());
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
		this.city =  MyUtils.capitalize(city.trim());
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
		this.name = MyUtils.capitalize(name.trim());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email.toLowerCase();
	}

}
