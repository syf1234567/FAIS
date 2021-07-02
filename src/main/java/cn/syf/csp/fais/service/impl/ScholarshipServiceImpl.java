package cn.syf.csp.fais.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.syf.csp.fais.mapper.ScholarshipMapper;
import cn.syf.csp.fais.po.Scholarship;
import cn.syf.csp.fais.po.ScholarshipExample;
import cn.syf.csp.fais.service.ScholarshipService;

@Service
public class ScholarshipServiceImpl implements ScholarshipService{

	@Autowired
	private ScholarshipMapper scholarshipMapper;

	@Override
	public List<Scholarship> selectAll() {
		// TODO Auto-generated method stub
		return scholarshipMapper.selectByExample(null);
	}

	@Override
	public void insert(Scholarship scholarship) {
		// TODO Auto-generated method stub
		scholarshipMapper.insertSelective(scholarship);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		scholarshipMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Scholarship scholarship) {
		// TODO Auto-generated method stub
		scholarshipMapper.updateByPrimaryKeySelective(scholarship);
	}

	@Override
	public Scholarship findById(int id) {
		// TODO Auto-generated method stub
		return scholarshipMapper.selectByPrimaryKey(id);
	}

	@Override
	public int find(String candidateNumber, String name) {
		// TODO Auto-generated method stub
		return scholarshipMapper.find(candidateNumber, name);
	}

	@Override
	public int findByCandidateNumber(String candidateNumber) {
		// TODO Auto-generated method stub
		ScholarshipExample example = new ScholarshipExample();
		ScholarshipExample.Criteria criteria = example.createCriteria();
		criteria.andCandidateNumberEqualTo(candidateNumber);
		return scholarshipMapper.countByExample(example);
	}
	
	public void deleteAllData() {
		scholarshipMapper.deleteAllData();
	}
	
}
