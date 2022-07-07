package p8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PayrollTest {
	Organization org;
	String arrDeptName[];
	String arrEmpName[];
	Double arrEmpBasicSalary[];
	Double arrEmpBonus[];
	Double arrEmpCompensation[];
	Department dept[];
	Employee emp[];
	@BeforeEach
	void init() {
		org=new Organization("Metacube");
		arrDeptName=new String[] {"IT","Finance","Admin"};
		arrEmpName=new String[] {"Ritik","Rahul","Ajay","Nikhil"};
		arrEmpBasicSalary=new Double[] {20000d,25000d,27000d,27000d};
		arrEmpBonus=new Double[] {1000d,500d,700d,700d};
		arrEmpCompensation=new Double[] {21000d,25500d,27700d,27700d};
		dept=new Department[arrDeptName.length];
		emp=new Employee[arrEmpName.length];
		for(int i=0;i<arrDeptName.length;i++) {
			dept[i]=new Department(arrDeptName[i]);
		}
		for(int i=0;i<arrEmpName.length;i++) {
			emp[i]=new Employee(arrEmpName[i],arrEmpBasicSalary[i],arrEmpBonus[i],arrEmpCompensation[i]);
		}
		
		
	}
	@Test
	void employeeTest() {
		assertEquals(arrEmpName[0],emp[0].getEmployeeName());
		assertEquals(arrEmpBasicSalary[0],emp[0].getBasicSalary());
		assertEquals(arrEmpBonus[0],emp[0].getBonus());
		assertEquals(arrEmpCompensation[0],emp[0].getCompensation());
	}
	
	@Test
	void joinEmpTest() {
		dept[0].join(emp[0]);
		Throwable exception=assertThrows(IllegalArgumentException.class, () -> {
	        dept[0].join(emp[0]);
	    });
		assertEquals("Already Present", exception.getMessage());
		assertTrue(dept[1].join(emp[0]));
	}
	
	@Test
	void relieveEmpTest() {
		assertTrue(dept[0].join(emp[0]));
		assertTrue(dept[0].relieve(emp[0]));
		Throwable exception=assertThrows(IllegalArgumentException.class, () -> {
	        dept[0].relieve(emp[0]);
	    });
		assertEquals("Employee not Present", exception.getMessage());
		
		
	}
	@Test
	void getEmployeeTest() {
		for(int i=0;i<emp.length;i++) {
			dept[0].join(emp[i]);
		}
		assertEquals(4,dept[0].getEmployees().size());
		
	}
	@Test
	void addDepartmentTest() {
		assertTrue(org.addDepartment(dept[0]));
		Throwable exception=assertThrows(IllegalArgumentException.class, () -> {
			org.addDepartment(dept[0]);
	    });
		assertEquals("Same Department Already present", exception.getMessage());
	}
	@Test
	void departmentListTest() {
		for(int i=0;i<dept.length;i++) {
			org.addDepartment(dept[i]);
		}
		assertEquals(3,org.departmentList().size());
	}
	@Test
	void employeeListTest() {
		for(int i=0;i<dept.length;i++) {
			org.addDepartment(dept[i]);
		}
		for(int i=0;i<emp.length;i++) {
			dept[0].join(emp[i]);
		}
		for(int i=0;i<emp.length-1;i++) {
			dept[1].join(emp[i]);
		}
		for(int i=0;i<emp.length-2;i++) {
			dept[2].join(emp[i]);
		}
		assertEquals(4,org.employeeList().size());
	}

}

