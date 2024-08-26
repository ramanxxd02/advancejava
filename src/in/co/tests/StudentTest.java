package in.co.tests;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import in.co.bean.MarksheetBean;
import in.co.bean.StudentBean;
import in.co.model.MarksheetModel;
import in.co.model.StudentModel;

public class StudentTest {
	public static void main(String[] args) throws Exception {
		//testadd();
		//testupdate();
		//testdelete();
		testgetid();
		//testfindBypk();
	}

	
		private static void testfindBypk() throws Exception {
		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();
			bean = model.findByPk(1);
			System.out.println(bean.getFirstName());
		
	}


		private static void testgetid() throws Exception {
			StudentBean bean = new StudentBean();
			StudentModel model = new StudentModel();
			bean = model.getid(1);
			System.out.println(bean.getFirstName());

		
	}

	private static void testdelete() throws Exception {
		StudentBean bean= new  StudentBean();
        StudentModel model =new StudentModel();
        model.delete(4);
        System.out.println("done");
	}

	private static void testupdate() throws Exception {
	StudentBean bean= new StudentBean();
	SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
	bean.setId(2);
	bean.setFirstName("Megha");
	bean.setLastName("Patidar");
	bean.setDob(sdf.parse("05/08/1996"));
	bean.setGender("Female");
	bean.setMobileNo("9223058282");
	bean.setEmail("meghapatidar50@gmail.com");
	bean.setCollegeId(02);
	bean.setCollegeName("DAVV");
	bean.setCreatedBy(" ");
	bean.setModifiedBy(" ");
	bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
	bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
	StudentModel model =new StudentModel();
	model.update(bean);
	System.out.println("Done");
	}

	private static void testadd() throws Exception {
		StudentBean bean = new StudentBean();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
		//bean.setId(1);
		bean.setFirstName("raj");
		bean.setLastName("Patidar");
		bean.setDob(sdf.parse("03/04/1995"));
		bean.setGender("Female");
		bean.setMobileNo("9223059021");
		bean.setEmail("Meghapatidar@gmail.com");
		bean.setCollegeId(3);
		//bean.setCollegeName("DAVV");
		bean.setCreatedBy(" ");
		bean.setModifiedBy(" ");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		StudentModel model =new StudentModel();
		model.add(bean);
		System.out.println("Done");	
	}
}
