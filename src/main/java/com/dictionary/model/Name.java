package com.dictionary.model;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import com.dictionary.service.Artikel;

@Document(collection="name")
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
      String explanationInGerman, List<String> exampleSentences, List<String> tags,
      List<String> synonmys, List<String> oppositeMeanings, Artikel artikel, String plural) {
    
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
