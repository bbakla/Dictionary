package com.dictionary.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.dictionary.model.Name;
import com.dictionary.service.Artikel;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class NameRepositoryTest {

  @Autowired
  private NameRepository nameRepository;
  
  @BeforeEach
  public void clean() {
    nameRepository.deleteAll();
  }
  
  @ParameterizedTest(name = "{index} => {0} as name being saved")
  @MethodSource("names") 
  public void canSaveNames(Name name) {
    Name savedName = nameRepository.save(name);

    assertThat(savedName.getWord()).isEqualTo(name.getWord());
    assertThat(savedName.getTags().size()).isEqualTo(name.getTags().size());
  }
  
  private static Stream<Arguments> names() {
    return Stream.of(
        Arguments.of(new Name("Puppe", "puppet", null, null,
            null,
            Arrays.asList("name", "regelmaﬂig"), null, null, Artikel.DIE, "Puppen")),

        Arguments.of(new Name("kanitschen", "rabbit", null,
                null, null,
                Arrays.asList("name", "animal", "regelmaﬂig"),
                null, null, Artikel.DAS, "Kanitschen"))
        );
  }
}
