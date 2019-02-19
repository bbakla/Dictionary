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
	
	
	public Word() {
		this.exampleSentences = new ArrayList<>();
		this.tags = new ArrayList<>();
	}
	
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getTranslationInEnglish() {
		return translationInEnglish;
	}
	public void setTranslationInEnglish(String translationInEnglish) {
		this.translationInEnglish = translationInEnglish;
	}
	public String getTranslationInTurkish() {
		return translationInTurkish;
	}
	public void setTranslationInTurkish(String translationInTurkish) {
		this.translationInTurkish = translationInTurkish;
	}
	public String getExplanationInGerman() {
		return explanationInGerman;
	}
	public void setExplanationInGerman(String explanationInGerman) {
		this.explanationInGerman = explanationInGerman;
	}
	public List<String> getExampleSentences() {
		return exampleSentences;
	}
	public void setExampleSentences(List<String> exampleSentences) {
		this.exampleSentences = exampleSentences;
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
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
}
