package org.example.lesson3;

public class Lesson3Func {

    public boolean isPalindrome(String text) {
        if (text == null || text.length() == 0) {
            throw new IllegalArgumentException("Строка не должна быть пустой");
        }
        return text.replaceAll("\\W", "")
                .equalsIgnoreCase(new StringBuilder(text.replaceAll("\\W", ""))
                .reverse().toString());

    }
}
