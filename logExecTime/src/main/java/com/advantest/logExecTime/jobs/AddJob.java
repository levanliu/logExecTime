package com.advantest.logExecTime.jobs;

import org.apache.commons.lang3.time.StopWatch;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import java.util.List;

public class AddJob extends Job {
    private String methodName;
    private JobCompletionObserver observer;
    private StopWatch stopWatch;

    private List<Integer> arrayList1;
    private List<Integer> arrayList2;

    private final int index;
    public AddJob(String name, String methodName, JobCompletionObserver observer, List<Integer> arrayList1,
                  List<Integer> arrayList2, int index) {
        super(name);
        this.methodName = methodName;
        this.observer = observer;
        this.arrayList1 = arrayList1;
        this.arrayList2 = arrayList2;
        this.index = index;
    }

    @Override
    protected IStatus run(IProgressMonitor monitor) {
        // Create a StopWatch instance
        stopWatch = new StopWatch();
        stopWatch.start();

        // Simulate some work
        try {
            int sum = arrayList1.get(index)+arrayList2.get(index);
            arrayList1.set(index,sum);
            Thread.sleep(2000); // Sleep for 1.5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stopWatch.stop();

        if (observer != null) {
            observer.jobCompleted();
        }

        return Status.OK_STATUS;
    }
}
