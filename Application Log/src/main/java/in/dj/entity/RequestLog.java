package in.dj.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_logs")
public class RequestLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String reqIpAddr;
	@Column(name = "req_path" ,length = 18)
	private String reqPath;
	private String reqDate;
	private String userName;
	private String methodName;
	private String userMac;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getReqIpAddr() {
		return reqIpAddr;
	}
	public void setReqIpAddr(String reqIpAddr) {
		this.reqIpAddr = reqIpAddr;
	}
	
	
	public String getReqDate() {
		return reqDate;
	}
	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}
	public RequestLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getReqPath() {
		return reqPath;
	}
	public void setReqPath(String reqPath) {
		this.reqPath = reqPath;
	}
	public String getUserMac() {
		return userMac;
	}
	public void setUserMac(String userMac) {
		this.userMac = userMac;
	}
	public RequestLog(Long id, String reqIpAddr, String reqPath, String reqDate, String userName, String methodName,
			String userMac) {
		super();
		Id = id;
		this.reqIpAddr = reqIpAddr;
		this.reqPath = reqPath;
		this.reqDate = reqDate;
		this.userName = userName;
		this.methodName = methodName;
		this.userMac = userMac;
	}
	
	
	
	
	

	
	
	



	
	
	
}
