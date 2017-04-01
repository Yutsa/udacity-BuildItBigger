package com.jokegetter.tests;

import com.jokegetter.JokeGetter;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Édouard WILLISSECK
 */

public class TestJokeGetter {

    @Test
    public void testJokeNotEmpty() {
        JokeGetter jokeGetter = new JokeGetter();
        assertThat(jokeGetter.getJoke().isEmpty(), is(false));
    }
}
