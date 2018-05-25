/**
 *
 *  @author Domański Jan S14038
 *
 */

package Zad1;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Calc {
private Map<String,Method>operacje=new HashMap<>();
public Calc() {
	try{
operacje.put("+", this.getClass().getMethod("dodaj", BigDecimal.class,BigDecimal.class));
operacje.put("-", this.getClass().getMethod("odejmij", BigDecimal.class,BigDecimal.class));
operacje.put("*", this.getClass().getMethod("mnoz", BigDecimal.class,BigDecimal.class));
operacje.put("/", this.getClass().getMethod("podziel", BigDecimal.class,BigDecimal.class));
	}catch(Exception ex){
	}
}  

public BigDecimal dodaj(BigDecimal x, BigDecimal y) {
	// TODO Auto-generated method stub
	return x.add(y).setScale(7, RoundingMode.CEILING);
}
public BigDecimal odejmij(BigDecimal x, BigDecimal y) {
	// TODO Auto-generated method stub
	return x.subtract(y).setScale(7, RoundingMode.CEILING);
}
public BigDecimal mnoz(BigDecimal x, BigDecimal y) {
	// TODO Auto-generated method stub
	return x.multiply(y).setScale(7, RoundingMode.CEILING);
}
public BigDecimal podziel(BigDecimal x, BigDecimal y) {
	// TODO Auto-generated method stub
	return x.divide(y,7,RoundingMode.HALF_UP).stripTrailingZeros();
}


	public String doCalc(String string) {
		String oper[]=string.split("\\s+");
		try{
			Method m=operacje.get(oper[1]);
			return String.valueOf(m.invoke(this,new BigDecimal(oper[0]) ,new BigDecimal(oper[2])));
		 
		}catch(Exception ex){
			
			System.out.println("Invalid command to calc");
		}
		
		return null;
	}
}  
