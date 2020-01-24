package be.sanderdms.employer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerService {
    @Autowired
    private EmployerRepository repo;

    /**
     * Lists all rows in Employer table
     * 
     * @return A list with Employer objects. One object for each row in database.
     */
    public List<Employer> listAll() {
        return (List<Employer>) repo.findAll();
    }

    /**
     * Save an employer object to database
     * 
     * @param employer The Employer object
     */
    public void save(Employer employer) {
        repo.save(employer);
    }

    /**
     * 
     * @param id
     * @return the Employer object matching the requested id or empty if no result found
     */
    public Employer getById(long id) {
        Optional<Employer> result = repo.findById(id);
        return result.get();

    }

    /**
     * 
     * @param id the id to delete from database
     */
    public void delete(long id) {
        repo.deleteById(id);
    }

    /**
     * Count the items present in database
     * 
     * @return a Long representing the amount of items in database
     */
    public Long countItems() {
        return repo.count();
    }
}
