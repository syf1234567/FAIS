package cn.syf.csp.fais.po;

public class Scholarship {
    private Integer id;

    private String name;

    private String candidateNumber;

    private Integer subjectCategoryId;

    private Float grade;

    private String volunteerNumber;

    private Integer majorId;

    private String contact;

    private String fillTime;

    
    
    public Scholarship(Integer id, String name, String candidateNumber, Integer subjectCategoryId, Float grade,
			String volunteerNumber, Integer majorId, String contact, String fillTime) {
		super();
		this.id = id;
		this.name = name;
		this.candidateNumber = candidateNumber;
		this.subjectCategoryId = subjectCategoryId;
		this.grade = grade;
		this.volunteerNumber = volunteerNumber;
		this.majorId = majorId;
		this.contact = contact;
		this.fillTime = fillTime;
	}

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

    public Integer getSubjectCategoryId() {
        return subjectCategoryId;
    }

    public void setSubjectCategoryId(Integer subjectCategoryId) {
        this.subjectCategoryId = subjectCategoryId;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public String getVolunteerNumber() {
        return volunteerNumber;
    }

    public void setVolunteerNumber(String volunteerNumber) {
        this.volunteerNumber = volunteerNumber == null ? null : volunteerNumber.trim();
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
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

	@Override
	public String toString() {
		return "Scholarship [id=" + id + ", name=" + name + ", candidateNumber=" + candidateNumber
				+ ", subjectCategoryId=" + subjectCategoryId + ", grade=" + grade + ", volunteerNumber="
				+ volunteerNumber + ", majorId=" + majorId + ", contact=" + contact + ", fillTime=" + fillTime + "]";
	}

}