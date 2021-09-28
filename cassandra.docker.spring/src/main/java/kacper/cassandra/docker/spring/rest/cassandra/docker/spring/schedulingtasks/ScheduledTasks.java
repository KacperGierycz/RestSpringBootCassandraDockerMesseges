package kacper.cassandra.docker.spring.rest.cassandra.docker.spring.schedulingtasks;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kacper.cassandra.docker.spring.rest.cassandra.docker.spring.model.Content;
import kacper.cassandra.docker.spring.rest.cassandra.docker.spring.repo.ContentRepository;



@Component
public class ScheduledTasks {
	
	@Autowired
	ContentRepository contentRepository;

//	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

//	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 300000)
	public void reportCurrentTime() {
		
		SimpleDateFormat now2= new SimpleDateFormat ();
		Date now = new Date();
		Long longNow = now.getTime();
//		Long fiveMinErlier = now.getTime()-300000;
		
		
		List<Content>content=contentRepository.findAll();
		if (content!=null) {
			for(Content mes:content) {
				
		//		log.info("running thro messages:", dateFormat.format(now) );
				Date mesD=mes.getDate();
				long longMesD = mesD.getTime();
				long diff =longNow-longMesD; 
		//		log.info("diference is :", diff);
				if (diff>300000) {
		//			log.info("is it greter then 5: ",diff>5);
					contentRepository.delete(mes);
					
					
					System.out.println("Old message is going out: " +" "+ mes.getEmail());
		//			log.info("Old message is going out: " +" "+ mes.getEmail());
					
				}
			}
			
		}
		
	//	log.info("The time is now???????????????????????????? {}", dateFormat.format(new Date()));
	}
}
