package service;

import dao.StudentDao;
import member.Student;

public class SelectService {
	private StudentDao studentDao;

	public SelectService(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}
	
	public Student select(String sNum) {
		if(verify(sNum)) {
			return studentDao.select(sNum);
		}else {
			System.out.println("XX");
		}
		
		return null;
	}

	public  boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student != null ? true : false;
	}
	
}
