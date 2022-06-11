package org.example;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class ZipAndCombinateLatest {
  public static void main(String[] args) throws InterruptedException {

    // tiene que emitir ambos para que se lance la funcion zip

    /*
    Observable<Long> src1 = Observable.interval(100, TimeUnit.MILLISECONDS);
    Observable<Long> src2 = Observable.interval(1, TimeUnit.SECONDS);
    Observable.zip(src1, src2, (ob1, ob2) -> "Source1: "+ ob1 +" , Source2:"+ ob2)
        .subscribe(System.out::println);
     */

    // tiene que emitir ambos, pero siempre combina con el ultimo emitido en caso que uno de ellos emita primero
    Observable<Long> src1 = Observable.interval(100, TimeUnit.MILLISECONDS);
    Observable<Long> src2 = Observable.interval(1, TimeUnit.SECONDS);
    Observable.combineLatest(src1, src2, (ob1, ob2) -> "Source1: "+ ob1 +" , Source2:"+ ob2)
        .subscribe(System.out::println);

    Thread.sleep(20000);
  }
}
