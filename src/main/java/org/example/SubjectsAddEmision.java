package org.example;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class SubjectsAddEmision {
  public static void main(String[] args) {
    PublishSubject<String> subject = PublishSubject.create();
    Subject<String> serialized = subject.toSerialized();

    serialized.subscribe(System.out::println);
    serialized.subscribe(e -> System.out.println("Observer2: "+ e));

    serialized.onNext("Hello");
    serialized.onNext("Basic");
    serialized.onComplete();
    serialized.onNext("Compete");
  }
}
