package cn.syf.csp.fais.po;

public class SubjectCategory {
    private Integer id;

    private String subjectName;

    private Integer fid;

    public SubjectCategory(Integer id, String subjectName, Integer fid) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.fid = fid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

	@Override
	public String toString() {
		return "SubjectCategory [id=" + id + ", subjectName=" + subjectName + ", fid=" + fid + "]";
	}
    
    
}