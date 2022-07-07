
public class Employee implements EmployeeInterface {
	int empId;
	double basicSalary,bonus,compensation;
	String empName;
	private static int id=1;
	Employee(String name,double basicSalary,double bonus,double compensation){
		this.empName=name;
		this.basicSalary=basicSalary;
		this.bonus=bonus;
		this.compensation=compensation;
		this.empId=id;
		id++;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public double getBonus() {
		return bonus;
	}
	public double getCompensation() {
		return compensation;
	}

}
