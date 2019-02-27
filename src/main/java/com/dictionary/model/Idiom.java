package com.dictionary.model;

import java.util.List;
import org.springframework.data.annotation.Id;

public class Idiom {

  @Id
  public Word expression;
  
  public List<Word> exampleSentences;
  public List<Word> tags;

  public Word getExpression() {
    return expression;
  }
  public void setExpression(Word expression) {
    this.expression = expression;
  }
  public List<Word> getExampleSentences() {
    return exampleSentences;
  }
  public void setExampleSentences(List<Word> exampleSentences) {
    this.exampleSentences = exampleSentences;
  }
  public List<Word> getTags() {
    return tags;
  }
  public void setTags(List<Word> tags) {
    this.tags = tags;
  }
  
  
}
