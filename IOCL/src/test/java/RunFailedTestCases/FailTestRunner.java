package RunFailedTestCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.AfterTest;

public class FailTestRunner {

	
	@AfterTest
	public void runFailTestCases() {
		
		TestNG obj= new TestNG();
		List<String> list=new ArrayList<String>();
		list.add("C:\\Users\\chandrakar.dwivedi\\eclipse-workspace\\E2EIOCL\\test-output\\Suite\\testng-failed.xml");
		obj.setTestSuites(list);
		obj.run();
		
	}
}
