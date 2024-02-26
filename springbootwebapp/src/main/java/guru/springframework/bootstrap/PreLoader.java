package guru.springframework.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.repositories.OceanBookingRepository;

@Component
public class PreLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private OceanBookingRepository oceanBookingRepository;

    private Logger log = LogManager.getLogger(PreLoader.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    	System.out.printf("table has key=1 : %s%n",oceanBookingRepository.findById(1));
    	System.out.println("table ocean_booking has " + oceanBookingRepository.count()
    	+ " columns !");
    	
//        log.info("Saved Shirt - id: " + shirt.getId());
    }
}
