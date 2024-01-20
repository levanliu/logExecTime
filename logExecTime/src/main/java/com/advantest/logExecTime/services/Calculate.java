package com.advantest.logExecTime.services;

import com.advantest.logExecTime.execTime.LogExecTime;
import com.advantest.logExecTime.jobs.AddJob;
import com.advantest.logExecTime.jobs.JobCompletionObserver;
import com.advantest.logExecTime.jobs.SubJob;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Calculate implements JobCompletionObserver {

    List<Integer> arrayList1 = new ArrayList<>();
    List<Integer> arrayList2 = new ArrayList<>();

    public Calculate(){
        //initialize arrayList.
        for(int i=0;i<100;i++)
        {
            arrayList1.add(i);
            arrayList2.add(2 * i);
        }
    }
    @LogExecTime
    public void addTwoArrayList() throws InterruptedException {
        for(int i=0;i<arrayList1.size();i++){
            AddJob addJob = new AddJob("Demo AddJob " + i, "addMethod" + i, this,arrayList1,arrayList2,i);
            addJob.schedule();
        }
        Thread.sleep(1000);
    }
    @LogExecTime
    public void subTwoArrayList(){
        for(int i=0;i<arrayList1.size();i++){
            SubJob subJob = new SubJob("Demo AddJob " + i, "addMethod" + i, this,arrayList1,arrayList2,i);
            subJob.schedule();
        }
    }

    @Override
    public void jobCompleted() {
    }

}
