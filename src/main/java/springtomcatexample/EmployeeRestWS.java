package springtomcatexample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raghav.DAO.EmployeeDAOImp;
import com.raghav.company.Employee;
import com.raghav.company.Phone;

@Controller
@RequestMapping("/employee")
public class EmployeeRestWS {

	@Autowired
	EmployeeDAOImp employeeDAO;

	@Autowired
	Phone phone;

	@Autowired
	Employee employee;

	public void getEmployees() {

	}

	@RequestMapping(value = "/getString")
	public String getVars() {
		return "index";
	}

	@RequestMapping(value = "/getEmployeeByID/{id}")
	public @ResponseBody Employee getEmployeeByID(@PathVariable Long id) {

		/*
		 * System.out.println(id + " : id" ); Long long1 = Long.parseLong(id);
		 * 
		 * System.out.println(long1);
		 */

		Employee employee1 = employeeDAO.getEmployeeOnID(id);
		if (employee1 == null) {
			employee1 = new Employee();
			return employee1;
		}
		if (employee1.getPhones() == null) {
			List list = new ArrayList<Phone>();
			list.add(phone);
			employee1.setPhones(list);
		}

		return employee1;
	}

	@RequestMapping(value = "/getEmployeePhone")
	public @ResponseBody Phone getphoneByID() {
		return phone;
	}

	@RequestMapping(value = "/addPhone", method = RequestMethod.POST)
	public @ResponseBody Phone addEmployee(@RequestBody Phone phone) {

		employeeDAO.addPhone(phone);

		return phone;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Employee addEmployee(@RequestBody Employee employee) {

		employeeDAO.addEmployee(employee);

		return employee;
	}

	public Employee updateEmployee(Employee employee) {
		return null;
	}

	public Employee deleteEmployee(Employee employee) {

		return null;
	}
}
