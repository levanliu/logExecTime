package com.advantest.logExecTime.jobs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

public abstract class CalculateJob extends Job {

    private JobCompletionObserver observer;

    private JobManager jobManager;
    public CalculateJob(String name) {
        super(name);
    }

    protected abstract void performRun(IProgressMonitor monitor);

    protected abstract String getJobId();

    protected abstract JobType getJobType();
    @Override
    final protected IStatus run(IProgressMonitor monitor) {
        // Simulate some work
        try {
            jobManager.jobStarted(getJobId(),getJobType());
            performRun(monitor);
            Thread.sleep(500); // Sleep for 1.5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            jobManager.jobFinished(getJobId(),getJobType());
        }

        if (observer != null) {
            observer.jobCompleted();
        }

        return Status.OK_STATUS;
    }

}
