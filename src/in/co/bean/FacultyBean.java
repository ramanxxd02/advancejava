package in.co.bean;

import java.sql.Timestamp;
import java.util.Date;

public class FacultyBean extends BaseBean {
	

	private String first_name;
	private String last_name;
	private Date dob;
	private String gender;
	private String mobile_no;
	private String email;
	private long college_id;
	private String college_name;
	private long course_id;
	private String course_name;
	private long subject_id;
	private String subject_name;
	

	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getCollege_id() {
		return college_id;
	}
	public void setCollege_id(long college_id) {
		this.college_id = college_id;
	}
	public String getCollege_name() {
		return college_name;
	}
	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	public long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public long getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(long subject_id) {
		this.subject_id = subject_id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	
}
