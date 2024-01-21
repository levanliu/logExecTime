package com.advantest.logExecTime.jobs;

import org.apache.commons.lang3.time.StopWatch;
import org.eclipse.core.runtime.IProgressMonitor;

import java.util.List;

public class AddJob extends CalculateJob {
    private String methodName;
    private JobCompletionObserver observer;
    private StopWatch stopWatch;
    private final List<Integer> arrayList1;
    private final List<Integer> arrayList2;

    private final int index;
    public AddJob(String methodName, List<Integer> arrayList1,
                  List<Integer> arrayList2, int index) {
        super(methodName);
        this.methodName = methodName;
        this.arrayList1 = arrayList1;
        this.arrayList2 = arrayList2;
        this.index = index;
    }

    @Override
    protected void performRun(IProgressMonitor monitor) {
        int sum = arrayList1.get(index) + arrayList2.get(index);
        arrayList1.set(index,sum);
        System.out.println("AddJob executed at index: " + index);
    }

    @Override
    protected String getJobId() {
        return Thread.currentThread().getName();
    }

    @Override
    protected JobType getJobType() {
        return JobType.AddType;
    }
}
