package beans;
/**
 * Billbean POJO class implemented here.
 */
public class BillBean {
	private String bill_id;
	private String user_id;
	private String bill_no;
	private double amount;
	private String status;

	public String getbill_id() {
		return bill_id;
	}

	public void setbill_id(String bill_id) {
		this.bill_id = bill_id;
	}

	public String getuser_id() {
		return user_id;
	}

	public void setuser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getbill_no() {
		return bill_no;
	}

	public void setbill_no(String bill_no) {
		this.bill_no = bill_no;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}