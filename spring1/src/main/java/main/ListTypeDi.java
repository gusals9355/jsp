package main;

import java.util.List;

public class ListTypeDi {
	private List<String> developers;

	public ListTypeDi(List<String> developers) {
		this.developers = developers;
	}

	public List<String> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<String> developers) {
		this.developers = developers;
	}
	
	
}
