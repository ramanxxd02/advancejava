package in.co.Test;

import java.util.ResourceBundle;

public class TestBundle {
	public static void main(String[] args) {
		ResourceBundle rb=ResourceBundle.getBundle("in.co.bundle.System");
		System.out.println("Driver--"+rb.getString("Driver"));
		System.out.println("url--"+rb.getString("url"));
		System.out.println("user--"+rb.getString("user"));
		System.out.println("password--"+rb.getString("password"));
	}

}
