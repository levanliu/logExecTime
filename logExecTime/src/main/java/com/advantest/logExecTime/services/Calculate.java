package com.advantest.logExecTime.services;

import com.advantest.logExecTime.execTime.LogExecTime;
import com.advantest.logExecTime.jobs.AddJob;
import com.advantest.logExecTime.jobs.CalculateJob;
import com.advantest.logExecTime.jobs.JobCompletionObserver;
import com.advantest.logExecTime.jobs.SubJob;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class Calculate implements JobCompletionObserver {

    private final List<Integer> arrayList1 = new ArrayList<>();
    private final List<Integer> arrayList2 = new ArrayList<>();

    public Calculate() {
        // Initialize arrayList.
        for (int i = 0; i < 100; i++) {
            arrayList1.add(i);
            arrayList2.add(2 * i);
        }
    }

    @LogExecTime
    public void addTwoArrayList() throws InterruptedException {


        for (int i = 0; i < arrayList1.size(); i++) {
            CalculateJob addJob = new AddJob("Demo AddJob " + i, arrayList1, arrayList2, i);
            addJob.schedule();
            addJob.join();
        }

    }

    @LogExecTime
    public void subTwoArrayList() throws InterruptedException {


        for (int i = 0; i < arrayList1.size(); i++) {
            CalculateJob subJob = new SubJob("Demo SubJob " + i, arrayList1, arrayList2, i);
            subJob.schedule();
            subJob.join();
        }


    }

    @Override
    public void jobCompleted() {
        // Handle job completion if needed
    }
}
