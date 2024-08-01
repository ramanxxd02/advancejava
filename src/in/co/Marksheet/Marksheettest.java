package in.co.Marksheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.preparedStatement.UserModel;
import in.co.preparedStatement.Userbean;

public class Marksheettest {
	public static void main(String[] args) throws Exception {
		//testadd();
		//testupdate();
		//testdelete();
		//testidget();
		testsearch();
		
		
	}

		private static void testsearch() throws Exception {
			Marksheetbean bean = new Marksheetbean();
			Marksheetmodel model = new Marksheetmodel();
			List list = new ArrayList();
		   // bean.setName("Raman");
			list = model.Search(bean);
			Iterator it = list.iterator();

			while (it.hasNext()) {
				bean = (Marksheetbean) it.next();
				System.out.println("\t"+bean.getId());
				System.out.println("\t"+bean.getRollno());
				System.out.println("\t"+bean.getName());
				System.out.println("\t"+bean.getPhysics());
				System.out.println("\t"+bean.getChemistry());
				System.out.println("\t"+bean.getMaths());
				
			}
		}
		
	

	private static void testidget() throws Exception {
		Marksheetbean bean=new Marksheetbean();
//	     bean.setId(1);
//	     bean.setRollno(120);
//	     bean.setName("Yogesh");
//	     bean.setPhysics(55);
//	     bean.setChemistry(75);
//	     bean.setMaths(65);
//	     
	     Marksheetmodel model=new Marksheetmodel();
	   
	     bean=model.idget(1);
	     System.out.println(bean.getName());
	}

	private static void testdelete() throws Exception {
		Marksheetbean bean=new Marksheetbean();
	     bean.setId(20);
	     bean.setRollno(120);
	     bean.setName("Yogesh");
	     bean.setPhysics(55);
	     bean.setChemistry(75);
	     bean.setMaths(65);
	     
	     Marksheetmodel model=new Marksheetmodel();
	     model.delete(bean);
	     System.out.println("done");
		
	}

	private static void testupdate() throws Exception {
		Marksheetbean bean=new Marksheetbean();
	     bean.setId(20);
	     bean.setRollno(120);
	     bean.setName("Yogesh");
	     bean.setPhysics(55);
	     bean.setChemistry(75);
	     bean.setMaths(65);
	     
	     Marksheetmodel model=new Marksheetmodel();
	     model.update(bean);
	     System.out.println("done");
		
	}

	private static void testadd() throws Exception {
		Marksheetbean bean=new Marksheetbean();
	     bean.setId(20);
	     bean.setRollno(120);
	     bean.setName("Yogesh");
	     bean.setPhysics(54);
	     bean.setChemistry(45);
	     bean.setMaths(35);
	     
	     Marksheetmodel model=new Marksheetmodel();
	     model.add(bean);
	     System.out.println("done");
		
	}
	
	
	

}
