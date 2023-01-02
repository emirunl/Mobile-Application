package com.example.getpet;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void itemCount_isCorrect(){
        Animal animal = new Animal();
        List<Animal> animalList = Arrays.asList(animal,animal,animal);
        MyAdapter adapter = new MyAdapter(animalList);
        assertEquals(3,adapter.getItemCount());
    }
}