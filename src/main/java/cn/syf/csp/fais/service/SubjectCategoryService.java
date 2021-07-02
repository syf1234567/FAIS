package cn.syf.csp.fais.service;

import java.util.List;

import cn.syf.csp.fais.po.SubjectCategory;

public interface SubjectCategoryService {
		
	public List<SubjectCategory> selectAll();
	
	public void insert(SubjectCategory subjectCategory);
	
	public void delete(int id);
	
	public void update(SubjectCategory subjectCategory);
	
	public SubjectCategory findById(int id);
	
	public List<SubjectCategory> findByName(String name);
	
	public List<SubjectCategory> findByFid(Integer fid);
	
}
