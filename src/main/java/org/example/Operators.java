package org.example;

import io.reactivex.rxjava3.core.Observable;
import java.util.function.Predicate;

public class Operators {
  public static void main(String[] args){
    Predicate<Integer> test = t -> t > 3;

    Observable.just(1,2,3,4,5,6,7,8,9,0)
        .filter(test::test)
        .sorted()
        .subscribe(System.out::println);
  }
}
