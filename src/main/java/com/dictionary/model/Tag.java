package com.dictionary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;
import org.springframework.data.annotation.Id;

@Entity
@Table(name="Tag")
public class Tag {
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
//  @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
//  @GenericGenerator(name = "system-uuid", strategy = "uuid2")
  private String id;
  
  @Column
  @NotNull
  String tag;
  
  @Column
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="word_id")
  private Word word;
  
  
  public Tag(String tag) {
    this.tag = tag;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public Word getWord() {
    return word;
  }

  public void setWord(Word word) {
    this.word = word;
  }
}
