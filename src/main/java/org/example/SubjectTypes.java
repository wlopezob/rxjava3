package org.example;

import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.subjects.UnicastSubject;

public class SubjectTypes {
  public static void main(String[] args) {
    // Emite(Publica) siempre el actual onnext en ambos observer
    //Subject<String> subject = PublishSubject.create();

    // Publica siempre el onnext desde un inicio en todos los observer
    //Subject<String> subject = ReplaySubject.create();

    // Publica siempre el onnext desde el ultimo emitido
    //Subject<String> subject = BehaviorSubject.create();

    // Publica solo el ultimo onnext en el observer encontrado hasta el oncomplete
    //Subject<String> subject = AsyncSubject.create();

    // Permite solo tener 01 observer(subscribe) caso contrario se genera una exception
    Subject<String> subject = UnicastSubject.create();

    subject.subscribe(e -> System.out.println("Subscriber 1:"+ e));
    subject.onNext("a");
    subject.onNext("b");
    subject.onNext("c");
    subject.subscribe(e -> System.out.println("Subscriber 2:"+ e));
    subject.onNext("d");
    subject.onNext("e");
    subject.onComplete();


  }
}
