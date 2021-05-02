package assembler;

import dao.StudentDao;
import service.AllSelectService;
import service.DeleteService;
import service.ModifyService;
import service.RegisterService;
import service.SelectService;

public class StudentAssembler {
	private StudentDao studentDao;
	private RegisterService registerService;
	private ModifyService modifyService;
	private DeleteService deleteService;
	private SelectService selectService;
	private AllSelectService allSelectService;
	
	public StudentAssembler() {
		studentDao = new StudentDao();
		registerService = new RegisterService(studentDao);
		modifyService = new ModifyService(studentDao);
		deleteService = new DeleteService(studentDao);
		selectService = new SelectService(studentDao);
		allSelectService = new AllSelectService(studentDao);
	}
	
	public StudentDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	public RegisterService getRegisterService() {
		return registerService;
	}
	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	public ModifyService getModifyService() {
		return modifyService;
	}

	public void setModifyService(ModifyService modifyService) {
		this.modifyService = modifyService;
	}

	public DeleteService getDeleteService() {
		return deleteService;
	}

	public void setDeleteService(DeleteService deleteService) {
		this.deleteService = deleteService;
	}

	public SelectService getSelectService() {
		return selectService;
	}

	public void setSelectService(SelectService selectService) {
		this.selectService = selectService;
	}

	public AllSelectService getAllSelectService() {
		return allSelectService;
	}

	public void setAllSelectService(AllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}
	
	
	
}
