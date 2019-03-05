package com.gmg.general;
import com.gmg.general.MyData;
import com.gmg.general.ThreadDemo;
import java.util.List;
import java.util.Scanner;


public class ThreadTest {

	public static void main(String[] args) {
		
		MyData myData = new MyData();
		myData.test();
		System.out.println("红包准备完毕，请设定抢红包人数");
		Scanner in1 = new Scanner(System.in);
		int count = in1.nextInt();
		Runnable thread = new ThreadDemo(myData);
		
		for(int i=1;i<=count;i++){
			 new Thread(thread).start();  
		
		}
	}


	

}
