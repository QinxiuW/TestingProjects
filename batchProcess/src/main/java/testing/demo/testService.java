package testing.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;


@Component
public class testService {


  @Async
  public void printActionAsync(int number) throws InterruptedException {
    Thread.sleep(1000);
    System.out.println("hello  " + number + " ," + Thread.currentThread().getName());
  }

  @Async
  public String getTextAsync(int number) throws InterruptedException {
    Thread.sleep(1000);
    return "hello  " + number + " ," + Thread.currentThread().getName();
  }

  @Async
  public String getTextAsync(int number,int temps) throws InterruptedException {
    Thread.sleep(temps);
    return "hello  " + number + " ," + Thread.currentThread().getName();
  }

  @Async
  public CompletableFuture<String> getTextCompletableFuture(int number)
      throws InterruptedException {
    Thread.sleep(4000);
    return CompletableFuture
        .completedFuture("hello - " + number + ", " + Thread.currentThread().getName());
  }

  @Async
  public Future<String> getTextFuture(int number) throws InterruptedException {
    Thread.sleep(1000);
    return new AsyncResult<String>("hello - " + number + ", " + Thread.currentThread().getName());
  }

  @Async
  public Future<String> getTextFuture(int number,int temps) throws InterruptedException {
    Thread.sleep(temps);
    return new AsyncResult<String>("hello - " + number + ", " + Thread.currentThread().getName());
  }

  public void printAction(int number) {
    System.out.println("hello  " + number);
  }
}
