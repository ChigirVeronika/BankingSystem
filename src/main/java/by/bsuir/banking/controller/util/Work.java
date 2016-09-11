package by.bsuir.banking.controller.util;

import java.util.concurrent.Future;

public interface Work {
    Future<Work> work();

    void cancel();
}
