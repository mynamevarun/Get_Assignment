package jdbc;

public class TopCategory {

	// instance variables.
	private String categoryName;
	private int numberOfChilds;
public TopCategory(String name, int child) {
	categoryName=name;
	numberOfChilds=child;
}
	// Getters and setters.
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getNumberOfChilds() {
		return numberOfChilds;
	}

	public void setNumberOfChilds(int numberOfChilds) {
		this.numberOfChilds = numberOfChilds;
	}
}