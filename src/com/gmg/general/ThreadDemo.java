import java.util.List;


class ThreadDemo  implements Runnable{
		MyData data;
		public ThreadDemo(MyData data){
			this.data = data;
		}
		
		@Override
		public void run() {
			data.add();  
			
		}  


}
