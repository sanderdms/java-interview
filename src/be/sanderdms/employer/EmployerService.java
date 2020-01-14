package be.sanderdms.employer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployerService {
	@Autowired
	private EmployerRepository repo;
	
	public List<Employer> listAll(){
		return (List<Employer>) repo.findAll();
	}
	
	public void save(Employer employer) {
		repo.save(employer);
	}
	
	public Employer getById(long id) {
		Optional<Employer> result = repo.findById(id);
		return result.get();
	}
	
	public void delete(long id) {
    	repo.deleteById(id);
    }
}
