package com.custom.mylog.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleJob {
	
	
	  @Scheduled(fixedRate = 30000)
	    public void startService() {
	        System.out.println("Calling startService()");
	        System.out.println("Ending startService()");
	    }

}
