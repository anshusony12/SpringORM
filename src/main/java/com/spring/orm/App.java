package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
        Student student=new Student(222,"Arunawati Tiwari", "lucknow");
        
//        int r = studentDao.insert(student);
//        System.out.println("done");
//        System.out.println(r);
        
//        Student student2 = studentDao.getStudent(3434343);
//        System.out.println(student2);
//        
//        studentDao.deleteStudent(111);
//        System.out.println("deleted");
//        
//        studentDao.update(student);
//        System.out.println("updated");
//        
//        List<Student> allStudents = studentDao.getAllStudents();
//        for(Student s: allStudents) {
//        	System.out.println(s);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go=true;
        while(go) {
        	System.out.println("press 1 for add a new student");
        	System.out.println("press 2 for display all the students");
        	System.out.println("press 3 for get details of single student");
        	System.out.println("press 4 for delete a student");
        	System.out.println("press 5 to update the student details");
        	System.out.println("press 6 for exit");
        	
        	
        	try {
//				if(input == 1) {
//					// adding a student
//				}
        		int input = Integer.parseInt(br.readLine());
            	
        		switch(input) {
        		case 1:
        			// adding a student
        			System.out.println("Enter user id: ");
        			int uId = Integer.parseInt(br.readLine());
        			System.out.println("Enter user name: ");
        			String uName = br.readLine();
        			System.out.println("Enter user city: ");
        			String uCity = br.readLine();
        			
        			Student s= new Student(uId, uName, uCity);
        			int i = studentDao.insert(s);
        			System.out.println(i+ "student added");
        			System.out.println("*********************************************************");
        			break;
        		case 2:
        			// displaying students
        			List<Student> list = studentDao.getAllStudents();
        			for(Student st:list) {
        				System.out.println(st);
        			}
        			System.out.println("**********************************************************");
        			break;
        		case 3:
        			// get details of single students
        			System.out.println("Enter user id: ");
        			int id = Integer.parseInt(br.readLine());
        			Student student2 = studentDao.getStudent(id);
        			System.out.println(student2);
        			System.out.println("**********************************************************");
        			break;
        		case 4:
        			//deleting a student
        			System.out.println("Enter user id: ");
        			int studentId = Integer.parseInt(br.readLine());
        			studentDao.deleteStudent(studentId);
        			System.out.println("deleted sucessfully...");
        			System.out.println("-**********************************************************");
        			break;
        		case 5:
        			//updating a studet deatails
        			System.out.println("Enter user id: ");
        			int stId = Integer.parseInt(br.readLine());
        			System.out.println("Enter user name: ");
        			String stName = br.readLine();
        			System.out.println("Enter user city: ");
        			String stCity = br.readLine();
        			Student student3= new Student(stId, stName, stCity);
        			studentDao.update(student3);
        			System.out.println(student3.getStudentId() + "update successfully");
        			System.out.println("*************************************************************");
        			break;
        		case 6:
        			//exiting an application
        			go = false;
        			break;
        			
        		}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("invalid input tru with another!!");
				System.out.println(e.getMessage());
			}
        }
        System.out.println("Thankyou for using this application");
    	System.out.println("See you soon !!"); 
       }

}
