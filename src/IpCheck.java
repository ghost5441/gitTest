import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class IpCheck {

	public static void main(String[] args) {
		
		try {
			
			String my = Inet4Address.getLocalHost().getHostAddress();
			
			System.out.println("######## : " + my);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    

	}
	
	
}
