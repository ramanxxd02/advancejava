package in.co.college;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.marksheet.Marksheetbean;
import in.co.marksheet.Marksheetmodel;

public class CollegeTest {
	public static void main(String[] args) throws Exception {
		// testadd();
		// testupdate();
		// testdelete();
		 testgetid();
		// testnextpk();
		//testsearch();

	}

	private static void testsearch() throws Exception {

		
		
		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();
		List list = new ArrayList();
	   bean.setName("Raman");
		   list  =      model.search(bean);
		Iterator it = list.iterator();		while (it.hasNext()) {
			bean = (CollegeBean) it.next();
		//	System.out.println("\t" + bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getAddress());
			System.out.println("\t" + bean.getState());
			System.out.println("\t" + bean.getCity());
			System.out.println("\t" + bean.getPhoneNo());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
			

		}

	}

	private static void testnextpk() throws Exception {
		CollegeBean bean = new CollegeBean();
		// bean.setId(04);
		bean.setName("Nikhil");
		bean.setAddress("Indore");
		bean.setState("Madhyapradesh");
		bean.setCity("Indore");
		bean.setPhoneNo("9223059021");
		bean.setCreatedBy("nikhil@gmail.com");
		bean.setModifiedBy("khaindait@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		CollegeModel model = new CollegeModel();
		model.nextpk();

	}

	private static void testgetid() throws Exception {
		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();
		bean = model.getid(1);
		System.out.println(bean.getName());

	}

	private static void testdelete() throws Exception {
		CollegeBean bean = new CollegeBean();
		bean.setId(04);
		// Id dete hai sirf
//		bean.setName("Nikhil");
//		bean.setAddress("Indore");
//		bean.setState("Madhyapradesh");
//		bean.setCity("Indore");
//		bean.setPhoneNo("9223059021");
//		bean.setCreatedBy("nikhil@gmail.com");
//		bean.setModifiedBy("khaindait@gmail.com");
//		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		CollegeModel model = new CollegeModel();
		model.delete(bean);
		System.out.println("Done");

	}

	private static void testupdate() throws Exception {
		CollegeBean bean = new CollegeBean();

		bean.setName("Himanshi");
		bean.setAddress("Indore");
		bean.setState("Madhyapradesh");
		bean.setCity("Indore");
		bean.setPhoneNo("7223059021");
		bean.setCreatedBy("himanshi@gmail.com");
		bean.setModifiedBy("sharma@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(02);
		CollegeModel model = new CollegeModel();
		model.update(bean);
		System.out.println("Done");

	}

	private static void testadd() throws Exception {
		CollegeBean bean = new CollegeBean();
		// bean.setId(04);
		bean.setName("Raja");
		bean.setAddress("Indore");
		bean.setState("Madhyapradesh");
		bean.setCity("Indore");
		bean.setPhoneNo("6223059021");
		bean.setCreatedBy("raja@gmail.com");
		bean.setModifiedBy("varma@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		CollegeModel model = new CollegeModel();
		model.add(bean);
		System.out.println("Done");
	}

}
