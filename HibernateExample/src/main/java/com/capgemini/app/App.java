package com.capgemini.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.model.Pracownik;
import com.capgemini.service.PracownikService;
import com.capgemini.service.impl.PracownikServiceImpl;



public class App {
	
	/*@Autowired
	private PracownikService pracownikService;
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Spring/applicationContext.xml");
		//EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);
		PracownikService pracownikService = ctx.getBean("pracownikService", PracownikService.class);
		
		
		/*List<Pracownik> listaPracownikow = pracownikService.findAll();
		System.out.println(listaPracownikow.get(0).getImie());*/
		
		//System.out.println(pracownikService.updatePracownik(1));
		
		ctx.close();
		
		
		
		
	}

}
