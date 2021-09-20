package unit.test.mockito;

import java.util.List;

//External Service - Lets say this comes from WunderList
public interface Service {
	public List<String> retrieveList(String user);
	public List<String> DeleteList(String user);
}