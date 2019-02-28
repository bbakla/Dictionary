package com.dictionary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.dictionary.model.Word;
import java.util.List;

@Repository
public interface WordRepository extends MongoRepository<Word, String>{
	List<Word> findByTagsIn(List<String> tags);

}
