package cn.syf.csp.fais.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.syf.csp.fais.mapper.NewStudentMapper;
import cn.syf.csp.fais.po.NewStudent;
import cn.syf.csp.fais.po.NewStudentExample;
import cn.syf.csp.fais.service.NewStudentService;

@Service
public class NewStudentServiceImpl implements NewStudentService {

	@Autowired
	private NewStudentMapper newStudentMapper;

	@Override
	public List<NewStudent> selectAll() {
		// TODO Auto-generated method stub
		return newStudentMapper.selectByExample(null);
	}

	@Override
	public void insert(NewStudent NewStudent) {
		// TODO Auto-generated method stub
		newStudentMapper.insertSelective(NewStudent);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		newStudentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(NewStudent NewStudent) {
		// TODO Auto-generated method stub
		newStudentMapper.updateByPrimaryKeySelective(NewStudent);
	}

	@Override
	public NewStudent findById(int id) {
		// TODO Auto-generated method stub
		return newStudentMapper.selectByPrimaryKey(id);
	}

	@Override public NewStudent find(String candidateNumber, String name) { 
		//TODO Auto-generated method stub
		return newStudentMapper.find(candidateNumber,name); 
		}

	@Override
	public int findCountByCandidateNumber(String candidateNumber) {
		// TODO Auto-generated method stub
		NewStudentExample example = new NewStudentExample();
		NewStudentExample.Criteria criteria = example.createCriteria();
		criteria.andCandidateNumberEqualTo(candidateNumber);
		return newStudentMapper.countByExample(example);
	}
	
	@Override
	public List<NewStudent> findByCandidateNumber(String candidateNumber) {
		// TODO Auto-generated method stub
		NewStudentExample example = new NewStudentExample();
		NewStudentExample.Criteria criteria = example.createCriteria();
		criteria.andCandidateNumberEqualTo(candidateNumber);
		return newStudentMapper.selectByExample(example);
	}

	public void deleteAllData() {
		newStudentMapper.deleteAllData();
	}

}
