package ru.parsentev.task_018;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */

public class PoolTest {
    @Test
    public void multi() {
        Pool pool = new Pool(
                new int[][] {
                        {1, 0, 0},
                        {1, 1, 0},
                        {0, 0, 1}
                }
        );
        int result = pool.maxUnion();
        assertThat(result, is(3));
    }

    @Test
    public void one() {
        Pool pool = new Pool(
                new int[][] {
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1}
                }
        );
        int result = pool.maxUnion();
        assertThat(result, is(9));
    }

    @Test
    public void four_1() {
        Pool pool = new Pool(
                new int[][] {
                        {1, 1, 0},
                        {1, 1, 0},
                        {0, 0, 1}
                }
        );
        int result = pool.maxUnion();
        assertThat(result, is(4));
    }

    @Test
    public void four_2() {
        Pool pool = new Pool(
                new int[][] {
                        {0, 0, 0},
                        {0, 1, 1},
                        {0, 1, 1}
                }
        );
        int result = pool.maxUnion();
        assertThat(result, is(4));
    }

    @Test
    public void eight() {
        Pool pool = new Pool(
                new int[][] {
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 1, 1}
                }
        );
        int result = pool.maxUnion();
        assertThat(result, is(8));
    }

    @Test
    public void seven() {
        Pool pool = new Pool(
                new int[][] {
                        {0, 1, 1},
                        {1, 0, 1},
                        {1, 1, 1}
                }
        );
        int result = pool.maxUnion();
        assertThat(result, is(7));
    }
}