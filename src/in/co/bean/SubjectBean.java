package in.co.bean;

import java.sql.Timestamp;

public class SubjectBean extends BaseBean {
	
	private String name;
	private long course_id;
	private String course_name;
	private String description;
	


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
