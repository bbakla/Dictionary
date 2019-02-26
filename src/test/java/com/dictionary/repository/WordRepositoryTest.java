package com.dictionary.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dictionary.model.Word;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class WordRepositoryTest {

	@Autowired
	private WordRepository wordRepository;
	
	@Test
	public void shouldBeAbleToSave() {
		Word word = new Word("sich ausdrücken");
		
		word.translationInEnglish("express yourself");
		word.addExampleSentence("Ich kann mich noch nicht auf Deutsch ausdrücken");
		word.addTag("verb");
		
		wordRepository.save(word);
		
		Optional<Word> savedWord = wordRepository.findById(word.getWord());
		
		assertTrue(savedWord.isPresent());
		assertEquals(word.getWord(), savedWord.get().getWord());
	}

}
