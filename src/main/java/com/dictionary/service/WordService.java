package com.dictionary.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dictionary.model.Word;
import com.dictionary.repository.WordRepository;

@Service
public class WordService {
  
  private WordRepository wordRepository;
  
  @Autowired
  public WordService(WordRepository wordRepository) {
    this.wordRepository = wordRepository;
  }

  public Word saveWord(Word word) {
    return wordRepository.save(word);
  }

  public Optional<Word> findWord(String word) {
    return wordRepository.findById(word);
  }

  public void deleteWord(String word) {
    wordRepository.deleteById(word);
  }

  public Word updateWord(Word word) {
    return saveWord(word);
  }
  
  public List<Word> getAllWords() {
    return wordRepository.findAll();
  }

  public List<Word> getWordsByTag(String... tag) {
     return wordRepository.findByTagsIn(Arrays.stream(tag).collect(Collectors.toList()));
  }
}
