package com.dictionary.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Word {

  @Id
  @NotNull
  private String word;

  private String translationInEnglish;
  private String translationInTurkish;
  private String explanationInGerman;
  private List<String> exampleSentences;
  private List<String> tags;
  private List<String> synonmys;
  private List<String> oppositeMeanings;


  public Word(String word) {
    this.word = word;
    this.exampleSentences = new ArrayList<>();
    this.tags = new ArrayList<>();
    oppositeMeanings = new ArrayList<>();
  }
  
  public Word(String word, String translationInEnglish, String translationInTurkish, String explanationInGerman,
       List<String> exampleSentences, List<String> tags, List<String> synonmys,
      List<String> oppositeMeanings) {
    super();
    this.word = word;
    this.translationInEnglish = translationInEnglish;
    this.translationInTurkish = translationInTurkish;
    this.explanationInGerman = explanationInGerman;
    this.exampleSentences = exampleSentences;
    this.tags = tags;
    this.synonmys = synonmys;
    this.oppositeMeanings = oppositeMeanings;
  }


  public String getWord() {
    return word;
  }

  public Word word(String word) {
    this.word = word;
    
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

  public void addTag(String tag) {
    this.tags.add(tag);
  }

  public List<String> getTags() {
    return tags;
  }

  public Word tags(List<String> tags) {
    this.tags = tags;
    
    return this;
  }

  public List<String> getSynonmys() {
    return synonmys;
  }

  public Word synonmys(List<String> synonmys) {
    this.synonmys = synonmys;
    
    return this;
  }

  public List<String> getOppositeMeanings() {
    return oppositeMeanings;
  }

  public Word oppositeMeanings(List<String> oppositeMeanings) {
    this.oppositeMeanings = oppositeMeanings;
    
    return this;
  }
}
