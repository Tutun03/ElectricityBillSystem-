package beans;
/**
 * UserBean POJO class implemented
 */
public class UserBean {

	/**
	 *  adding all the attributes of the User Registration and login user as well
	 */
	
	private long consumerId;
	private int billNumber;
	private String customerName;
	private String email;
	private long mobileNo;
	private String userId;
	private String password;
	private String confirmpassword;
	public long getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(long consumerId) {
		this.consumerId = consumerId;
	}
	public int getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobile) {
		this.mobileNo = mobile;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	
}
