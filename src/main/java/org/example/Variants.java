package org.example;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

public class Variants {
  public static void main(String[] args){
    Observable source = Observable.just("William", "Jose", "Katty");
    Observable source1 = Observable.empty();

    source.first("default")
        .subscribe(System.out::println);

    source1.firstElement()
        .subscribe(System.out::println,
            e -> System.out.println(e),
            () -> System.out.println("Completed")
        );

    Completable completable = Completable.complete();
    completable.subscribe(() -> System.out.println("Completed"));

    Completable.fromRunnable(() -> System.out.println("Some process executing "))
        .subscribe(() -> System.out.println("completed"));
  }
}
