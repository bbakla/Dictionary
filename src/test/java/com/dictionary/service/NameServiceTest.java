package com.dictionary.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.dictionary.model.Artikel;
import com.dictionary.model.Name;
import com.dictionary.model.Tag;
import com.dictionary.repository.NameRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class NameServiceTest {

  @Autowired
  private NameService nameService;

  @Autowired
  private NameRepository nameRepository;

  @AfterEach
  public void cleanUp() {
    nameRepository.deleteAll();
  }


  @ParameterizedTest(name = "{index} => {0} is being saved")
  @MethodSource("names")
  public void canSaveAName(Name name) {

    Name savedName = nameService.saveName(name);

    assertThat(savedName.getWord()).isEqualTo(name.getWord());
    assertThat(savedName.getTags().size()).isEqualTo(name.getTags().size());
  }
  
  @ParameterizedTest(name = "{index} => {0} as name being saved")
  @MethodSource("names") 
  public void canSaveNames(Name name) {
    Name savedName = nameService.saveName(name);

    assertThat(savedName.getWord()).isEqualTo(name.getWord());
    assertThat(savedName.getTags().size()).isEqualTo(name.getTags().size());
  }

  @ParameterizedTest(name = "{index} => {0} is being accessed")
  @MethodSource("names")
  public void canGetNames(Name name) {
    nameService.saveName(name);

    Name savedName = nameService.findName(name.getWord()).get();

    assertNotNull(savedName);
    assertThat(savedName.getWord()).isEqualTo(name.getWord());
    assertThat(savedName.getTags().size()).isEqualTo(name.getTags().size());
  }

  @ParameterizedTest(name = "{index} => {0} is being deleted")
  @MethodSource("names")
  public void canDeleteName(Name Name) {
    nameService.saveName(Name);
    Name savedName = nameService.findName(Name.getWord()).get();
    assertNotNull(savedName);

    nameService.deleteName(Name.getWord());

    assertFalse(nameService.findName(Name.getWord()).isPresent());
  }

  @Test
  public void canUpdateName() {
    
    Name name = new Name("Schmetterling", Artikel.DER);
    name.translationInEnglish("not willing to do")
    .addTag(new Tag("verb"))
    .addTag(new Tag("reflexive"))
    .addExampleSentence("ich habe gewiegert nein zu sagen");
    
    nameService.saveName(name);
    Name savedName = nameService.findName(name.getWord()).get();
    assertNotNull(savedName);

    String newTag = "newTag";

    name.addTag(new Tag(newTag));

    Name updatedName = nameService.updateName(name);

    assertTrue(updatedName.getTags().stream().anyMatch(t -> t.equals(newTag)));

  }

  @Test
  public void canListNamesByTag() {
    Name name = new Name("Puppe", Artikel.DIE);
    name.translationInEnglish("puppet");
    name.addTag(new Tag("name")).addTag(new Tag("anotherTag"));
    nameService.saveName(name);
    
    Name name2 = new Name("hopen", Artikel.DAS);
    name2.translationInEnglish("honk").addTag(new Tag("name")).addTag(new Tag("regelmaﬂig"));
    nameService.saveName(name2);
    
    Name name3 = new Name("bef¸rworten", Artikel.DAS);
    name3.translationInEnglish("to support").addTag(new Tag("verb"))
                                            .addTag(new Tag("regelmaﬂig"))
                                            .addTag(new Tag("trannbare"));
    nameService.saveName(name3);
    
    List<Name> namesInRepo = nameService.getAllNames();
    assertEquals(3, namesInRepo.size());
    
    List<Name> names = nameService.getNamesByTag("name");
    assertEquals(2, names.size());
    
    names = nameService.getNamesByTag("verb");
    assertEquals(1,  names.size());
  }
  
  @Test
  public void canListNamesByFilteringMultipleTags() {
    Name name = new Name("Puppe", Artikel.DAS);
    name.translationInEnglish("puppet");
    name.addTag(new Tag("name")).addTag(new Tag("anotherTag"));
    nameService.saveName(name);
    
    Name name2 = new Name("hopen", Artikel.DER);
    name2.translationInEnglish("honk").addTag(new Tag("verb")).addTag(new Tag("regelmaﬂig"));
    nameService.saveName(name2);
    
    Name name3 = new Name("bef¸rworten", Artikel.DIE);
    name3.translationInEnglish("to support").addTag(new Tag("verb"))
                                            .addTag(new Tag("regelmaﬂig")).addTag(new Tag("trannbare"));
    nameService.saveName(name3);
    
    List<Name> namesInRepo = nameService.getAllNames();
    assertEquals(3, namesInRepo.size());
    
    List<Name> names = nameService.getNamesByTag("verb", "regelmaﬂig");
    assertEquals(2,  names.size());
  }

  
  private static Stream<Arguments> names() {
    return Stream.of(
        Arguments.of(new Name("Puppe", "puppet", null, null,
            null,
            Arrays.asList(new Tag("name"), new Tag("regelmaﬂig")), null, null, Artikel.DIE, "Puppen")),

        Arguments.of(new Name("kanitschen", "rabbit", null,
                null, null,
                Arrays.asList(new Tag("name"), new Tag("animal"), new Tag("regelmaﬂig")),
                null, null, Artikel.DAS, "Kanitschen"))
        );
  }



}
