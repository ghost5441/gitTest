import java.util.ArrayList;
import java.util.List;

public class IpCheck3 {

	public static void main(String[] args) {
		System.out.println("결과 : " + IpCheck3.allowedCheck("22.33.0.0"));
	}

	public static boolean allowedCheck(String ip) {
		
		for(String allowed_ip : IpCheck3.ipList()) {
			
			// 허용 IP에 *이 있으면 허용IP, 체크IP 각각 split(".") 한다
			if(allowed_ip.contains("*")) {
				String[] allowed_ip_temp = allowed_ip.split("\\.");
				String[] ip_temp = ip.split("\\.");
				for(int i=0; i<allowed_ip_temp.length; i++) {
					// 허용 IP에 *이 있으면 체크 IP 값을 넣는다
					if(allowed_ip_temp[i].equals("*")) {
						allowed_ip_temp[i] = ip_temp[i];
					}
				}
				
				allowed_ip = allowed_ip_temp[0] + "." + allowed_ip_temp[1] + "." + allowed_ip_temp[2] + "." + allowed_ip_temp[3];
			}

			if(allowed_ip.equals(ip)) {
				return true;
			}
		}
		
		return false;
	}

	// 허용 IP에 추가한 Ip 리스트
	public static List<String> ipList() {
		
		List<String> ipList = new ArrayList<String>();

		ipList.add("1.168.0.1");
		ipList.add("*.168.0.*");
		ipList.add("*.168.0.*");
		ipList.add("*.168.0.*");
		ipList.add("*.168.0.*");
		ipList.add("*.*.0.*");
		ipList.add("*.168.0.*");
		ipList.add("22.33.0.*");
		
		return ipList;
	}
	
}
