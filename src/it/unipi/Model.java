package it.unipi;

/* This class allows to save different informations about each different hours*/
public class Model {
	private String time;
	private String condition;

	public Model(String time,String condition) {
		this.time = time;
		this.condition = condition;
	}

	public String getTime() {
		return time;
	}
	
	public String getCondition() {
		return condition;
	}
}
