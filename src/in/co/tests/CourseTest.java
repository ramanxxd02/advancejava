package in.co.tests;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.bean.CourseBean;
import in.co.college.CollegeBean;
import in.co.model.CollegeModel;
import in.co.model.CourseModel;

public class CourseTest {
	public static void main(String[] args) throws Exception {
		//testadd();
		//testupdate();
		//testdelete();
		//testsearch();
		testfindBypk();
	}

	private static void testfindBypk() throws Exception {
		CourseBean bean=new CourseBean();
		CourseModel model =new CourseModel();
		bean=model.findByPk(1);
		System.out.println(bean.getId());
		System.out.println(bean.getName());
		
		
	}

	private static void testsearch() throws Exception {
		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();
		List list = new ArrayList();
		list = model.search(bean, 0, 0);
		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (CourseBean) it.next();

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getName());

		}
		
	}

	private static void testdelete() throws Exception {
		
		CourseBean bean=new CourseBean();
		bean.setId(2);
		CourseModel model=new CourseModel();
		model.delete(bean);
		System.out.println("done");
	}

	private static void testupdate() throws Exception {
		CourseBean bean =new CourseBean();
		bean.setName("Megha");
		bean.setDuration("XYZ");
		bean.setDescription("RSD");
		bean.setCreatedBy("megha@gmail.com");
		bean.setModifiedBy("patidar@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(1);
		CourseModel model=new CourseModel();
		model.update(bean);
		System.out.println("Done");
	}

	private static void testadd() throws Exception {
		CourseBean bean=new CourseBean();
		bean.setId(5);
		bean.setName("Raman");
		bean.setDuration("XYZ");
		bean.setDescription("RSD");
		bean.setCreatedBy("raman@gmail.com");
		bean.setModifiedBy("dange@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		CourseModel model=new CourseModel();
		model.add(bean);
		System.out.println("Done");
		
	}

}
