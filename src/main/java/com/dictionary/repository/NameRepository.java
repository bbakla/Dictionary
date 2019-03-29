package com.dictionary.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dictionary.model.Name;
import java.util.List;

@Repository
public interface NameRepository extends CrudRepository<Name, String>{
	List<Name> findByTagsIn(List<String> tags);
	List<Name> findAll();

}
