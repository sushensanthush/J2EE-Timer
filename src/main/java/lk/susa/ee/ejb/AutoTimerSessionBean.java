package lk.susa.ee.ejb;

import jakarta.ejb.Schedule;
import jakarta.ejb.Stateless;

@Stateless
public class AutoTimerSessionBean {

        @Schedule(second ="0", minute = "0", hour ="*")
        public void autoSchedule(){
            System.out.println("Auto Schedule...");
        }
    }

