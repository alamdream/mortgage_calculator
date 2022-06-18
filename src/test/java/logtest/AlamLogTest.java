package logtest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class AlamLogTest {
    public static final Logger  LOGGER = LogManager.getLogger(AlamLogTest.class);

    @Test
    public void printLog (){
        LOGGER.info("I am mad man");
        LOGGER.warn("go to hell");
        LOGGER.error("Valo hoya ja");
    }


}
