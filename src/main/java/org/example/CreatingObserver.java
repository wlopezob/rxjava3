package org.example;

import io.reactivex.rxjava3.core.Observable;

public class CreatingObserver {
  public static void main(String[] args) {
    Observable obs = Observable.just("Orange", "Black", "Red");
    obs.subscribe(e -> System.out.println(e),
        r -> System.out.println(r),
        () -> System.out.println("Completed"));
  }
}
