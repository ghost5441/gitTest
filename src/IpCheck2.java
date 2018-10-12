import java.util.ArrayList;
import java.util.List;

public class IpCheck2 {

	public static void main(String[] args) {
		System.out.println("결과 : " + IpCheck2.allowedCheck("196.111.0.1"));
	}

	public static boolean allowedCheck(String ip){
		
		// 체크할 IP
		String[] ip_temp = ip.split("\\.");
		
		// 허용 IP 리스트
		List<String> allowed_ip_List = IpCheck2.ipList();
		
		// 허용 IP 리스트 임시 변수
    	@SuppressWarnings ("unused")
    	String[] allowed_ip_temp;
		
		for(int i=0; i<allowed_ip_List.size(); i++) {
			
			String allowed_ip = allowed_ip_List.get(i);
			
			// 허용 IP에 *이 있으면 *은 체크Ip로 값을 넣음
			if(allowed_ip.contains("*")) {
				
				// 허용 IP 임시 변수에 '.'을 기준으로 4개의 값을 만든다.
				allowed_ip_temp = allowed_ip.split("\\.");
				
				for(int j=0; j<allowed_ip_temp.length; j++) {
					// 4개의 값중 *이면 체크 할 Ip의 값을 넣는다
					if(allowed_ip_temp[j].equals("*")) {
						allowed_ip_temp[j] = ip_temp[j];
					}
				}
				
				// *은 곧 체크할 ip값으로 만든다
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
		
		return ipList;
	}
	
}
