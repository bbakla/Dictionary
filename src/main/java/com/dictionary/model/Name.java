package com.dictionary.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Name extends Word {
  
  private String plural;
  private Artikel artikel;
  
  public Name() {
    
  }
  
  public Name(String word, Artikel artikel) {
    super(word, WordType.NAME);
    this.artikel = artikel;
  }

  public Name(String word, String translationInEnglish, String translationInTurkish,
      String explanationInGerman, List<String> exampleSentences, List<Tag> tags,
      List<Word> synonmys, List<Word> oppositeMeanings, Artikel artikel, String plural) {
    
    super(word, translationInEnglish, translationInTurkish, explanationInGerman, exampleSentences,
        tags, synonmys, oppositeMeanings, WordType.NAME);
    
    this.plural = plural;
    this.artikel =  artikel;
  }

  public String getPlural() {
    return plural;
  }

  public void setPlural(String plural) {
    this.plural = plural;
  }

  public Artikel getArtikel() {
    return artikel;
  }

  public void setArtikel(Artikel artikel) {
    this.artikel = artikel;
  }
  
  

}
