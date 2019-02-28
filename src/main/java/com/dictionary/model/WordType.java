package com.dictionary.model;

public enum WordType {
  
  VERB("verb"), ADVERB("adverb"), ADJECTIVE("adverb"), NAME("name"), IDIOM("idiom");
  
  private String name;
  
  private WordType(String name) {
    this.name = name;
  }

}
