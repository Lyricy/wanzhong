package model;


public class TestCon {
	private int id;
	private String name;
	private String password;
	private Test1 testCon;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Test1 getTestCon() {
		return testCon;
	}
	public void setTestCon(Test1 testCon) {
		this.testCon = testCon;
	}
	@Override
	public String toString() {
		return "TestCon [id=" + id + ", name=" + name + ", password=" + password + ", testCon=" + testCon + "]";
	}
	
	
	
	
	
}
