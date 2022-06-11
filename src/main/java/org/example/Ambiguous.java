package org.example;

import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Ambiguous {
  public static void main(String[] args) throws InterruptedException {
    Observable<String> ob1 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "obs1: "+ e);
    Observable<String> ob2 = Observable.interval(10, TimeUnit.MILLISECONDS).map(e -> "obs2: "+ e);

    Observable.amb(Arrays.asList(ob1, ob2)).subscribe(System.out::println);

    Thread.sleep(10000);
  }
}
