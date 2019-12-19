package com.learning.functionalprogramminggradle.LambdaFunctions;

/*@FunctionalInterface
interface Assistant<T>{

    public void takeNote(T input);

    public static void check(){
        System.out.println("Yes...");
    }

    default void respond(){
        System.out.println("responding ...");
    }

}*/

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

@FunctionalInterface
interface Bool extends BiFunction<Bool, Bool, Bool> {

    default Bool and(Bool other) {
        return apply(other,this);
    }

    default Bool or(Bool other){
        return apply(this,other);
    }

    default Bool not(){
        return apply(False, True);
    }

    public static Bool True = new Bool(){

        public Bool apply(Bool leftOperand, Bool rightOperand){
            return leftOperand;
        };

        public String toString(){
            return "True";
        }
    };

   public static Bool False = new Bool(){

        List list = new ArrayList();

        public Bool apply(Bool leftOperand, Bool rightOperand){
            return rightOperand;
        }

        public String toString(){
            return "False";
        }

    };
}


/*@FunctionalInterface
interface Merger<A,B, C, R>{
    public R merge(A first,B second,C third);
}

@FunctionalInterface
interface  Sortable<I,C,R>{
    public R sort(I i, C c);
}*/


class FPWorkshop {

    public static void main(String[] args) {

        Bool True1 = Bool.True;
        System.out.println(True1.toString());
        Bool False1= Bool.False;
        System.out.println(False1.toString());

        System.out.println("True.choose(\"input\",\"input2\") = " + True1.apply(True1,False1));
        System.out.println("False.choose(\"input\",\"input2\") = " + False1.apply(True1,False1));


        System.out.println("AND");
        System.out.println(False1.and(False1));
        System.out.println(True1.and(False1));
        System.out.println(False1.and(True1));
        System.out.println(True1.and(True1));

       /* T T -> T
        T F -> T
        F T -> T
        F F -> F*/
        System.out.println("OR");
        System.out.println(False1.or(False1));
        System.out.println(True1.or(False1));
        System.out.println(False1.or(True1));
        System.out.println(True1.or(True1));

        System.out.println("NOT");
        System.out.println(False1.not());
        System.out.println(True1.not());

       /* System.out.println("init >>");
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
            }s
        }));*/

        System.out.println("Completed");
    }

}