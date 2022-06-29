package p2;
import java.util.*;

class HexaOperation{
	
	String num1;
	String num2;
	
	public HexaOperation() {
		
	}
	public String add(String num1,String num2) {
		
		int deci1= HexaToDeci(num1);
		int deci2 = HexaToDeci(num2);
		int result;
		
		result = deci1+deci2;
		
		String hexaDeci = deciToHexa(result);
		
		return hexaDeci;
	}
	
	public String subtract(String num1,String num2) {
		
		int deci1= HexaToDeci(num1);
		int deci2 = HexaToDeci(num2);
		int result;
		if(deci1 >= deci2) {
			 result = deci1-deci2;
		}
		else {
			 result = deci2-deci1;
		}
		
		
		String hexaDeci = deciToHexa(result);
		
		return hexaDeci;
	}
	
	public String multiply(String num1,String num2) {
		
		int deci1=  HexaToDeci(num1);
		int deci2 = HexaToDeci(num2);
		
		int result;
		
		result = deci1*deci2;
		
		String hexaDeci = deciToHexa(result);
		
		return hexaDeci;
	}
	
	public String divide(String num1,String num2) {
		
		int deci1= HexaToDeci(num1);
		int deci2 = HexaToDeci(num2);
		
		int result;
		if(deci1 > deci2) {
			result= deci1/deci2;
		}
		else {
			result=deci2/deci1;
		}
		
		
		String hexaDeci = deciToHexa(result);
		
		return hexaDeci;
	}
	
	
	int compareTo(String num1, String num2) {  
	    int length1 = num1.length();  
	    int length2 = num2.length();  
	    int limit = Math.min(length1, length2);  
	    String v1 = num1;  
	    String v2 = num2;  
	   
	    int i = 0;  
	    while (i < limit) {  
	        
	        if (v1.charAt(i) != v2.charAt(i)) {  
	            return v1.charAt(i) - v2.charAt(i);  
	        }  
	        i++;  
	    }  
	    return length1 - length2;  
	}  
	
	
	public boolean checkEqual(String num1,String num2) {
		int result = compareTo("1AB","1AB");
		if(result==0) 
			return true;
		else
			return false;
		
		
	}
	public boolean checkSmaller(String num1,String num2) {
		
		int result = compareTo("1AB","1AB");
		if(result < 0) 
			return true;
		else
			return false;
	}
	public boolean checkGreater(String num1,String num2) {
		
	int result = compareTo("1AB","1AB");
	if(result>0) 
		return true;
	else
		return false;
	}
	
	
	
	
	
	public int HexaToDeci(String hexVal) {
		int len= hexVal.length();
		int base=1;
		int dec_val=0;
		for(int i=len-1;i>=0;i--) {
			
			 if (hexVal.charAt(i) >= '0'
		                && hexVal.charAt(i) <= '9') {
		                dec_val += (hexVal.charAt(i) - 48) * base;
		  
		                // Incrementing base by power
		                base = base * 16;
		            }
			 else if (hexVal.charAt(i) >= 'A'
                     && hexVal.charAt(i) <= 'F') {
                dec_val += (hexVal.charAt(i) - 55) * base;
  
                // Incrementing base by power
                base = base * 16;
            }
		}
		return dec_val;
	  }
	
	public String deciToHexa(int decimal)
	{
		int rem;  
	     String hex="";   
	     char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
	    while(decimal>0)  
	     {  
	       rem=decimal%16;   
	       hex=hexchars[rem]+hex;   
	       decimal=decimal/16;  
	     }  
	    return hex;  
		
	    
	}
	
}





public class HexaCalc {
	
	public static void main(String[] args) {
		
		HexaOperation op = new HexaOperation();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Hexadecimal String 1: ");
		String num1 = sc.next();
		System.out.println("Enter Hexadecimal String 1: ");
		String num2 = sc.next();
		
		boolean flag=true;
	
		System.out.println("1. Add Two Number: ");
		System.out.println("2. Subtract Two Number: ");
		System.out.println("3. Multiply Two Number: ");
		System.out.println("4. Divide Two Number: ");
		
		System.out.println("5. Convert to Decimal: ");
		System.out.println("6. Compare Two Number: ");
		System.out.println("7. Exit");
		System.out.println();
		
		while(flag)	{
		System.out.println("Which Operation To Perform: ");
		int choice = sc.nextInt();
		switch(choice) {
		
		case 1:
			System.out.println(op.add(num1, num2));
			break;
		
		case 2:
			System.out.println(op.subtract(num1, num2));
			break;
		
		case 3:
			System.out.println(op.multiply(num1, num2));
			break;
		
		case 4:
			System.out.println(op.divide(num1, num2));
			break;
		case 5:
			System.out.println(op.HexaToDeci(num1));
			System.out.println(op.HexaToDeci(num1));
			
			break;
		case 6:
			System.out.println(op.checkEqual(num1, num2));
			break;
		case 7:
			flag=false;
			
			break;
			
		}
		
	}
	}
}
