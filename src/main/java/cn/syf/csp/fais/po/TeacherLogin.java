package cn.syf.csp.fais.po;

public class TeacherLogin {
    private Integer id;

    private String staffNumber;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber == null ? null : staffNumber.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	@Override
	public String toString() {
		return "TeacherLogin [id=" + id + ", staffNumber=" + staffNumber + ", password=" + password + "]";
	}
    
}