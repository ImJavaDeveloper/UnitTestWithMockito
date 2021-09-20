package unit.test.mockito;

import java.util.Arrays;
import java.util.List;

public class ServiceStub implements Service {

	public List<String> retrieveList(String user) {
		// TODO Auto-generated method stub
		return Arrays.asList("Learn Spring MVC","Learn Data Structure","Learn Spring Security");
	}

	public List<String> DeleteList(String user) {
		// TODO Auto-generated method stub
		return null;
	}

}
