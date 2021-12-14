package testing.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;

@SpringBootTest
class DemoApplicationTests {

  @Autowired
  testService testService;

  @Test
  void normalCase() throws InterruptedException {
    testService.printAction(0);
  }


  @Test
  void normalCaseAsync() throws InterruptedException {
    testService.printActionAsync(0);
  }


  @Test
  void getTextCompletableFutureTest_using_allOf() throws InterruptedException, ExecutionException {
    long start = System.currentTimeMillis();
    CompletableFuture<String> task_1 = testService.getTextCompletableFuture(1);
    CompletableFuture<String> task_2 = testService.getTextCompletableFuture(2);
    CompletableFuture<String> task_3 = testService.getTextCompletableFuture(3);

    CompletableFuture.allOf(task_1, task_2, task_3).join();

    System.out.println(("Elapsed time: " + (System.currentTimeMillis() - start)));
    System.out.println("--> " + task_1.get());
    System.out.println("--> " + task_2.get());
    System.out.println("--> " + task_3.get());
  }


  @Test
  void getTextCompletableFutureTest_normal() throws InterruptedException, ExecutionException {
    long start = System.currentTimeMillis();
    CompletableFuture<String> task_1 = testService.getTextCompletableFuture(1);
    CompletableFuture<String> task_2 = testService.getTextCompletableFuture(2);
    CompletableFuture<String> task_3 = testService.getTextCompletableFuture(3);

    task_1.join();
    task_2.join();
    task_3.join();

    System.out.println(("Elapsed time: " + (System.currentTimeMillis() - start)));
    System.out.println("--> " + task_1.get());
    System.out.println("--> " + task_2.get());
    System.out.println("--> " + task_3.get());
  }


  @Test
  void getTextFutureTest() throws InterruptedException, ExecutionException {

    long start = System.currentTimeMillis();
    Future<String> future = testService.getTextFuture(1);
    while (!future.isDone()) {
      if (future.isDone()) {
        System.out.println(("Elapsed time: " + (System.currentTimeMillis() - start)));
        System.out.println("--> " + future.get());
      }
    }
  }


  @Test
  void getTextFutureTest_bulk() throws InterruptedException, ExecutionException {

    long start = System.currentTimeMillis();
    List<Future<String>> futures = new ArrayList<>();
    for (int i = 1; i <= 8; i++) {
      Future<String> future = testService.getTextFuture(i,1000);
      futures.add(future);
    }

    List<String> response = new ArrayList<>();
    for (Future future : futures)
      response.add((String) future.get());

    System.out.println(("Elapsed time: " + (System.currentTimeMillis() - start)));
    for (String text : response){
      System.out.println(text);
    }
  }


  @Test
  void getTextAsyncTest_failed() throws InterruptedException {
    String result = testService.getTextAsync(1);
    System.out.println(result);
  }


  @Test
  void multiTask_failed() {
    // Arrange
    int maxNumber = 10;

    // Act
    IntStream.range(0, maxNumber).forEach(x -> {
      testService.printAction(x);
    });
  }

}
