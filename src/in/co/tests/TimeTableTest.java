package in.co.tests;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.bean.TimeTableBean;
import in.co.model.TimeTableModel;

public class TimeTableTest {
	public static void main(String[] args) throws Exception {
//   	 testadd();
//		 testupdate();
//		 testdelete();
//		 testsearch();
//		 testfindByPk();
	}

	private static void testfindByPk() throws Exception {
		TimeTableBean bean = new TimeTableBean();
		TimeTableModel model = new TimeTableModel();
		bean = model.findByPk(1);
		System.out.println(bean.getId());
	}

	private static void testadd() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		TimeTableBean bean = new TimeTableBean();
		bean.setId(2);
		bean.setSemester("forth");
		bean.setDescription("student");
		bean.setExam_date(sdf.parse("2024-10-05"));
		bean.setExam_time("3pm");
		bean.setCourse_id(12345);
		bean.setCourse_name("pgdca");
		bean.setSubject_id(59);
		bean.setSubject_name("computer");
		bean.setCreatedBy("hima@123");
		bean.setModifiedBy("hima@123");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		TimeTableModel model = new TimeTableModel();
		model.add(bean);
	}

	private static void testupdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		TimeTableBean bean = new TimeTableBean();
		bean.setId(2);
		bean.setSemester("second");
		bean.setDescription("student");
//		bean.setExamDate(sdf.parse("2024-01-12"));
//		bean.setExamTime("11am");
//		bean.setCourse_id(120);
//		bean.setCourseName("dca");
//		bean.setSubjectId(56);
//		bean.setSubjectName("computer");
//		bean.setcreateby("hima@123");
//		bean.setmodifiedby("hima@123");
//		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		TimeTableModel model = new TimeTableModel();
		model.update(bean);

	}

	private static void testdelete() throws Exception {
		TimeTableBean bean = new TimeTableBean();
		bean.setId(3);
		TimeTableModel model = new TimeTableModel();
		model.delete(bean);
		System.out.println("done");
	}

	private static void testsearch() throws Exception {
		TimeTableBean bean = new TimeTableBean();
		TimeTableModel model = new TimeTableModel();
		List list = new ArrayList();
		list = model.search(bean, 0, 0);
		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (TimeTableBean) it.next();

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getSemester());

		}

	}

}
