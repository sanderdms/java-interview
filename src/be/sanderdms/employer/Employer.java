package be.sanderdms.employer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;




@Entity
public class Employer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Gelieve een naam in te voeren")
	@Size(min=2, max=50, message="Naam moet tussen de 2 en 50 karakters bevatten")
	private String name;
	@NotBlank(message="Gelieve een email in te voeren")
	@Email(message ="Email is niet geldig")
	private String email;
	@NotBlank(message="Gelieve een address in te voeren")
	@Size(min=5, max=100, message="Adres moet tussen 5 en 100 karakters bevatten")
	private String address;
	
//https://beanvalidation.org/2.0/
	
protected Employer() {
	
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
		this.name = name;
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
