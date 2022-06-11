package org.example;

import io.reactivex.rxjava3.core.Observable;
import org.example.model.Employee;

public class GroupBy {
  public static void main(String[] args) {
    Observable<Employee> obs = Observable.just(
        new Employee(1,"Alexa1", 6000d, 4.0),
        new Employee(2,"Alexa2", 6000d, 4.0),
        new Employee(3,"Alexa3", 6000d, 4.0),
        new Employee(4,"Alexa4", 6000d, 7.0),
        new Employee(5,"Alexa5", 6000d, 8.0)
    );

    obs.groupBy(e -> e.getRating())
        .flatMapSingle(e -> e.toList())
        .doOnNext(l -> System.out.println(l.size()))
        .subscribe(System.out::println);

  }
}
