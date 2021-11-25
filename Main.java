package myprogram;

import myprogram.circle.Circle;
import myprogram.linkedlist.MyLinkedList;
import myprogram.test.TestClass;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Circle> circles = new MyLinkedList<Circle>();
        circles.add(new Circle(1,"red"));
        Circle c = new Circle(2,"green");
        circles.add(c);
        circles.add(new Circle(3,"yellow"));
        circles.add(new Circle(4,"pink"));
        System.out.println("size = " + circles.size());
        circles.add(2,new Circle(3, "violet"));
        System.out.println(circles.toString());
        //circles.clear();
        //System.out.println(circles.toString());
        //System.out.println(circles.get(1).toString());
        //System.out.println(circles.indexOf(c));
        //Circle remove = circles.remove(2);
        //System.out.println(circles.toString());
        //Circle altered = circles.set(2,new Circle(0,"silver"));
        //System.out.println(circles.get(1).toString());
        MyLinkedList<Integer> integers = new MyLinkedList<Integer>();
        integers.add(0);
        integers.add(1);
        integers.add(2);
        Object[] obj = integers.toArray();
        for (int i=0;i<obj.length;i++){
            System.out.print(obj[i]);
        }
        System.out.println();
        Integer[] integers1 = integers.toArray(new Integer[integers.size()]);
        for (int i=0;i<obj.length;i++){
            System.out.print(obj[i]);
        }
        System.out.println();

        MyLinkedList.MyIterator it = circles.iterator();
        System.out.println("Linkedlist: ");
        while (it.hasNext()){
            System.out.println(it.next());
        }

        //Add
        System.out.println("======Add=======");
        MyLinkedList<Circle> circles1 = new MyLinkedList<Circle>();
        long startTimeAdd = System.nanoTime();
        for (int i =0;i<10000;i++){
            circles1.add(new Circle(1,"red"));
        }
        long endTimeAdd = System.nanoTime()-startTimeAdd;
        System.out.println("MLL " + endTimeAdd);

        LinkedList<Circle> circles2 = new LinkedList<Circle>();
        startTimeAdd = System.nanoTime();
        for (int i =0;i<10000;i++){
            circles2.add(new Circle(1,"red"));
        }
        endTimeAdd = System.nanoTime()-startTimeAdd;
        System.out.println("LL " +endTimeAdd);

        //Remove
        System.out.println("=====Remove=====");
        long startTimeRemove = System.nanoTime();
        circles1.remove(1);
        long endTimeRemove = System.nanoTime()-startTimeAdd;
        System.out.println("MLL "+endTimeAdd);

        startTimeRemove = System.nanoTime();
        circles2.remove(1);
        endTimeRemove = System.nanoTime()-startTimeAdd;
        System.out.println("LL "+endTimeAdd);

        //Search
        System.out.println("=====Search=====");
        long startTimeSearch = System.nanoTime();
        Circle c1 = circles1.get(100);
        long endTimeSearch = System.nanoTime()-startTimeAdd;
        System.out.println("MLL "+endTimeAdd);

        startTimeSearch = System.nanoTime();
        Circle c2 = circles2.get(100);
        endTimeSearch = System.nanoTime()-startTimeAdd;
        System.out.println("LL "+endTimeAdd);

        //Ex 2

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        TestClass<Integer> testClass = new TestClass<>();
        System.out.println("ArrayList_Add_Time = "+ testClass.timeAdd(arrayList,10000,12));
        System.out.println("ArrayList_RemoveAll_Time = "+ testClass.timeRemoveAll(arrayList));
        System.out.println("LinkedList_Add_Time = "+ testClass.timeAdd(linkedList,10000,12));
        System.out.println("LinkedList_RemoveAll_Time = "+ testClass.timeRemoveAll(linkedList));

        System.out.println();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>();
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        System.out.println("HashSet_Add_Time = "+testClass.timeAdd(hashSet,10000,12));
        System.out.println("HashSet_RemoveAll_Time = "+testClass.timeRemoveAll(hashSet));
        System.out.println("LinkedHashSet_Add_Time = "+testClass.timeAdd(linkedHashSet,10000,12));
        System.out.println("LinkedHashSet_RemoveAll_Time = "+testClass.timeRemoveAll(linkedHashSet));
        System.out.println("TreeSet_Add_Time = "+testClass.timeAdd(treeSet,10000,12));
        System.out.println("TreeSet_RemoveAll_Time = "+testClass.timeRemoveAll(treeSet));

        System.out.println();
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap<Integer,Integer>();
        TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
        System.out.println("HashMap_Add_Time = "+testClass.timeAdd(hashMap,10000,1,2));
        System.out.println("HashMap_RemoveAll_Time = "+testClass.timeRemoveAll(hashMap));
        System.out.println("LinkedHashMap_Add_Time = "+testClass.timeAdd(linkedHashMap,10000,1,2));
        System.out.println("LinkedHashMap_RemoveAll_Time = "+testClass.timeRemoveAll(linkedHashMap));
        System.out.println("TreeMap_Add_Time = "+testClass.timeAdd(treeMap,10000,1,2));
        System.out.println("TreeMap_RemoveAll_Time = "+testClass.timeRemoveAll(treeMap));
    }


}


