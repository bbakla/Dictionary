package com.dictionary.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import com.dictionary.service.Calculator;

public class Junit5Test {

  @ParameterizedTest
  @ValueSource(ints= {2, 4, 6})
  public void shouldNeEven(int num) {
    assertEquals(0, num % 2);
  }
  
  @ParameterizedTest(name= "{0} + {1} = {2}")
  @CsvSource({"2, 5, 7", "3, 6, 9", "5, 34, 39"})
  public void add(int operand1, int operand2, int expected) {
    assertEquals(expected, new Calculator().add(operand1, operand2));
  }
  
  @ParameterizedTest(name="{index} => calculate({0}) should return {1}")
 @MethodSource("fizzBuzz")
  public void fizz(int number, int expectedResult) {
    Calculator computer = new Calculator();
    
    assertThat(computer.calculate(number)).isEqualByComparingTo(expectedResult);
  }
  
  
  
  private static Stream<Arguments> fizzBuzz() {
    return Stream.of(
        Arguments.of(2, 0),
        Arguments.of(15, 3),
        Arguments.of(10, 2),
        Arguments.of(6, 1)
        );
  }
}
