package unit.test.mockito.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import unit.test.mockito.Business;
import unit.test.mockito.Service;
import unit.test.mockito.ServiceStub;

public class ServiceStubTest {
	
	@Test
	public void test()
	{
		Service serviceStub=new ServiceStub();
		Business business=new Business(serviceStub);
		List retrieveFilteredList=business.retrieveListForSpring("Dummy");
		assertEquals(2, retrieveFilteredList.size());
	}

}
