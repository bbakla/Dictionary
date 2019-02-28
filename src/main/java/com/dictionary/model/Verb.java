package com.dictionary.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="verb")
public class Verb extends Word {
  private Map<Tense, String> tenseForms;

  public Verb(String word) {
    super(word, WordType.VERB);
    tenseForms = new EnumMap<>(Tense.class);
  }

  public Verb(String word, String translationInEnglish, String translationInTurkish,
      String explanationInGerman, List<String> exampleSentences, List<String> tags,
      List<String> synonmys, List<String> oppositeMeanings, Map<Tense, String> tenseForms) {
    
    super(word, translationInEnglish, translationInTurkish, explanationInGerman, exampleSentences,
        tags, synonmys, oppositeMeanings, WordType.VERB);
    
    this.tenseForms = tenseForms;
  }

  public Map<Tense, String> getTenseForms() {
    return tenseForms;
  }

  public void setTenseForms(Map<Tense, String> tenseForms) {
    this.tenseForms = tenseForms;
  }
  
  public Verb putTenseForm(Tense tense, String form) {
    this.tenseForms.put(tense, form);
    
    return this;
  }
  
  


}
