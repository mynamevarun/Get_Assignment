package p8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Organization {
	List<Department> departmentArr;
	String orgName;
	
	/**
	 * 
	 * @param name stores name of organization
	 */
	Organization(String name){
		this.orgName=name;
		departmentArr=new ArrayList<Department>();
	}
	
	/**
	 * 
	 * @param dept store details of department that to add
	 * @return true if successfully added
	 * @throws IllegalArgumentException if department already present
	 */
	boolean addDepartment(Department dept) throws IllegalArgumentException {
		for(int i=0;i<departmentArr.size();i++) {
			if(departmentArr.get(i).departmentName().toLowerCase().equals(dept.departmentName().toLowerCase())) {
				throw new IllegalArgumentException("Same Department Already present");
			}
		}
		departmentArr.add(dept);
		return true;
	}
	
	/**
	 * 
	 * @return list of all department present in that organization
	 */
	List<Department> departmentList(){
		return departmentArr;
	}
	
	public void printDept() {
		for(int i=0;i<departmentArr.size();i++) {
			System.out.println(departmentArr.get(i).deptId);
		}
	}
	
	/**
	 * 
	 * @return list of all unique employee
	 */
	ArrayList<Employee> employeeList(){
		Map<Integer,Employee> uniqueEmp=new HashMap<Integer,Employee>();
		for(int i=0;i<departmentArr.size();i++) {
			List<Employee>emp=departmentArr.get(i).getEmployees();
			for(int j=0;j<emp.size();j++) {
				uniqueEmp.put(emp.get(j).empId,emp.get(j));
			}
		}
//		System.out.println(uniqueEmp.size());
		return new ArrayList<Employee>(uniqueEmp.values());
	}
	

}
