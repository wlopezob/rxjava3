package org.example;

import io.reactivex.rxjava3.core.Observable;

public class HelloRxJava {
  public static void main(String[] args) {
    Observable<String> source = Observable.create(e -> {
      e.onNext("Hello");
      e.onNext("RxJava");
    });
    source.subscribe(e -> System.out.println("Observer01:"+e));
    source.subscribe(e -> System.out.println("Observer02:"+e));
  }
}
