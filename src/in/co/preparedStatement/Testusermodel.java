package in.co.preparedStatement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Testusermodel {
	public static void main(String[] args) throws Exception {

		 //testAdd();
		// testupdate();
		// testdelete();
		//testautoadd();
		 testsearch();
		 //testFindbyid();
	}

	private static void testFindbyid() {
		Userbean bean = new Userbean();
		
		

	}

	private static void testsearch() throws Exception {
		Userbean bean = new Userbean();
		UserModel model = new UserModel();
		List list = new ArrayList();
		// bean.setName("Shreya");
		list = model.search(bean);
		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (Userbean) it.next();
			System.out.print("\t" + bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.print("\t" + bean.getPost());
			System.out.println("\t" + bean.getSalary());
		}
	}

	private static void testautoadd() throws Exception {
		Userbean bean = new Userbean();
        
		bean.setId(13);
		bean.setName("Priya");
		bean.setPost("Advisior");
		bean.setSalary(30000);
	

		UserModel model = new UserModel();
		model.add(bean);
	}

	private static void testdelete() throws Exception {
		Userbean bean = new Userbean();
		bean.setId(0);
		bean.setName("dipali");
		bean.setPost("accountent");
		bean.setSalary(35000);
		UserModel model = new UserModel();
		model.delete(bean);

	}

	private static void testupdate() throws Exception {
		Userbean bean = new Userbean();

		bean.setId(11);
		bean.setName("Himanshi");
		bean.setPost("Boss");
		bean.setSalary(75000);

		UserModel model = new UserModel();
		model.update(bean);

	}

	private static void testAdd() throws Exception {

		Userbean bean = new Userbean();

		bean.setId(13);
		bean.setName("Priya");
		bean.setPost("Advisior");
		bean.setSalary(30000);
		System.out.println("done");

		UserModel model = new UserModel();
		model.add(bean);

	}

}
