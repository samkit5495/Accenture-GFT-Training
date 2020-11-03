package com.accenture.ioc.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.accenture.ioc.utility.EmployeeSQLQueries;

public class EmployeeServiceClient {

	public static void main(String[] args) {

		//1. Identify the config file to be read by spring container
		Resource res=new ClassPathResource("SpringContainerConfig.xml");

		//2. Create the container to make it read the config file and create the beans
		
		//lazy bean
		BeanFactory container=new XmlBeanFactory(res);
		
		//active bean
//		ApplicationContext container=new ClassPathXmlApplicationContext("SpringContainerConfig.xml");
		
		
		System.out.println("Container Instaintiated");
		
		EmployeeSQLQueries empQueries1=(EmployeeSQLQueries) container.getBean("dbQuery");
		EmployeeSQLQueries empQueries2=(EmployeeSQLQueries) container.getBean("dbQuery");
		EmployeeSQLQueries empQueries3=(EmployeeSQLQueries) container.getBean("dbQuery");
		
		/*System.out.println(empQueries.getSearchEmployee());
		System.out.println(empQueries.getCreateEmployee());
		System.out.println(empQueries.getDeleteEmployee());*/
	}

}
