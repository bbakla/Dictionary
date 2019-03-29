package com.dictionary.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

@MappedSuperclass
public abstract class Word {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private String word;

  @NotNull
  @Enumerated
  @Column(length = 8)
  private WordType wordType;
  
  private String translationInEnglish;
  private String translationInTurkish;
  private String explanationInGerman;
  
  
  private List<String> exampleSentences;
  
  @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="word")
  @JoinColumn(name="word_id")
  private List<Tag> tags;
//  private List<Word> synonmys;
//  private List<Word> oppositeMeanings;
  private String note;


  public Word() {
    
  }
  
  public Word(String word, WordType wordType) {
    this.word = word;
    this.wordType = wordType;
    this.exampleSentences = new ArrayList<>();
    this.tags = new ArrayList<>();
//    this.synonmys = new ArrayList<>();
//    this.oppositeMeanings = new ArrayList<>();
//    this.oppositeMeanings = new ArrayList<>();
  }
  
  public Word(String word, String translationInEnglish, String translationInTurkish, String explanationInGerman,
       List<String> exampleSentences, List<Tag> tags, List<Word> synonmys,
      List<Word> oppositeMeanings, WordType wordType) {
    super();
    this.word = word;
    this.wordType = wordType;
    this.translationInEnglish = translationInEnglish;
    this.translationInTurkish = translationInTurkish;
    this.explanationInGerman = explanationInGerman;
    this.exampleSentences = exampleSentences;
    this.tags = tags;
//    this.synonmys = synonmys;
//    this.oppositeMeanings = oppositeMeanings;
  }


  public String getWord() {
    return word;
  }

  public Word word(String word) {
    this.word = word;
    
    return this;
  }
  
  public WordType getWordType() {
    return wordType;
  }

  public Word wordType(WordType wordType) {
    this.wordType = wordType;
    
    return this;
  }

  public String getTranslationInEnglish() {
    return translationInEnglish;
  }

  public Word translationInEnglish(String translationInEnglish) {
    this.translationInEnglish = translationInEnglish;
    
    return this;
  }

  public String getTranslationInTurkish() {
    return translationInTurkish;
  }

  public Word translationInTurkish(String translationInTurkish) {
    this.translationInTurkish = translationInTurkish;
    
    return this;
  }

  public String getExplanationInGerman() {
    return explanationInGerman;
  }

  public Word explanationInGerman(String explanationInGerman) {
    this.explanationInGerman = explanationInGerman;
    
    return this;
  }

  public List<String> getExampleSentences() {
    return exampleSentences;
  }

  public Word exampleSentences(List<String> exampleSentences) {
    this.exampleSentences = exampleSentences;
    
    return this;
  }

  public void addExampleSentence(String exampleSentence) {
    this.exampleSentences.add(exampleSentence);
  }

  public Word addTag(Tag tag) {
    this.tags.add(tag);
    
    return this;
  }

  public List<Tag> getTags() {
    return tags;
  }

  public Word tags(List<Tag> tags) {
    this.tags = tags;
    
    return this;
  }

  /*
  public List<Word> getSynonmys() {
    return synonmys;
  }
  
  public Word addSynonmys(Word synonmys) {
    this.synonmys.add(synonmys);
    
    return this;
  }

  public Word synonmys(List<Word> synonmys) {
    this.synonmys = synonmys;
    
    return this;
  }

  public List<Word> getOppositeMeanings() {
    return oppositeMeanings;
  }
  
  public Word addOppositeMeaning(Word word) {
    this.oppositeMeanings.add(word);
    
    return this;
  }

  public Word oppositeMeanings(List<Word> oppositeMeanings) {
    this.oppositeMeanings = oppositeMeanings;
    
    return this;
  }
  */

  public String getNote() {
    return note;
  }

  public Word note(String note) {
    this.note = note;
    
    return this;
  }
}
