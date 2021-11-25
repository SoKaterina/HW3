package myprogram.test;

import java.util.Collection;
import java.util.Map;

public class TestClass<E> {
    private long startTime;
    private long endTime;

    public TestClass(){}

    public long timeAdd(Collection<E> a,int count,E element){
        startTime = System.nanoTime();
        for(int i = 0;i<count;i++){
           a.add(element);
        }
        endTime = System.nanoTime()-startTime;
        return endTime;
    }

    public long timeRemoveAll(Collection<E> a){
        startTime = System.nanoTime();
        a.removeAll(a);
        endTime = System.nanoTime()-startTime;
        return endTime;
    }

    public long timeAdd(Map<E, E> a, int count,E el1, E el2){
        startTime = System.nanoTime();
        for(int i = 0;i<count;i++){
            a.put(el1,el2);
        }
        endTime = System.nanoTime()-startTime;
        return endTime;
    }

    public long timeRemoveAll(Map<E, E> a){
        startTime = System.nanoTime();
        a.clear();
        endTime = System.nanoTime()-startTime;
        return endTime;
    }
}
