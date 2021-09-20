package unit.test.mockito;

import java.util.ArrayList;
import java.util.List;

// Business is under SUT
// Service dependency
public class Business {
	private Service service;

	public Business(Service service) {
		this.service = service;
	}

	public List<String> retrieveListForSpring(String user) {
		List<String> filteredList = new ArrayList<String>();
		List<String> allList = service.retrieveList(user);
		for (String list : allList) {
			if (list.contains("Spring")) {
				filteredList.add(list);
			}
		}
		return filteredList;
	}
	
	public void deleteListNotForSpring(String user) {

		List<String> allList = service.retrieveList(user);
		for (String list : allList) {
			if (!list.contains("Spring")) {
				service.DeleteList(list);
			}
		}
		
	}
}