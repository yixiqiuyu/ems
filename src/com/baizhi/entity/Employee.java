package com.baizhi.entity;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private int age;
	private String birthday;
	private String sex;
	private double score;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", age=" + age + ", birthday="
				+ birthday + ", sex=" + sex + ", score=" + score + "]";
	}
	public Employee(int id, String name, double salary, int age, String birthday, String sex, double score) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.birthday = birthday;
		this.sex = sex;
		this.score = score;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
}
