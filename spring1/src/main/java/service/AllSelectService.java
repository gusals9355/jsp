package service;

import java.util.Map;

import member.Student;
import dao.StudentDao;

public class AllSelectService {
	private StudentDao studentDao;
	
	public AllSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Map<String, Student> allSelect() {
		return studentDao.getStudentDB();
	}
}
