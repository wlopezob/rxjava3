package org.example;

import io.reactivex.rxjava3.core.Observable;
import java.util.List;

public class CreatingObservable {
  public static void main(String[] args) {
    //create
    Observable<Integer> obs = Observable.create(e -> {
      e.onNext(10);
      e.onNext(11);
      e.onComplete();
    });
    obs.subscribe(System.out::println);

    //just
    Observable just = Observable.just(1,2,3,4,5);
    just.subscribe(System.out::println);

    //fromIterable
    List<String> list = List.of("Hello", "william", "now");
    Observable iterable = Observable.fromIterable(list);
    iterable.subscribe(System.out::println);

  }
}
