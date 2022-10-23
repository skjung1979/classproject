package mem.domain;

//project MemManager
public class Mem {

	private String membercd;
	private String name;
	private String phonenumber;
	private String address;
	private String mallid;
	private String pass;
	
	public Mem() {
		super();
	}	
	
	public Mem(String membercd, String name, String phonenumber, String address, String mallid, String pass) {
		super();
		this.membercd = membercd;
		this.name = name;
		this.phonenumber = phonenumber;
		this.address = address;
		this.mallid = mallid;
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Mem [membercd=" + membercd + ", name=" + name + ", phonenumber=" + phonenumber + ", address=" + address
				+ ", mallid=" + mallid + ", pass=" + pass + "]";
	}

	public String getMembercd() {
		return membercd;
	}

	public void setMembercd(String membercd) {
		this.membercd = membercd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMallid() {
		return mallid;
	}

	public void setMallid(String mallid) {
		this.mallid = mallid;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
