package unit.test.mockito.annotation;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import unit.test.mockito.Business;
import unit.test.mockito.Service;

@RunWith(MockitoJUnitRunner.class)
public class MockitoInjectTest {
	
	@Mock
	Service serviceMock;
	@InjectMocks
	Business business;
	
	@Test
	public void testServiceTestWithMock()
	{
		//Service serviceMock=mock(Service.class);
		List<String> list=Arrays.asList("Learn Spring MVC","Learn Data Structure","Learn Spring Security");
		when(serviceMock.retrieveList("Dummy")).thenReturn(list);
		//Business business=new Business(serviceMock);
		List<String> retrieveFilteredList=business.retrieveListForSpring("Dummy");
		assertEquals(2, retrieveFilteredList.size());
	}

}
