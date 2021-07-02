package cn.syf.csp.fais.po;

public class NewStudent {
    private Integer id;

    private String name;

    private String candidateNumber;

    private Float grade;

    private String address;

    private String majorName;

    private String contact;

    private String fillTime;

    private String courierNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCandidateNumber() {
        return candidateNumber;
    }

    public void setCandidateNumber(String candidateNumber) {
        this.candidateNumber = candidateNumber == null ? null : candidateNumber.trim();
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName == null ? null : majorName.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getFillTime() {
        return fillTime;
    }

    public void setFillTime(String fillTime) {
        this.fillTime = fillTime == null ? null : fillTime.trim();
    }

    public String getCourierNumber() {
        return courierNumber;
    }

    public void setCourierNumber(String courierNumber) {
        this.courierNumber = courierNumber == null ? null : courierNumber.trim();
    }

	@Override
	public String toString() {
		return "NewStudent [id=" + id + ", name=" + name + ", candidateNumber=" + candidateNumber + ", grade=" + grade
				+ ", address=" + address + ", majorName=" + majorName + ", contact=" + contact + ", fillTime="
				+ fillTime + ", courierNumber=" + courierNumber + "]";
	}
    
}