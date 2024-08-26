package in.co.studentdata;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import in.co.college.CollegeBean;
import in.co.college.CollegeModel;

public class StudentTest {
	public static void main(String[] args) throws Exception {
		//testadd();
		//testupdate();
		//testdelete();
		//testnextpk();
	      testgetid();
	}
	private static void testgetid() throws Exception {
		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();
		bean = model.getid(1);
		System.out.println(bean.getFirstname());

		
	}
	private static void testnextpk() throws Exception {
		StudentBean bean=new StudentBean();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		//bean.setId(1);
		bean.setFirstname("vishal");
		bean.setLastname("Dange");
		bean.setDob(sdf.parse("2001-04-02"));
		bean.setGender("Male");
		bean.setMobileNo("8223059021");
		bean.setEmail("vishal@gmail.com");
		bean.setCollegeid(01);
		bean.setCollegename("Davv");
		bean.setCreatedBy("vishal@gmail.com");
		bean.setModifiedBy("dange@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		StudentModel model=new StudentModel();
		model.nextpk();
		System.out.println("Done");
	}
	private static void testdelete() throws Exception {
		StudentBean bean=new StudentBean();
		bean.setId(1);
//		bean.setFirstname("vishal");
//		bean.setLastname("Dange");
//		bean.setDob(sdf.parse("2001-04-02"));
//		bean.setGender("Male");
//		bean.setMobileNo("8223059021");
//		bean.setEmail("vishal@gmail.com");
//		bean.setCollegeid(01);
//		bean.setCollegename("Davv");
//		bean.setCreatedBy("vishal@gmail.com");
//		bean.setModifiedBy("dange@gmail.com");
//		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		StudentModel model=new StudentModel();
		model.delete(bean);
		System.out.println("Done");		
	}
	private static void testupdate() throws Exception {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		StudentBean bean=new StudentBean();
		
		bean.setFirstname("vishal");
		bean.setLastname("Dange");
		bean.setDob(sdf.parse("2001-04-02"));
		bean.setGender("Male");
		bean.setMobileNo("8223059021");
		bean.setEmail("vishal@gmail.com");
		bean.setCollegeid(01);
		bean.setCollegename("Davv");
		bean.setCreatedBy("vishal@gmail.com");
		bean.setModifiedBy("dange@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(3);
		StudentModel model=new StudentModel();
		model.update(bean);
		System.out.println("Done");
		
	}
	private static void testadd() throws Exception {
		StudentBean bean=new StudentBean();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		bean.setId(4);
		bean.setFirstname("Raman");
		bean.setLastname("Dange");
		bean.setDob(sdf.parse("2001-04-02"));
		bean.setGender("Male");
		bean.setMobileNo("7223059021");
		bean.setEmail("raman@gmail.com");
		bean.setCollegeid(01);
		bean.setCollegename("Davv");
		bean.setCreatedBy("raman@gmail.com");
		bean.setModifiedBy("dange@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		StudentModel model=new StudentModel();
		model.add(bean);
		System.out.println("Done");
		
		
	}

}
