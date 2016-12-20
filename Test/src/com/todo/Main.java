package com.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import model.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Student> list = new ArrayList<>();

		list.add(new Student("name1", 1));

		list.add(new Student("name2", 2));

		list.add(new Student("name3", 2));
		
		list.add(new Student("name1", 3));

		/**
		 * 方法一 
		 * 利用 Apache Commons Collections 工具类
		 * 下载地址 http://commons.apache.org/proper/commons-collections/download_collections.cgi
		 */
		Predicate<Student>predicate = new Predicate<Student>() {

			@Override
			public boolean evaluate(Student student) {
				// TODO Auto-generated method stub
				return student.getAge()==2;
			}
		};
		//找出age==2 的对象
		List<Student> result = (List<Student>) CollectionUtils.select( list, predicate);

		for (Student object : result) {
			System.out.println(object.getName());
		}
		
		/**
		 * 方法二
		 * In java8, using Lambdas and StreamAPI this should be:
		 * 需要安装Java8
		 */
		
		List<Student> result1 = list.stream()
			     .filter(item -> item.getName().equals("name1"))
			     .collect(Collectors.toList());
		//
		System.out.println("JAVA8------------------");
		for (Student object : result1) {
			System.out.println(object.getName());
		}

	}


}
