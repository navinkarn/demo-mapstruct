package com.example.demo;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.mapper.*;
import com.example.demo.model.*;
import com.example.demo.util.EmpValidator;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
	private static EmployeeMapper employeeMapper = new EmployeeMapperImpl(new EmpValidator());
	private static AddressMapper addressMapper = new AddressMapperImpl();
	private static OrderItemMapper orderItemMapper = new OrderItemMapperImpl();
	private static ContactTypeMapper contactTypeMapper = new ContactTypeMapperImpl();
	private static CustomerMapper customerMapper = new CustomerMapperImpl(addressMapper, orderItemMapper, contactTypeMapper);


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		//Customer model to customerDto mapping
		Customer customer = new Customer();
		customer.setId(2);
		customer.setFirstName("someFirstName");
		customer.setLastName("someLastName");
		customer.setTitle(null);
		Address address = new Address();
		address.setCity("Des Moines");
		address.setState("IA");
		address.setZip("50309");
		customer.setAddress(address);
		OrderItem orderItem1 = new OrderItem("1", 500L);
		OrderItem orderItem2 = new OrderItem("2", 3000L);
		List<OrderItem> orderItems = new ArrayList<>();
		orderItems.add(orderItem1);
		orderItems.add(orderItem2);
		customer.setOrderItems(orderItems);
		customer.setContactType(ContactType.EMAIL);

		CustomerDto customerDto = customerMapper.customerToDto(customer);
		System.out.println(customerDto.toString());

       //customerDto to Customer mapping
		Customer customer1 = customerMapper.customerFromDto(customerDto);
		System.out.println(customer1.toString());

		//Employee to EmployeeDto Mapping
		Employee employee = new Employee();
		employee.setEmpId(1); //set this to -1, if you want to see the ValidationException
		employee.setFirstName("employeeFirstName");
		employee.setLastName("employeeLastName");
		employee.setStartDate(new Date());
		try{
			EmployeeDto employeeDto = employeeMapper.empToDto(employee);
			System.out.println(employeeDto.toString());
		} catch (Exception e) {
			System.out.println("ValidationException has occurred");
		}


		//EmployeeDto to Employee mapping
	}

}
