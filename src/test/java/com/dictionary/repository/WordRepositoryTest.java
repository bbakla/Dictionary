package com.dictionary.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dictionary.model.Word;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WordRepositoryTest {

	@Autowired
	private WordRepository wordRepository;
	
	@Test
	public void shouldBeAbleToSave() {
		Word word = new Word();
		
		word.setWord("sich ausdrücken");
		word.setTranslationInEnglish("express yourself");
		word.addExampleSentence("Ich kann mich noch nicht auf Deutsch ausdrücken");
		word.addTag("verb");
		
		wordRepository.save(word);
		
		Optional<Word> savedWord = wordRepository.findById(word.getWord());
		
		assertTrue(savedWord.isPresent());
		assertEquals(word.getWord(), savedWord.get().getWord());
	}

}
