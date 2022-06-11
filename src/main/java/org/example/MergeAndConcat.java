package org.example;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class MergeAndConcat {
  public static void main(String[] args) throws InterruptedException {

    Observable<String> src1 = Observable.just("Ella", "Alexa", "Lily");
    Observable<String> src2 = Observable.just("Priya", "Chloe", "1", "2","3","4");

    Observable.merge(src1, src2).subscribe(t -> System.out.println("merge: "+ t));

    Observable<String> src3 = Observable.just("Ella", "Alexa", "Lily");
    Observable<Integer> src4 = Observable.just(0,1,2,3);

    Observable.concat(src3, src4).subscribe(t -> System.out.println("concat: "+ t));


    /*
    Observable<String> src1 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src1: "+ e);
    Observable<String> src2 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src2: "+ e);

    // Observable.merge(src1, src2).subscribe(e ->System.out.println("received: " + e));
    Observable.concat(src1, src2).subscribe(e ->System.out.println("received: " + e));

    Thread.sleep(10000);

     */
  }
}
