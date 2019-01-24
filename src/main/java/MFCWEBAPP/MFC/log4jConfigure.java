package MFCWEBAPP.MFC;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;

public class log4jConfigure 
{
	static Logger log = Logger.getLogger(MethodCalling.class);
	public log4jConfigure() throws Exception
	{
        PropertyConfigurator.configure("log4j.properties");
        Reporter.log("Reporter log started",true);
        Reporter.log("Login was successful. Moving to next step",true);
	}

}
