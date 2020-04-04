package io.coronaTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import io.coronaTracker.services.CoronaVirusDataService;

import java.io.IOException;

@SpringBootApplication
@EnableScheduling
public class CoronavirusTrackerApplication {

	public static void main(String[] args) throws IOException, InterruptedException {

		SpringApplication.run(CoronavirusTrackerApplication.class, args);
		CoronaVirusDataService CVDs = new CoronaVirusDataService();
		CVDs.fetchVirusData();

	}

}
