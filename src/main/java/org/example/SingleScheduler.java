package org.example;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SingleScheduler {
  public static void main(String[] args) throws InterruptedException {
    //Crea y ejecuta todo en un solo hilo
    Observable<String> src = Observable.just("Pasta","Pizza", "Fries", "Curry", "Chow mein")
        .subscribeOn(Schedulers.single());
    src.subscribe(e -> compute(e));
    Thread.sleep(6000);
    src.subscribe(e -> compute(e));
    src.subscribe(e -> compute(e));
    src.subscribe(e -> compute(e));
    src.subscribe(e -> compute(e));
    src.subscribe(e -> compute(e));
    src.subscribe(e -> compute(e));
    Thread.sleep(5000);
  }

  public static void compute(String data) throws InterruptedException{
    Thread.sleep(1000);
    System.out.println(data+", Computation Done By:"+ Thread.currentThread().getName()+", fecha: "+fecha());
  }

  public static String fecha() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    return dtf.format(now);
  }
}
