package p8;

import java.util.ArrayList;
import java.util.List;

public class Department  {
	String deptName;
	int deptId;
	List<Employee> arrEmployee;
	static int id=1;
	/**
	 * this is constructor of Department Class
	 * @param deptName name of Department
	 */
	Department(String deptName){
		this.deptName=deptName;
		arrEmployee=new ArrayList<Employee>();
		this.deptId=id;
		id++;
	}
	
	/**
	 * Getter for Department Name
	 * @return Department Name
	 */
	public String departmentName() {
		return deptName;
	}
	
	/**
	 * 
	 * @param empAdd contains new employee for add
	 * @return true if successfully added
	 * @throws IllegalArgumentException if Employee already present
	 */
	public boolean join(Employee empAdd) throws IllegalArgumentException {
		for(int i=0;i<arrEmployee.size();i++) {
			if(empAdd.empId==arrEmployee.get(i).empId) {
				throw new IllegalArgumentException("Already Present");
			}
		}
		arrEmployee.add(empAdd);
		return true;
	}
	public void printEmp() {
		for(int i=0;i<arrEmployee.size();i++) {
			System.out.println(arrEmployee.get(i).empId);
		}
	}
	/**
	 * 
	 * @param rem contains details of employee for remove
	 * @return true if successfully remove
	 * @throws IllegalArgumentException if employee not present 
	 */
	public boolean relieve(Employee rem) throws IllegalArgumentException {
		for(int i=0;i<arrEmployee.size();i++) {
			if(rem.empId==arrEmployee.get(i).empId) {
				arrEmployee.remove(i);
				return true;
			}
		}
		throw new IllegalArgumentException("Employee not Present");
	}
	
	/**
	 * 
	 * @return list of employee present in that department
	 */
	public List<Employee> getEmployees(){
		return arrEmployee;
	}
}