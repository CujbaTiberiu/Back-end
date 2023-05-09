package COM.epicode.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {

	public static void main(String[] args) {

		Logger log = LoggerFactory.getLogger(MainProject.class);

		log.info("Test log!");
		log.error("Test error!");
		log.warn("Test warning!");
		log.debug("Test debug!");

	}

}
