package org.example.lesson3;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Lesson3Test {

    private static Lesson3Func func;

    @BeforeAll
    static void before(){
        func = new Lesson3Func();
    }

    @DisplayName("Основные проверки")
    @ParameterizedTest(name = "{index}- {0} это полиндром? ожидаем: {1}")
    @MethodSource("testData")
    void baseTest(String str, boolean exp){
        assertThat(func.isPalindrome(str)).isEqualTo(exp);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("A roza upala na Lapu Azora", true),
                Arguments.of("abba", true),
                Arguments.of("aba", true),
                Arguments.of("a  aab a aa", true),
                Arguments.of("a  aab a a", false),
                Arguments.of("abbc", false),
                Arguments.of("Ab B a", true),
                Arguments.of("Ab bB a", true),
                Arguments.of("22 02 2022", true),
                Arguments.of("!И мал Иван а лупил у лип улана вилами!", true),
                Arguments.of("_!@#$%^&*()/ /)(*&^%$#@!_" , true),
                Arguments.of("a", true)
        );
    }
    @Test
    @DisplayName("Пустая строка или null")
    void nullTest() {
        assertThatThrownBy(() -> func.isPalindrome(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Строка не должна быть пустой");

        assertThatThrownBy(() -> func.isPalindrome(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Строка не должна быть пустой");
    }
}
