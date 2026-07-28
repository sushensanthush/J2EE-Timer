package lk.susa.ee.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.*;
import lk.susa.ee.Task;

import java.util.UUID;

@Stateless
public class TimerSessionBean {

    @Resource
    private TimerService timerService;

    public void createTimer(){
        //timerService.createTimer(10000,5000L,"Test timer");

        TimerConfig timerConfig = new TimerConfig();

        String taskID = UUID.randomUUID().toString();

        Task task = new Task(taskID,"Simple Task");

        timerConfig.setInfo(task);
        timerConfig.setPersistent(true);

        timerService.createSingleActionTimer(10000L,timerConfig);
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

    public void cancelTimer(){
        timerService.getAllTimers().forEach((Timer timer)->{
            if (timer.getInfo().equals("Test timer")){
            timer.cancel();
            }
        });
    }
}
