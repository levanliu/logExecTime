package com.advantest.logExecTime.jobs;

import java.util.ArrayList;
import java.util.List;

public class JobSubject {
    private List<JobCompletionObserver> observers = new ArrayList<>();

    public void registerObserver(JobCompletionObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(JobCompletionObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (JobCompletionObserver observer : observers) {
            observer.jobCompleted();
        }
    }
}
