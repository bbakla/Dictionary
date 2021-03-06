package com.dictionary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;
import com.dictionary.model.Name;
import com.dictionary.model.Verb;
import com.dictionary.model.Word;
import java.util.List;

@Repository
public interface VerbRepository extends MongoRepository<Verb, String>{
	List<Verb> findByTagsIn(List<String> tags);

}
