package cn.syf.csp.fais.service;

import java.util.List;

import cn.syf.csp.fais.po.Scholarship;

public interface ScholarshipService {
	
	public List<Scholarship> selectAll();
	
	public void insert(Scholarship scholarship);
	
	public void delete(int id);
	
	public void update(Scholarship scholarship);
	
	public Scholarship findById(int id);
	
	public int find(String candidateNumber,String name);
	
	public int findByCandidateNumber(String candidateNumber);
}
