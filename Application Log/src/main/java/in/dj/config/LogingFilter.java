package in.dj.config;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import in.dj.entity.RequestLog;
import in.dj.service.RequestLogService;

@Configuration
public class LogingFilter implements HandlerInterceptor {

	@Autowired
	private RequestLogService logService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String remoteAddr = request.getRemoteAddr();
		String requestURI = request.getRequestURI();
		String methodname = request.getMethod();
		String username = request.getRemoteUser();
		// String mac=request.getHeader("x-client-mac");
//		request.logout();

		// DITSDD-PC115/192.168.254

//		  InetAddress localIp=InetAddress.getByName(remoteAddr); NetworkInterface
//	  ni=NetworkInterface.getByInetAddress(localIp); byte[]
//		 macAddress=ni.getHardwareAddress();
//		System.err.println(macAddress+"dsggggggggggggggggggggggggggggg");

//		 InetAddress loca=InetAddress.getLocalHost();
//		 System.err.println(loca+"fffffffffffghhhhhhhh");
//		 NetworkInterface
//		 ni=NetworkInterface.getByInetAddress(loca); byte[]
//		  hardwareAddress=ni.getHardwareAddress();
//		 
//		  String[] hexadecimal=new String[hardwareAddress.length]; 
//		  for (int i=0;i<hardwareAddress.length;i++)
//		  { 
//			  hexadecimal[i]=String.format("%02x",hardwareAddress[i]);
//			  } 
//		  String macaddr=String.join("-", hexadecimal);
//		
//			System.err.println(macaddr+"dsggggggggggggggggggggggggggggg");
		StringBuilder sb = new StringBuilder();
		try {
			InetAddress inetAddress = InetAddress.getByName(remoteAddr);
			System.err.println(NetworkInterface.getByInetAddress(inetAddress)+"=========inetAddress======"+inetAddress);
//			name:eth9 (Intel(R) Ethernet Connection (17) I219-LM)=========inetAddress======/10.66.40.106
			NetworkInterface network = NetworkInterface.getByInetAddress(inetAddress);
			System.err.println("=========network======"+network);
			byte[] mac = network.getHardwareAddress();

			if (mac != null) {
				for (int i = 0; i < mac.length; i++) {
					sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
				}
			}
			System.err.println("MAC Address: " + sb.toString());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}

		String logDate = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss").format(new Date());
		Date reqDate = new Date();
		RequestLog log = new RequestLog();
		log.setReqPath(requestURI.toString());
		log.setReqIpAddr(remoteAddr);
//		log.setReqDate(reqDate);
		log.setReqDate(logDate);
		log.setMethodName(methodname);
		log.setUserName(username);
		log.setUserMac(sb.toString());
		logService.saveUserLog(log);

		// return HandlerInterceptor.super.preHandle(request, response, handler);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
