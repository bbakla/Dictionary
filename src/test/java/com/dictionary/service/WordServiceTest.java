package com.dictionary.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.dictionary.model.Word;
import com.dictionary.model.WordType;
import com.dictionary.repository.WordRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class WordServiceTest {

  @Autowired
  private WordService wordService;

  @Autowired
  private WordRepository wordRepository;

  @AfterEach
  public void cleanUp() {
    wordRepository.deleteAll();
  }


  @ParameterizedTest(name = "{index} => {0} is being saved")
  @MethodSource("words")
  public void canSaveAWord(Word word) {

    Word savedWord = wordService.saveWord(word);

    assertThat(savedWord.getWord()).isEqualTo(word.getWord());
    assertThat(savedWord.getExampleSentences().size())
        .isEqualByComparingTo(word.getExampleSentences().size());
    assertThat(savedWord.getTags().size()).isEqualTo(word.getTags().size());
  }

  @ParameterizedTest(name = "{index} => {0} is being accessed")
  @MethodSource("words")
  public void canGetWords(Word word) {
    wordService.saveWord(word);

    Word savedWord = wordService.findWord(word.getWord()).get();

    assertNotNull(savedWord);
    assertThat(savedWord.getWord()).isEqualTo(word.getWord());
    assertThat(savedWord.getExampleSentences().size())
        .isEqualByComparingTo(word.getExampleSentences().size());
    assertThat(savedWord.getTags().size()).isEqualTo(word.getTags().size());
  }

  @ParameterizedTest(name = "{index} => {0} is being deleted")
  @MethodSource("words")
  public void canDeleteWord(Word word) {
    wordService.saveWord(word);
    Word savedWord = wordService.findWord(word.getWord()).get();
    assertNotNull(savedWord);

    wordService.deleteWord(word.getWord());

    assertFalse(wordService.findWord(word.getWord()).isPresent());
  }

  @Test
  public void canUpdateWord() {
    
    Word word = new Word("sich weigern", WordType.VERB);
    word.translationInEnglish("not willing to do")
    .addTag("verb")
    .addTag("reflexive")
    .addExampleSentence("ich habe gewiegert nein zu sagen");
    
    wordService.saveWord(word);
    Word savedWord = wordService.findWord(word.getWord()).get();
    assertNotNull(savedWord);

    String newTag = "newTag";

    word.addTag(newTag);

    Word updatedWord = wordService.updateWord(word);

    assertTrue(updatedWord.getTags().stream().anyMatch(t -> t.equals(newTag)));

  }

  @Test
  public void canListWordsByTag() {
    Word word = new Word("die Puppe", WordType.NAME);
    word.translationInEnglish("puppet");
    word.addTag("name").addTag("anotherTag");
    wordService.saveWord(word);
    
    Word word2 = new Word("hopen", WordType.VERB);
    word2.translationInEnglish("honk").addTag("verb").addTag("regelmaßig");
    wordService.saveWord(word2);
    
    Word word3 = new Word("befürworten", WordType.VERB);
    word3.translationInEnglish("to support").addTag("verb").addTag("regelmaßig").addTag("trannbare");
    wordService.saveWord(word3);
    
    List<Word> wordsInRepo = wordService.getAllWords();
    assertEquals(3, wordsInRepo.size());
    
    List<Word> words = wordService.getWordsByTag("name");
    assertEquals(1, words.size());
    
    words = wordService.getWordsByTag("verb");
    assertEquals(2,  words.size());
  }
  
  @Test
  public void canListWordsByFilteringMultipleTags() {
    Word word = new Word("die Puppe", WordType.NAME);
    word.translationInEnglish("puppet");
    word.addTag("name").addTag("anotherTag");
    wordService.saveWord(word);
    
    Word word2 = new Word("hopen", WordType.VERB);
    word2.translationInEnglish("honk").addTag("verb").addTag("regelmaßig");
    wordService.saveWord(word2);
    
    Word word3 = new Word("befürworten", WordType.VERB);
    word3.translationInEnglish("to support").addTag("verb").addTag("regelmaßig").addTag("trannbare");
    wordService.saveWord(word3);
    
    List<Word> wordsInRepo = wordService.getAllWords();
    assertEquals(3, wordsInRepo.size());
    
    List<Word> words = wordService.getWordsByTag("verb", "regelmaßig");
    assertEquals(2,  words.size());
  }

  private static Stream<Arguments> words() {
    return Stream.of(
        Arguments.of(new Word("beleidigt sein", "to be offended", "rencide olmak", null,
            Arrays.asList("Er fühlt sich in seiner Ehre beleidigt sein."),
            Arrays.asList("verb", "feeling"), null, Arrays.asList("ein diches Fell haben"),
            WordType.VERB)),

        Arguments
            .of(new Word("sich weigern", "to refuse", "reddetmek;yapmamak istedigini belirtmek",
                null, Arrays.asList("Das Mädchen weigert sich Danke zu sagen"),
                Arrays.asList("verb", "reflexive"),
                Arrays.asList(new String("ablehnen"), new String("zusagen")), null, WordType.VERB))

    );

  }



}
