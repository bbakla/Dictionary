package com.dictionary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.dictionary.model.Name;
import java.util.List;

@Repository
public interface NameRepository extends MongoRepository<Name, String>{
	List<Name> findByTagsIn(List<String> tags);

}
