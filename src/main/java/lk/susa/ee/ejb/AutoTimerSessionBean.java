package lk.susa.ee.ejb;

import jakarta.ejb.Schedule;
import jakarta.ejb.Stateless;

@Stateless
public class AutoTimerSessionBean {

        @Schedule(second ="0", minute = "0", hour ="*")
        public void checkSystemHealth(){
            System.out.println("Checking System Health...");
        }

        @Schedule(second ="0", minute = "0", hour ="0")
        public void purgeOldData(){
            System.out.println("Purging Old Data...");
        }

        @Schedule(dayOfWeek = "Mon-Fri", hour ="8-17", minute = "0", second = "0")
        public void generateHourlyReport(){
            System.out.println("Generating Hourly Report...");
        }

        //@Schedule(dayOfMonth = "Last", hour ="23", minute ="59")
        @Schedule(dayOfMonth = "-1", hour ="23", minute = "59")
        public void processMonthlyBilling(){
            System.out.println("Processing Monthly Billing...");
        }



    }

