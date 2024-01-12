import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TriFusionTest {

    TriFusion triFusion;

    @BeforeEach
    void setUp() {
        triFusion = new TriFusion();
    }

    @Test
    void enter0ShouldReturn0() {
        assertArrayEquals(new Integer[]{0}, triFusion.sort(0));
    }

    @Test
    void enter1ShouldReturn1() {
        assertArrayEquals(new Integer[]{1}, triFusion.sort(1));
    }

    @Test
    void enter0And1ShouldReturn0And1() {
        assertArrayEquals(new Integer[]{0, 1}, triFusion.sort(0, 1));
    }

    @Test
    void enter1And0ShouldReturn0And1() {
        assertArrayEquals(new Integer[]{0, 1}, triFusion.sort(1, 0));
    }

    @Test
    void enter2And1ShouldReturn1And2() {
        assertArrayEquals(new Integer[]{1, 2}, triFusion.sort(2, 1));
    }

    @Test
    void enter1And2ShouldReturn1And2() {
        assertArrayEquals(new Integer[]{1, 2}, triFusion.sort(1, 2));
    }

    @Test
    void enter0And0ShouldReturn0And0() {
        assertArrayEquals(new Integer[]{0, 0}, triFusion.sort(0, 0));
    }

    @Test
    void enter2And8ShouldReturn2And8() {
        assertArrayEquals(new Integer[]{2, 8}, triFusion.sort(2, 8));
    }

    @Test
    void enter8And2ShouldReturn2And8() {
        assertArrayEquals(new Integer[]{2, 8}, triFusion.sort(8, 2));
    }

    @Test
    void enter0And1And2ShouldReturn0And1And2() {
        assertArrayEquals(new Integer[]{0, 1, 2}, triFusion.sort(0, 1, 2));
    }

    @Test
    void enter1And2And3ShouldReturn1And2And3() {
        assertArrayEquals(new Integer[]{1, 2, 3}, triFusion.sort(1, 2, 3));
    }

    @Test
    void enter3And2And1ShouldReturn1And2And3() {
        assertArrayEquals(new Integer[]{1, 2, 3}, triFusion.sort(3, 2, 1));
    }

    @Test
    void enter2And1And3ShouldReturn1And2And3() {
        assertArrayEquals(new Integer[]{1, 2, 3}, triFusion.sort(2, 1, 3));
    }

    @Test
    void enter2And3And1ShouldReturn1And2And3() {
        assertArrayEquals(new Integer[]{1, 2, 3}, triFusion.sort(2, 3, 1));
    }

    @Test
    void enter3And1And2ShouldReturn1And2And3() {
        assertArrayEquals(new Integer[]{1, 2, 3}, triFusion.sort(3, 1, 2));
    }

    @Test
    void enter3And2And1And4ShouldReturn1And2And3And4() {
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, triFusion.sort(3, 2, 1, 4));
    }

    @Test
    void enter3And2And1And4And5ShouldReturn1And2And3And4And5() {
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, triFusion.sort(3, 2, 1, 4, 5));
    }

    @Test
    void enter3And2And1And4And5And6ShouldReturn1And2And3And4And5And6() {
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, triFusion.sort(3, 2, 1, 4, 5, 6));
    }

    @Test
    void testWithRandomNumbers() {
        assertArrayEquals(new Integer[]{1, 1, 2, 2, 2, 2, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 7, 8, 17, 33, 33, 48, 52, 55, 55, 58, 58, 66, 88, 89, 668}, triFusion.sort(58, 58, 4, 2, 1, 5, 6, 5, 88, 5, 4, 2, 33, 6, 5, 8, 7, 4, 5, 1, 2, 33, 6, 55, 6, 89, 5, 66, 48, 52, 17, 5, 668, 2, 55));
    }
}