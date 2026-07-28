package lk.susa.ee.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.*;
import lk.susa.ee.Task;

import java.io.Serializable;
import java.util.UUID;

import static java.awt.SystemColor.info;

@Stateless
public class TimerSessionBean {

    @Resource
    private TimerService timerService;

    public Task createTimer(){
        //timerService.createTimer(10000,5000L,"Test timer");

        TimerConfig timerConfig = new TimerConfig();

        String taskID = UUID.randomUUID().toString();
        Task task = new Task(taskID,"Simple Task");

        timerConfig.setInfo(task);
        timerConfig.setPersistent(true);

        ScheduleExpression se = new ScheduleExpression();
        se.hour("0");
        se.minute("0");
        se.second("0");

        timerService.createSingleActionTimer(10000L,timerConfig);
        return task;
    }

    @Timeout
    public void task(){
        System.out.println("Test Task task...");
    }

//    @Timeout
//    public void ejbTimeout(Timer timer){
//        System.out.println("Test Timer ejbTimeout:");
//
//    }

    public void cancelTimer(String taskId){
        timerService.getAllTimers().forEach((Timer timer)->{

            Serializable info = timer.getInfo();
            if(info instanceof  Task && ((Task) info).getTaskId().equals(taskId)){
                timer.cancel();
            }

        });
    }
}
