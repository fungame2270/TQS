package com.ua.pt;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyStack<T> {
    private LinkedList<T> array = new LinkedList<T>();
    Integer mSize = null;

    public MyStack(){}

    public void push(T x){
        if(this.mSize != null && array.size() >= this.mSize){
            throw(new IllegalStateException());
        }
        array.push(x);
    }

    public T pop(){
        if (array.isEmpty()){
            throw new NoSuchElementException();
        }
        return array.pop();
    }

    public T peek(){
        if (array.isEmpty()){
            throw new NoSuchElementException();
        }
       return array.peek();
    }

    public int size(){
        return array.size();
    }

    public boolean isEmpty(){
        return array.isEmpty();
    }

    public void setSize(Integer size){
        this.mSize = size;
    }
}
