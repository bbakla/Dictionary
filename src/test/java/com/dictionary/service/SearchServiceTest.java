//package com.dictionary.service;
//
//import java.util.Arrays;
//import java.util.stream.Stream;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import com.dictionary.model.Word;
//import com.dictionary.model.WordType;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class SearchServiceTest {
//
//  @Autowired
//  private WordService wordService;
//
// public void canSearchWordByName() {
//   
// }
//  
//  @ParameterizedTest(name="{index} => {0} is being accessed")
//  @MethodSource("words")
//  public void canSearchWordBySuffix() {
//    
//  }
//  
//  public void canSearchWordByPrefix() {
//    
//  }
//  
//  
//  
//
//  private static Stream<Arguments> words() {
//    return Stream.of(
//        Arguments.of(new Word("beleidigt sein", "to be offended", "rencide olmak",
//                      null, Arrays.asList("Er fühlt sich in seiner Ehre beleidigt sein."),
//                      Arrays.asList("verb", "feeling"), null, Arrays.asList(new String("ein diches Fell haben")), WordType.VERB)),
//        
//        Arguments.of(new Word("sich weigern", "to refuse", "reddetmek;yapmamak istedigini belirtmek",
//                      null, Arrays.asList("Das Mädchen weigert sich Danke zu sagen"),
//                      Arrays.asList("verb", "reflexive"), Arrays.asList(new String("ablehnen"), new String("zusagen")), null, WordType.VERB))
//
//    );
//
//  }
//
//
//
//}
