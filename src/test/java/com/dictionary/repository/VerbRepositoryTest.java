package com.dictionary.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.dictionary.model.Tag;
import com.dictionary.model.Tense;
import com.dictionary.model.Verb;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class VerbRepositoryTest {

  @Autowired
  private VerbRepository verbRepository;
  
  @ParameterizedTest(name = "{index} => {0} as name being saved")
  @MethodSource("verbs") 
  public void canSaveNames(Verb verb) {
    Verb savedVerb = verbRepository.save(verb);

    assertThat(savedVerb.getWord()).isEqualTo(verb.getWord());
    assertThat(savedVerb.getExampleSentences().size())
        .isEqualByComparingTo(verb.getExampleSentences().size());
    assertThat(savedVerb.getTags().size()).isEqualTo(verb.getTags().size());
  }
  
  private static Stream<Arguments> verbs() {
    
    Map<Tense, String> tenses = new EnumMap<>(Tense.class);
    tenses.put(Tense.PRESENT, "sich weigert");
    tenses.put(Tense.PAST, "sich weigerte");
    tenses.put(Tense.PRESENT_PERFECT, "hat sich gewiegert");
    
    return Stream.of(
        Arguments.of(new Verb("beleidigt sein", "to be offended", "rencide olmak", null,
            Arrays.asList("Er fühlt sich in seiner Ehre beleidigt sein."),
            Arrays.asList(new Tag("verb"), new Tag("feeling")), null, Arrays.asList(new Verb("ein diches Fell haben")), null
        )),

        Arguments
            .of(new Verb("sich weigern", "to refuse", "reddetmek;yapmamak istedigini belirtmek",
                null, Arrays.asList("Das Mädchen weigert sich Danke zu sagen"),
                Arrays.asList(new Tag("verb"), new Tag("reflexive")),
                Arrays.asList(new Verb("ablehnen"), new Verb("zusagen")), null, tenses))
    );
}
}
