package in.co.tests;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import in.co.bean.RoleBean;
import in.co.model.Rolemodel;
import in.co.preparedstatement.UserBean;


public class RoleTests {
	public static void main(String[] args) throws Exception {
		//testadd();
		//testupdate();
		testdelete();
		//testsearch();
		//testfindByPK();
	}

	private static void testfindByPK() throws Exception {
		RoleBean bean=new RoleBean();
		Rolemodel model=new Rolemodel();
		bean=model.findByPK(1);
		System.out.println(bean.getName()+ " "+bean.getDiscription());
		
	}

	private static void testsearch() throws Exception {
		RoleBean bean=new RoleBean();
		//bean.setId(1);
		//bean.setName("raman");
		Rolemodel model=new Rolemodel();
		List list= model.search(bean, 1, 2);
		Iterator it=list.iterator();
		while(it.hasNext()) {
			bean = (RoleBean) it.next();
			System.out.println(bean.getId());
			System.out.println("\t"+bean.getName());
			System.out.println("\t"+bean.getDiscription());
			System.out.println("\t"+bean.getCreatedBy());
			System.out.println("\t"+bean.getModifiedBy());
			System.out.println("\t"+bean.getCreatedDatetime());
			System.out.println("\t"+bean.getModifiedDatetime());
			
		}
		
		
	}

	private static void testdelete() throws Exception {
		RoleBean bean= new RoleBean();
		Rolemodel model=new Rolemodel();
		model.delete(3);
		System.out.println("Done");
		
	}

	private static void testupdate() throws Exception {
		RoleBean bean=new RoleBean();
		
		bean.setName("Himanshi");
		bean.setDiscription("i am designer");
		bean.setCreatedBy("Himanshi@gmail.com");
		bean.setModifiedBy("Sharma@gmail.com");
//		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(03);
		Rolemodel model=new Rolemodel();
		model.update(bean);
		System.out.println("done");
		
	}

	private static void testadd() throws Exception {
		RoleBean bean=new RoleBean();
		bean.setId(03);
		bean.setName("himanshi");
		bean.setDiscription("i am student");
		bean.setCreatedBy("himanshi@gmail.com");
		bean.setModifiedBy("sharma@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		Rolemodel model=new Rolemodel();
		model.add(bean);
		System.out.println("Done");
		
	}

}
