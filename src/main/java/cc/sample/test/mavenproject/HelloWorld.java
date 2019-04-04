package cc.sample.test.mavenproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorld {
	private static final Logger logger = LogManager.getLogger(HelloWorld.class);
	
	public static void main(String[] args) {
		logger.debug("This is log4j output!");
		
		System.out.println("Hello World!");
		
	}

}
