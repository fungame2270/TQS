package com.ua.pt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyStackTest {
    MyStack<String> stack;

    @BeforeEach
    void setUp(){
        stack = new MyStack<>();
    }

    @DisplayName("Stack is empty")
    @Test
    void isEmpty(){
        // arrange
            //before eachtest a empty stack is created
        // act
            //nothing to do
        // assess
        assertTrue(stack.isEmpty());
    }

    @DisplayName("Stack size 0 at construction")
    @Test
    void sizeContruct(){
        //act
            //nothing to do
        //assess
        assertTrue(stack.size() == 0);
    }

    @DisplayName("After n pushes to an empty stack, n > 0, the stack is not empty and its size is n")
    @Test
    void afterNpushs_SizeisN(){
        //act
        stack.push("woof");
        stack.push("aro");
        stack.push("prego");
        //assess
        assertEquals(3,stack.size());
        assertFalse(stack.isEmpty());
    }

    @DisplayName("If one pushes x then pops, the value popped is x")
    @Test
    void afterPushX_popX(){
        //act
        stack.push("a");
        stack.push("b");
        //assess
        assertEquals("b", stack.pop());
        assertEquals("a", stack.pop());
    }

    @DisplayName("if one pushes x then peeks, the value returned is x, but the size stays the same")
    @Test
    void pushX_peekX(){
        //act
        stack.push("x");
        //assess
        assertEquals("x", stack.peek());
        assertEquals(1, stack.size());
    }

    @DisplayName("if the size is n, then after n pops, the stack is empty and has a size 0")
    @Test
    void Npops_empty(){
        //arrange
        int n = 5;
        for (int i = 0; i < n; i++) {
            stack.push("a");
        }
        //act
        for (int i = 0; i < n; i++)
            stack.pop();
        //assess
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @DisplayName("Popping from an empty stack does throw a NoSuchElementException [You should test for the Exception occurrence]")
    @Test
    void popEmptyStack(){
        assertThrows(NoSuchElementException.class, () -> stack.pop());
    }

    @DisplayName("Peeking into an empty stack does throw a NoSuchElementException")
    @Test
    void peekingEmptyStack(){
        assertThrows(NoSuchElementException.class, () -> stack.peek());
    }

    @DisplayName("pushing onto a full stack does throw an IllegalStateException")
    @Test
    void pushFullStack(){
        //arrange
        stack.setSize(2);
        //act
        stack.push("null");
        stack.push("EI");
        //assess
        assertThrows(IllegalStateException.class, ()-> stack.push("error"));

    }
}
