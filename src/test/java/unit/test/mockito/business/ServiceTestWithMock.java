package unit.test.mockito.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import unit.test.mockito.Business;
import unit.test.mockito.Service;


public class ServiceTestWithMock {
	
	@Test
	public void testServiceTestWithMock()
	{
		Service serviceMock=mock(Service.class);
		List<String> list=Arrays.asList("Learn Spring MVC","Learn Data Structure","Learn Spring Security");
		when(serviceMock.retrieveList("Dummy")).thenReturn(list);
		Business business=new Business(serviceMock);
		List<String> retrieveFilteredList=business.retrieveListForSpring("Dummy");
		assertEquals(2, retrieveFilteredList.size());
	}
	@Test
	public void testDeleteList_UsingBDD()
	{
		Service serviceMock=mock(Service.class);
		List<String> list=Arrays.asList("Learn Spring MVC","Learn Data Structure","Learn Spring Security");
		given(serviceMock.retrieveList("Dummy")).willReturn(list);
		Business business=new Business(serviceMock);
		//when
		business.deleteListNotForSpring("Dummy");
		//then
		then(serviceMock).should().DeleteList("Learn Data Structure");
		
		then(serviceMock).should(never()).DeleteList("Learn Spring MVC");
		
		//Below code can be used instead of then
		/*
		 * verify(serviceMock).DeleteList("Learn Data Structure");
		 * verify(serviceMock,times(1)).DeleteList("Learn Data Structure");
		 * verify(serviceMock,never()).DeleteList("Learn Spring MVC");
		 */
		
	}
	
	@Test
	public void testDeleteList_UsingBDD_CaptureArgument()
	{
		//declare argument captor
		ArgumentCaptor<String> stringArgCaptor=ArgumentCaptor.forClass(String.class);
		//Define argument captor on specific method call
		//capture the argument
		Service serviceMock=mock(Service.class);
		List<String> list=Arrays.asList("Learn Spring MVC","Learn Data Structure","Learn Spring Security");
		given(serviceMock.retrieveList("Dummy")).willReturn(list);
		Business business=new Business(serviceMock);
		//when
		business.deleteListNotForSpring("Dummy");
		//then
		then(serviceMock).should().DeleteList(stringArgCaptor.capture());
		assertEquals(stringArgCaptor.getValue(), is("Learn Data Structure"));
		
		
	}
}
