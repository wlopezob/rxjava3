package org.example;

import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Replaying {
  public static void main(String [] args) throws InterruptedException {
    Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS)
        .replay(2,4, TimeUnit.SECONDS)
        .autoConnect();

    src.subscribe(e -> System.out.println("Observer 1:" + e));
    Thread.sleep(5000);
    // el subscribe  2 se alinea al sb 1 y luego emiten los mismos valores
    src.subscribe(e -> System.out.println("Observer 2:" + e));
    Thread.sleep(3000);
  }
}
