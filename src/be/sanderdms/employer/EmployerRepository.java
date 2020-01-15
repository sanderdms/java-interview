package be.sanderdms.employer;

import org.springframework.data.repository.CrudRepository;

//https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring
public interface EmployerRepository extends CrudRepository<Employer, Long> {

}
