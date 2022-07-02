package org.example;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class Subjects {
  public static void main(String[] args) throws InterruptedException {
    Observable<Integer> src1 = Observable.just(5,10,15,20)
        .subscribeOn(Schedulers.io());
    Observable<Integer> src2 = Observable.just(5,10,15,20)
        .subscribeOn(Schedulers.io());

    Subject<Object> subject = PublishSubject.create();
    subject.subscribe(e -> System.out.println(e));
    subject.subscribe(e -> System.out.println("the element is: " +e));
    src1.subscribe(subject);
    src2.subscribe(subject);
    Thread.sleep(9000);
  }
}
