package org.example;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.TimeUnit;

public class Disposing {
  public static void main(String[] args) throws InterruptedException {
    Observable src = Observable.interval(1, TimeUnit.SECONDS);

    Disposable d = src.subscribe(e -> System.out.println("Observer 1: "+ e));
    Thread.sleep(5000);
    d.dispose();

    src.subscribe(e -> System.out.println("Observer 2: "+ e));

    Thread.sleep(10000);
  }
}
