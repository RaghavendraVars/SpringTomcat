package com.raghav.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.raghav.company.Employee;
import com.raghav.company.Phone;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Employee addEmployee(Employee employee) { /* (Employee employee) parameter Employee Object is in 
														Transient State*/
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(employee); // persistence State
		tx.commit();

		Object identifier = session.getIdentifier(employee);
		System.out.println("Employee Object identifier : " + identifier);
		
		employee.setLastName("EMIs");
		
		session.merge(employee);
		session.close();
		
		return employee;// Detach State
	}
	
	@Override
	public Phone addPhone(Phone phone) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(phone);
		tx.commit();
		session.close();
		return phone;
	}


	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeOnID(long ID) {
		String sql = "from Employee e where e.Emp_ID = "+ ID;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Query  query = session.createQuery(sql);
		List results = query.list();
		
		//List<Employee> results = (List<Employee>) session.createQuery("from Employee").list();
		session.close();
		Employee employee = null;
		System.out.println(results.isEmpty() + " : !results.isEmpty()");
		if(!results.isEmpty()){
		    // ignores multiple results
			System.out.println(results.isEmpty() + " : !results.isEmpty()");
			System.out.println(results.get(0) + " : get(0)");
			employee = (Employee) results.get(0);
			System.out.println(employee.getFirstName() + " : getFN");
		}
		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
