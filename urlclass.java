import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class urlclass {

	public static void main(String[] args) {
		try{
			URL url = new URL("https://www.google.com/");
			InputStream s = null;
			System.out.println(url.getProtocol());
			s = url.openStream();
            byte[] b = new byte[8];
            while(s.read(b) != -1){
                System.out.print(new String(b));
            }
            System.gc();
		}catch(MalformedURLException e){
			e.printStackTrace();
			System.out.println();
		}catch(IOException e){
			e.printStackTrace();
			System.out.println();
		}
		
        try {
            InetAddress ipAddr = InetAddress.getLocalHost();
            System.out.println(ipAddr.getHostName());
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }


	}

}
