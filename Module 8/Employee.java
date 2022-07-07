package p8;


public class Employee implements EmployeeInterface {
	int empId;
	double basicSalary,bonus,compensation;
	String empName;
	private static int id=1;
	
	/**
	 * this is constructor of Employee Class
	 * @param name it stores Employee Name
	 * @param basicSalary it stores Basic Salary
	 * @param bonus it stores Bonus
	 * @param compensation it Stores Compensation
	 */
	Employee(String name,double basicSalary,double bonus,double compensation){
		this.empName=name;
		this.basicSalary=basicSalary;
		this.bonus=bonus;
		this.compensation=compensation;
		this.empId=id;
		id++;
	}
	
	/**
	 * Getter for Employee Name
	 * @return Employee Name
	 */
	public String getEmployeeName() {
		return empName;
	}
	
	/**
	 * Getter for Employee Basic Salary
	 * @return Employee Basic Salary
	 */
	public double getBasicSalary() {
		return basicSalary;
	}
	
	/**
	 * Getter for Employee Bonus
	 * @return Employee Bonus
	 */
	public double getBonus() {
		return bonus;
	}
	
	/**
	 * Getter for Employee Compensation
	 * @return Employee Compensation
	 */
	public double getCompensation() {
		return compensation;
	}

}
