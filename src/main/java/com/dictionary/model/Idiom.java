package com.dictionary.model;

import java.util.List;
import org.springframework.data.annotation.Id;

public class Idiom {

  @Id
  public String expression;
  
  public List<String> exampleSentences;
  public List<String> tags;

  public String getExpression() {
    return expression;
  }
  public void setExpression(String expression) {
    this.expression = expression;
  }
  public List<String> getExampleSentences() {
    return exampleSentences;
  }
  public void setExampleSentences(List<String> exampleSentences) {
    this.exampleSentences = exampleSentences;
  }
  public List<String> getTags() {
    return tags;
  }
  public void setTags(List<String> tags) {
    this.tags = tags;
  }
  
  
}
