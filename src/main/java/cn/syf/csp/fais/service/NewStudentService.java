package cn.syf.csp.fais.service;

import java.util.List;

import cn.syf.csp.fais.po.NewStudent;

public interface NewStudentService {
	
	public List<NewStudent> selectAll();
	
	public void insert(NewStudent newStudent);
	
	public void delete(int id);
	
	public void update(NewStudent newStudent);
	
	public NewStudent findById(int id);
	
	public NewStudent find(String candidateNumber,String name);
	
	public int findCountByCandidateNumber(String candidateNumber);
	
	public List<NewStudent> findByCandidateNumber(String candidateNumber);
}
