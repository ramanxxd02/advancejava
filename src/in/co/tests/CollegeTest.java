package in.co.tests;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.college.CollegeBean;
import in.co.model.CollegeModel;

public class CollegeTest {
	public static void main(String[] args) throws Exception {

		//testadd();
		//testupdate();
		testfindByPk();
		//testdelete();
		//testsearch();
	}

	private static void testfindByPk() throws Exception {
		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();
		bean = model.findByPk(1);
		System.out.println(bean.getId());
		System.out.println(bean.getName());
	}

	private static void testadd() throws Exception {

		CollegeBean bean = new CollegeBean();
		bean.setId(3);
		bean.setName("neha");
		bean.setAddress("regal squre");
		bean.setState("up");
		bean.setCity("bhopal");
		bean.setPhoneNo("9087653634");
		bean.setCreatedBy("neha@gmail.com");
		bean.setModifiedBy("sharma@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CollegeModel model = new CollegeModel();
		model.add(bean);
	}

	private static void testupdate() throws Exception {

		CollegeModel model = new CollegeModel();

		CollegeBean bean = new CollegeBean();
		bean.setId(1);
		bean.setName("swati");
		bean.setAddress("bangali squre");
		bean.setState("mp");
		bean.setCity("indore");
		bean.setPhoneNo("9087653627");
		bean.setCreatedBy("neha@gmail.com");
		bean.setModifiedBy("sharma@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);

	}

	private static void testdelete() throws Exception {
		CollegeBean bean = new CollegeBean();
		bean.setId(0);
		bean.setName("suman");
		bean.setAddress("bangali squre");
		bean.setState("mp");
		bean.setCity("indore");
		bean.setPhoneNo("9087653627");
		bean.setCreatedBy("neha@gmail.com");
		bean.setModifiedBy("sharma@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CollegeModel model = new CollegeModel();
		model.delete(bean);
		System.out.println("done");
	}

	private static void testsearch() throws Exception {
		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();
		List list = new ArrayList();
		list = model.search(bean, 0, 0);
		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (CollegeBean) it.next();

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getName());

		}

	}
}
