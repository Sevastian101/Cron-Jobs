package Entity;

import java.util.ArrayList;

/**
 * Created by sodobescu on 4/4/2017.
 */
public class Employees
{
	private int id;
	private String nickname;
	private int age;

	public static ArrayList<Employees> Employees = new ArrayList<>();

	public Employees(int id, String nickname, int age) {
		this.id = id;
		this.nickname = nickname;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return this.nickname+" "+age+" years old";
	}
}
