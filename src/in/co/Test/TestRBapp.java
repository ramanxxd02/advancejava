package in.co.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestRBapp {
	public static void main(String[] args) {
//		ResourceBundle rb=ResourceBundle.getBundle("in.co.bundle.app");
//		System.out.println(rb.getString("greeting"));
//		System.out.println(rb.getString("msg"));
//	
//		ResourceBundle rb = ResourceBundle.getBundle("in.co.bundle.app", new Locale("sp"));
//
//		System.out.println(rb.getString("greeting"));
//		
		ResourceBundle rb = ResourceBundle.getBundle("in.co.bundle.app_hi");
		System.out.println(rb.getString("greeting"));
	}
	

}
