package org.djohnson.sblogic.repository;

import java.util.List;

import org.djohnson.sblogic.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * UserRepository is an interface for CRUD functions with JPA.
 * 
 * @author DJohnspon
 * @since 1.0
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	/**
	 * Find list of {@link User} user by their name.
	 * 
	 * @param name the name to search by
	 * @return list of {@link User}
	 */
	List<User> findByName(String name);

}
