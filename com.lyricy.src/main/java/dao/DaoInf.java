package dao;

import java.util.List;

import model.Functions;
import model.Test1;
import model.Users;

public interface DaoInf {
	public List<Users> getUsersByName(String username);
	public List<Functions> getMenuByName(String username);
	public List<Test1> geTest1s();
	public Test1 geTest1(int code);
	public void insertTest1(Test1 test1);
	public void updateTest1(Test1 test1);
	public void deleteTest1(int code);
}
