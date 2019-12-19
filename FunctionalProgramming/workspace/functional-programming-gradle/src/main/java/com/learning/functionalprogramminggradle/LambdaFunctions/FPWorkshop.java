package com.learning.functionalprogramminggradle.LambdaFunctions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

@FunctionalInterface
interface Assistant<T>{

    public void takeNote(T input);

    public static void check(){
        System.out.println("Yes...");
    }

    default void respond(){
        System.out.println("responding ...");
    }

}

interface Bool {
    Object choose(Object input1, Object input2);

    Bool and(Bool input);
}

class True implements Bool{

    public Object choose(Object input1, Object input2){
        return input1;
    }

    public Bool and(Bool input) {

        if (getClass().isInstance(input)) {
            return this;
        }else{
            return input;
        }
    }

    public String toString(){
        return "True";
    }
}


class False implements Bool{

    public Object choose(Object input1, Object input2){
        return input2;
    }

    public String toString(){
        return "False";
    }

    public Bool and(Bool input){
        return this;

        //return False.class.isInstance(input);
        //return "False";
    }
}



/*
@FunctionalInterface
interface Merger<A,B, C, R>{
    public R merge(A first,B second,C third);
}

@FunctionalInterface
interface  Sortable<I,C,R>{
    public R sort(I i, C c);
}
*/

class FPWorkshop {

    public static void main(String[] args) {

        Bool True = new True();
        System.out.println(True.toString());
        Bool False= new False();
        System.out.println(False.toString());

        System.out.println(False.and(False));
        System.out.println(True.and(False));
        System.out.println(False.and(True));
        System.out.println(True.and(True));
        /*
        System.out.println("init >>");
        Function<Integer, Integer> increment = x -> x + 247;
        System.out.println("increment.apply(5) = " + increment.apply(5));
        
        BiFunction<Integer,Integer,Integer> add = (input1,input2)-> input1+input2;
        System.out.println("add.apply(24,7) = " + add.apply(24,7));

        Consumer<String> blackHole = x -> System.out.println("x = " + x);
        blackHole.accept("Invoking Consumer");

        Supplier<String> mother = () -> "Always Provides";
        System.out.println("mother.get() = " + mother.get());

        Predicate<Integer> isEven = x -> x%2 == 0;
        System.out.println("isEven.test(2) = " + isEven.test(2));
        System.out.println("isEven.test(2) = " + isEven.test(4));
        System.out.println("isEven.test(2) = " + isEven.test(7));

        Assistant<String> lynda = note-> System.out.println("lynda noted .. " + note);
        lynda.takeNote("I'm in FP Session ");
        lynda.respond();
        Assistant.check();

        Merger<Integer,String, Double, String> merger = (first,second,third)-> { return  first + second + third; };
        System.out.println("merger = " + merger.merge(123,"OneTwoThree", 123.0));

        BiFunction<List<Integer>, Comparator, List<Integer> > sortable = (input, comparator) ->{
            Collections.sort(input,comparator);
        return input;};

        List<Integer> inputList = new ArrayList<>();
        inputList.add(3);
        inputList.add(2);inputList.add(6);inputList.add(1);inputList.add(4);inputList.add(5);


        System.out.println("sortable.sort() = " + sortable.apply(inputList, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1 - i2;
            }
        }));

        System.out.println("Completed");
*/
    }

}