import java.util.ArrayList;
import java.util.List;

public class Department  {
	String deptName;
	int deptId;
	List<Employee> arrEmployee;
	static int id=1;
	Department(String deptName){
		this.deptName=deptName;
		arrEmployee=new ArrayList<Employee>();
		this.deptId=id;
		id++;
	}
	public String departmentName() {
		return deptName;
	}
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
	public boolean relieve(Employee rem) throws IllegalArgumentException {
		for(int i=0;i<arrEmployee.size();i++) {
			if(rem.empId==arrEmployee.get(i).empId) {
				arrEmployee.remove(i);
				return true;
			}
		}
		throw new IllegalArgumentException("Employee not Present");
	}
	public List<Employee> getEmployees(){
		return arrEmployee;
	}
}