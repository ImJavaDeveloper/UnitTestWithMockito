package unit.test.mockito.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {
	
	@Test
	public void testMockListSize()
	{
		List list=mock(List.class);
		when(list.size()).thenReturn(2);
		assertEquals(2,list.size());
		assertEquals(2,list.size());
	}
	
	@Test
	public void testMockListSize_MultipleVal()
	{
		List list=mock(List.class);
		when(list.size()).thenReturn(2).thenReturn(3);
		assertEquals(2,list.size());
		assertEquals(3,list.size());
	}
	
	@Test
	public void testMockListget()
	{
		List list=mock(List.class);
		//when(list.get(0)).thenReturn("Rahat");
		when(list.get(anyInt())).thenReturn("Rahat");
		assertEquals("Rahat",list.get(0));
		assertEquals("Rahat",list.get(1));
		assertEquals("Rahat",list.get(3));
		
	}
	
	@Test(expected=RuntimeException.class)
	public void testMockList_throwException()
	{
		List list=mock(List.class);
		//when(list.get(0)).thenReturn("Rahat");
		when(list.get(anyInt())).thenThrow(new RuntimeException("Something Wrong Happend !!"));
		list.get(0);
		
	}
	
	@Test()
	public void testMockList_UsingBDD()
	{
		List<String> list=mock(List.class);
		//when(list.get(0)).thenReturn("Rahat");
		given(list.get(anyInt())).willReturn("Rahat");
		assertThat(list.get(0), is("Rahat"));
		
	}
	

}
