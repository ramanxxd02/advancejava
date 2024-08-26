package in.co.tests;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.bean.MarksheetBean;
import in.co.college.CollegeBean;
import in.co.model.CollegeModel;
import in.co.model.MarksheetModel;

public class MarksheetTest {
	public static void main(String[] args) throws Exception {
		 testadd();
		//testupdate();
		//testdelete();
		//testsearch();
		//testfindByPk();
	}
	private static void testfindByPk() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		bean = model.findByPk(1);
		System.out.println(bean.getName());
	}

	private static void testadd() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		bean.setId(3);
		bean.setRollNo("111");
		bean.setStudentId(124);
		bean.setName("raman");
		bean.setPhysics(56);
		bean.setChemistry(79);
		bean.setMaths(77);
		bean.setCreatedBy("");
		bean.setModifiedBy("");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		MarksheetModel model = new MarksheetModel();
		model.add(bean);
	}

	private static void testupdate() throws Exception {

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = new MarksheetBean();
		bean.setId(1);
		bean.setRollNo("103");
		bean.setStudentId(223);
		bean.setName("megha");
		bean.setPhysics(78);
		bean.setChemistry(60);
		bean.setMaths(90);
		bean.setCreatedBy("");
		bean.setModifiedBy("");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);

	}

	private static void testdelete() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(3);
//		bean.setRollNo("103");
//		bean.setStudentId(223);
//		bean.setName("megha");
//		bean.setPhysics(78);
//		bean.setChemistry(60);
//		bean.setMaths(90);
//		bean.setCreatedBy("");
//		bean.setModifiedBy("");
//		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		MarksheetModel model = new MarksheetModel();
		model.delete(bean);
		System.out.println("done");
	}
	private static void testsearch() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		List list = new ArrayList();
		list = model.search(bean, 0, 0);
		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (MarksheetBean) it.next();

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getRollNo());

		}
	}

}
