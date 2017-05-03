import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class randomchar {

	public String generate(int setlen){
		String str ="abcdefghijklmnopqrstuvwxyz";
		StringBuffer result = new StringBuffer();
		for (int i=1;i<=setlen;i++){
			//System.out.println(getnum(2));
			result.append(str.charAt(getnum(str.length())));
			result.append(" ");
		}
		
		return (format(result.toString()));
	}
	
	public int getnum(int len){
		Random r = new Random();
		return r.nextInt(len);
	}
	
	public String format(String str){
		//Pattern p = Pattern.compile("(\\w)(\\s+)");
		//Matcher m = p.matcher(str);
		return (str.replaceAll("(\\w)(\\s)(\\s+)?", "$1$2"));
	}
	
	public boolean check(String str){
		Pattern p = Pattern.compile("^[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)*@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)*(\\.[a-zA-Z]{2,})$");
		Matcher m = p.matcher(str);
		if(m.matches()){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean checkdt(String str){
		Pattern p = Pattern.compile("^((0?[1-9])|(1[1-2]))\\\\((0?[1-9])|([1-2][0-9])|(3[0-1]))/([1-9][0-9][0-9][0-9])");
		Matcher m = p.matcher(str);
		if(m.matches()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		randomchar t =new randomchar();
		/*System.out.println(t.generate(10));
		System.out.println(t.generate(10));
		System.out.println(t.generate(10));
		System.out.println(t.generate(10));
		System.out.println(t.generate(10));
		System.out.println(t.generate(10));*/
		System.out.println(t.check("sendurr1.____sdsd@hotmail.com.com"));
		System.out.println(t.checkdt("01\\01/2001"));
		

	}

}
