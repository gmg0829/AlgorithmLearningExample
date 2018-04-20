import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MyData {
	
	List<Double> list =new ArrayList<Double>();
	
	public void test(){
		System.out.println("请输入红包数量");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		System.out.println("请输入金额");
		Scanner db = new Scanner(System.in);
		double total = in.nextDouble();
		list =  utils.hb(total, num);
	}
	private int j=0;  
	 public  synchronized void add(){
		 try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 if(j<list.size()){
			 System.out.println("用户："+Thread.currentThread().getName()+"抢得红包为："+list.get(j).doubleValue());
		 }else{
			 System.out.println("用户："+Thread.currentThread().getName()+"您手气慢了");
		 }
		 j++;
				 //if(i<list.size()){
		          //System.out.println("用户："+Thread.currentThread().getName()+"抢得红包为："+list.get(i).doubleValue());  
		          //i++; 
	 			//}else{
	 			//	
	 			//}  
	 }
}
