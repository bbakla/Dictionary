package com.dictionary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dictionary.model.Word;
import com.dictionary.repository.WordRepository;
import net.bytebuddy.asm.Advice.Return;

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
}
