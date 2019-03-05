package com.gmg.general;
import java.util.List;


public class ThreadDemo  implements Runnable{
		MyData data;
		public ThreadDemo(MyData data){
			this.data = data;
		}
		
		@Override
		public void run() {
			data.add();  
			
		}  


}
