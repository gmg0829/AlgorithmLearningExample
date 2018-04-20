import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class utils {

	public static List<Double> hb(double total,int num){ 
			 List<Double> hb = new ArrayList<Double>();
			
			double min =0.01;
			
			//将total随机分配到NuM个红包中
	         for(int i=1;i<num;i++){ 
	             double safe_total=(total-(num-i)*min)/(num-i); 

	             double money=Math.random()*(safe_total-min)+min; 
	          
	             BigDecimal money_bd=new BigDecimal(money); 
	             money=money_bd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();   
	             total=total-money; 
	             
	             BigDecimal total_bd=new BigDecimal(total); 

	             total=total_bd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue(); 

	             hb.add(money);
	         } 
			        hb.add(total);
	         return hb;
	        
	     } 

}
