package edu.kashp.repository;

import edu.kashp.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  EmployeeMongoRepository
  @version  1.0.0 
  @since 30.07.2021 - 18.20
*/

@Repository
public interface EmployeeMongoRepository extends MongoRepository<Employee, String> {
}
