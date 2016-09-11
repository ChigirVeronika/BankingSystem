package by.bsuir.banking.controller.util;

import by.bsuir.banking.entity.Deposit;
import javafx.concurrent.Worker;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component("asyncWorker")
public abstract class AsyncWorker {

    @Async
    public Future<Deposit> work(Deposit deposit) {
        deposit.getStartDate();

//        DateTime dt1 = new DateTime(2000, 1, 1, 0, 0, 0, 0);
//        DateTime dt2 = new DateTime(2010, 1, 1, 0, 0, 0, 0);
//        int days = Days.daysBetween(dt1, dt2).getDays();
        // TODO: 9/11/2016  
        for (int i = 0; i < ; i++) {

        }
    }

    public void cancel() {
        Thread.currentThread().interrupt();
    }
}
