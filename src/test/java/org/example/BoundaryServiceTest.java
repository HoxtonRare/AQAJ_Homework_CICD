package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BoundaryServiceTest {
    BoundaryService boundaryService = new BoundaryService();

    static Stream<Arguments> testValues() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(new int[]{1, 2, 3, 4, 5}, 1),
                org.junit.jupiter.params.provider.Arguments.of(new int[]{10, 9, 8, 7, 6}, 6),
                org.junit.jupiter.params.provider.Arguments.of(new int[]{5, 5, 1, 4, 0, 2, 21}, 0),
                org.junit.jupiter.params.provider.Arguments.of(new int[]{-1, -2, -3, -4, -5}, -5),
                org.junit.jupiter.params.provider.Arguments.of(new int[]{0}, 0),
                org.junit.jupiter.params.provider.Arguments.of(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}, Integer.MIN_VALUE)
        );
    }

    @ParameterizedTest(name = "{index} => marks={0}, expectedMin={1}")
    @MethodSource("testValues")
    void testSearchForMinMark(int[] marks, int exp) {
        assertEquals(exp, boundaryService.findMin(marks));
    }

    void testToFailed() {
        fail("Вызов ошибочного теста");
    }
}