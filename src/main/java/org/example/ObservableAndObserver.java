package org.example;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

public class ObservableAndObserver {
  public static void main(String[] args) {
    Observable<Integer> source = new ObservableCreate<Integer>(emitter -> {
      try {
        emitter.onNext(10);
        emitter.onNext(11);
        int a = 0;
        //emitter.onNext(20/a);
        emitter.onComplete();
      } catch (Throwable t) {
        emitter.onError(t);
      }
    });

    Observer<Integer> observer = new Observer<Integer>() {
      @Override
      public void onSubscribe(@NonNull Disposable d) {
        System.out.println("Subscribed");
      }

      @Override
      public void onNext(@NonNull Integer integer) {
        System.out.println("On Next: "+ integer);
      }

      @Override
      public void onError(@NonNull Throwable e) {
        e.printStackTrace();
      }

      @Override
      public void onComplete() {
        System.out.println("completed");
      }
    };

    source.subscribe(observer);

  }
}
