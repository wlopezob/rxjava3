package org.example;

import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import org.example.model.Employee;

public class OperationInAction {
  public static void main(String[] args) {
    Observable<Employee> obs = Observable.just(
      new Employee(1,"Alexa1", 6000d, 4.0),
        new Employee(2,"Alexa2", 6000d, 5.0),
        new Employee(3,"Alexa3", 6000d, 6.0),
        new Employee(4,"Alexa4", 6000d, 7.0),
        new Employee(5,"Alexa5", 6000d, 8.0)
    );

    obs.filter(e -> e.getRating() > 0)
        .sorted((e1, e2) -> Double.compare(e1.getRating(), e2.getRating()))
        .map(e -> e.getName())
        .take(4)
        .toList()
        .subscribe(System.out::println);

    List<Integer> expenses = List.of(200,300,400,500,600,700,800);
    Observable.fromIterable(expenses)
        //.scan((a,b)-> a+b)
        .reduce((a,b)-> a+b)
        .subscribe(System.out::println);
  }
}
