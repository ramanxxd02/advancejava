package in.co.tests;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.bean.SubjectBean;
import in.co.college.CollegeBean;
import in.co.model.SubjectModel;

public class SubjectTest {
	public static void main(String[] args) throws Exception {
		//testadd();
		//testupdate();
		//testdelete();
		//testsearch();
		testfindBypk();
	}

	private static void testfindBypk() throws Exception {
		SubjectBean bean=new SubjectBean();
		SubjectModel model=new SubjectModel();
		bean=model.findByPk(1);
		System.out.println(bean.getId());
		System.out.println(bean.getName());
		
	}

	private static void testsearch() throws Exception {
		SubjectBean bean =new SubjectBean();
		SubjectModel model =new SubjectModel();
		List list = new ArrayList();
		list = model.search(bean, 0, 0);
		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (SubjectBean) it.next();

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getName());

		}
		
	}

	private static void testdelete() throws Exception {
		SubjectBean bean =new SubjectBean();
		bean.setId(0);
		SubjectModel model=new SubjectModel();
		model.delete(bean);
		System.out.println("Done");
	}

	private static void testupdate() throws Exception {
		SubjectBean bean =new SubjectBean();
		bean.setName("megha");
		bean.setCourse_id(01);
		bean.setCourse_name("BSC");
		bean.setDescription("RSD");
		bean.setCreatedBy("megha@gmail.com");
		bean.setModifiedBy("patidar@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(1);
		SubjectModel model=new SubjectModel();
		model.update(bean);
		System.out.println("Done");
		
	}

	private static void testadd() throws Exception {
		SubjectBean bean=new SubjectBean();
		//bean.setId(1);
		bean.setName("Raman");
		bean.setCourse_id(01);
		bean.setCourse_name("BSC");
		bean.setDescription("RSD");
		bean.setCreatedBy("raman@gmail.com");
		bean.setModifiedBy("dange@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		SubjectModel model=new SubjectModel();
		model.add(bean);
		System.out.println("Done");
		
	}

}
