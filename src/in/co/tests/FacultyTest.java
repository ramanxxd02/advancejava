package in.co.tests;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.bean.FacultyBean;
import in.co.college.CollegeBean;
import in.co.model.CollegeModel;
import in.co.model.FacultyModel;

public class FacultyTest {
	public static void main(String[] args) throws Exception {
//		testadd();
		testupdate();
//		testdelete();
//		testsearch();
//		testfindBypk();
	}
	private static void testfindBypk() throws Exception {
		FacultyBean bean = new FacultyBean();
		FacultyModel model = new FacultyModel();
		bean = model.findByPk(1);
		System.out.println(bean.getFirst_name());
	}
	private static void testsearch() throws Exception {
		FacultyBean  bean =new FacultyBean();
		FacultyModel model= new FacultyModel();
		List list = new ArrayList();
		list = model.search(bean, 0, 0);
		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (FacultyBean) it.next();

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getFirst_name());
			System.out.println("\t" + bean.getLast_name());

		}
	}


	private static void testdelete() throws Exception {
		FacultyBean bean =new FacultyBean();
		bean.setId(7);
		FacultyModel model=new FacultyModel();
		model.delete(bean);
		System.out.println("Done");
	}

	private static void testupdate() throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
		FacultyBean bean= new FacultyBean();
		bean.setId(2);
		bean.setFirst_name("Megha");
		bean.setLast_name("patidar");
		bean.setDob(sdf.parse("08/06/2000"));
		bean.setGender("male");
		bean.setMobile_no("7255059021");
     	bean.setEmail("megha@gmail.com");
		bean.setCollege_id(001);
		bean.setCollege_name("DAVV");
		bean.setCourse_id(01);
		bean.setCourse_name("BSC");
		bean.setSubject_id(023);
		bean.setSubject_name("English");
		bean.setCreatedBy("megha@gmail.com");
		bean.setModifiedBy("patidar@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		FacultyModel model=new FacultyModel();
		model.update(bean);
		System.out.println("done");
		
	}

	private static void testadd() throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
		FacultyBean bean= new FacultyBean();
//		bean.setId(1);
		bean.setFirst_name("Nikhil");
		bean.setLast_name("khandait");
		bean.setDob(sdf.parse("02/04/2001"));
		bean.setGender("male");
		bean.setMobile_no("7223059021");
		bean.setEmail("lklktgtrrfr@gmail.com");
		bean.setCollege_id(1);
		//bean.setCollege_name("DAVV");
		bean.setCourse_id(2);
		//bean.setCourse_name("BSC");
		bean.setSubject_id(1);
		//bean.setSubject_name("English");
		bean.setCreatedBy("raman@12");
		bean.setModifiedBy("raman@12");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		FacultyModel model=new FacultyModel();
		model.add(bean);
		System.out.println("Done");
	}

}
