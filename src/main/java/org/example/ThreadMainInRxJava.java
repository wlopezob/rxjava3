package org.example;

import io.reactivex.rxjava3.core.Observable;

public class ThreadMainInRxJava {
  public static void main(String[] args) {
    Observable<String> source = Observable.create(e -> {
      e.onNext("Hello");
      e.onNext("RxJava");
      e.onComplete();
    });

    source.subscribe(e -> System.out.println("Observer 1: "+ e +", Thread is:"+ Thread.currentThread().getName()));
    source.subscribe(e -> System.out.println("Observer 2: "+ e +", Thread is:"+ Thread.currentThread().getName()));
  }
}
