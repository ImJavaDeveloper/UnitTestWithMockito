package unit.test.mockito.hamcrest;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestTest {
	
	@Test
	public void test() {
	List<Integer> scores=Arrays.asList(88,34,98,76);
	assertThat(scores, hasSize(4));
	assertThat(scores,hasItems (88,98));
	
	//everyItem >30
	assertThat(scores,everyItem(greaterThan(30)));
	
	//String
	assertThat("",isEmptyString());
	
	//Integer
	Integer [] marks= {78,56,37,89};
	
	assertThat(marks,arrayWithSize(4));
	assertThat(marks,arrayContaining(78,56,37,89));
	}

}
