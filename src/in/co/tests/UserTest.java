package in.co.tests;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.bean.UserBean;
import in.co.model.UserModel;

public class UserTest {
	public static void main(String[] args) throws Exception {
		//testadd();
		//testupdate();
		//testdelete();
		//testauth();
		testsearch();
		
	}
	private static void testsearch() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		UserBean bean = new UserBean();
		// bean.setFirstName("a");
		// bean.setDob(sdf.parse("02/04/2001"));

		UserModel model = new UserModel();

		List list = model.search(bean, 1, 5);

		Iterator it = list.iterator();
		while(it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstname());
			System.out.print("\t" + bean.getLastname());
			System.out.print("\t" + bean.getLoginid());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t"+bean.getConfirmpassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t"+bean.getMobileno());
			System.out.println("\t"+bean.getRoleid());
			System.out.println("\t"+bean.getGender());
			System.out.println("\t"+bean.getCreatedBy());
			System.out.println("\t"+bean.getModifiedBy());
			System.out.println("\t"+bean.getCreatedDatetime());
			System.out.println("\t"+bean.getModifiedDatetime());
		}
		}
		

	private static void testauth() throws Exception {
		UserModel model = new UserModel();

		UserBean bean = model.authenticate("raman@gmail.com", "123");
		if (bean != null) {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstname());
			System.out.print("\t" + bean.getLastname());
			System.out.print("\t" + bean.getLoginid());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t"+bean.getConfirmpassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t"+bean.getMobileno());
			System.out.println("\t"+bean.getRoleid());
			System.out.println("\t"+bean.getGender());
			System.out.println("\t"+bean.getCreatedBy());
			System.out.println("\t"+bean.getModifiedBy());
			System.out.println("\t"+bean.getCreatedDatetime());
			System.out.println("\t"+bean.getModifiedDatetime());
			

		} else {
			System.out.println("login id & password is invalid...!!");
		}
		
	}

	private static void testdelete() throws Exception {
		UserModel model = new UserModel();

		UserBean existBean = model.findByPK(3);

		if (existBean != null) {
			model.delete(existBean.getId());
		} else {
			System.out.println("Id not found...!!!");
		}
		
	}

	private static void testupdate() throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
		//UserBean bean=new UserBean();
		UserModel model=new UserModel();
	UserBean bean =model.findByPK(2);
	bean.setId(2);
	bean.setFirstname("Vishal");
	bean.setLastname("Dange");
	bean.setLoginid("vishal@gmail.com");
	bean.setPassword("12345");
	bean.setConfirmpassword("12345");
	bean.setDob(sdf.parse("04/10/2002"));
	bean.setMobileno("6223059021");
	bean.setRoleid(01);
	bean.setGender("male");
	bean.setCreatedBy("vishal@gamail.com");
	bean.setModifiedBy("dange@gmail.com");

		model.update(bean);
		System.out.println(bean.getLastname());
		
		
	}

	private static void testadd() throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
		UserBean bean=new UserBean();
		bean.setId(3);
		bean.setFirstname("Raman");
		bean.setLastname("rana");
		bean.setLoginid("nitesh@gmail.com");
		bean.setPassword("12345");
		bean.setConfirmpassword("12345");
		bean.setDob(sdf.parse("02/04/2001"));
		bean.setMobileno("9223059021");
		bean.setRoleid(01);
		bean.setGender("male");
		bean.setCreatedBy("nitesh@gamail.com");
		bean.setModifiedBy("rana@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		UserModel model=new UserModel();
		model.add(bean);
		System.out.println("done");
		
		
	}
	

}
