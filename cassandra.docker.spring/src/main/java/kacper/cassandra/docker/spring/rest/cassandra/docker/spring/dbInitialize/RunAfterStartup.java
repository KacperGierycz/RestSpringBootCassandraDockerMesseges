package kacper.cassandra.docker.spring.rest.cassandra.docker.spring.dbInitialize;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import kacper.cassandra.docker.spring.rest.cassandra.docker.spring.model.Content;
import kacper.cassandra.docker.spring.rest.cassandra.docker.spring.repo.ContentRepository;


@Component
public class RunAfterStartup{
	
	@Autowired
	ContentRepository contentRepository;
	
//	private static final Logger log = LoggerFactory.getLogger(RunAfterStartup.class);

@EventListener(ApplicationReadyEvent.class)
public void runAfterStartup() {
	
//	log.info("Welcome woderfull people "); 
	System.out.println("Welcome woderfull people ");
	
	List<Content> send = new ArrayList<Content>();
	
	send= contentRepository.findAll();
	if(send.isEmpty()) {
//	log.info("Db is empty");
//	log.info("Records injection..... ");
	

    
	Content jan = new Content("jan.kowalski@example.com", "Interview","simple text", 101, new Date());
	Content anna = new Content("anna.zajkowska@example.com","Interview 3","simple text 3",22,new Date());
//	Content jan2 = new Content("jan.kowalski@example.com","Interview 3","simple text 3",22,new Date());
	

	

	contentRepository.save(jan);
	contentRepository.save(anna);
//	log.info("Succeeded!"+ jan.getEmail()+" "+anna.getEmail());
//	log.info("App is ready enjoy record juggling "); 
System.out.println("Succeeded!"+ jan.getEmail()+" "+anna.getEmail());
System.out.println("App is ready enjoy record juggling ");
	}
	
}
}
