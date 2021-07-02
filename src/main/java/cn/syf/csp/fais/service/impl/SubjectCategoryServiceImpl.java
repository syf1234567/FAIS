package cn.syf.csp.fais.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.syf.csp.fais.mapper.SubjectCategoryMapper;
import cn.syf.csp.fais.po.SubjectCategory;
import cn.syf.csp.fais.po.SubjectCategoryExample;
import cn.syf.csp.fais.service.SubjectCategoryService;

@Service
public class SubjectCategoryServiceImpl implements SubjectCategoryService{

	@Autowired
	private SubjectCategoryMapper subjectCategoryMapper;
	
	@Override
	public List<SubjectCategory> selectAll() {
		// TODO Auto-generated method stub
		return subjectCategoryMapper.selectByExample(null);
	}

	@Override
	public void insert(SubjectCategory subjectCategory) {
		// TODO Auto-generated method stub
		subjectCategoryMapper.insertSelective(subjectCategory);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		subjectCategoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(SubjectCategory subjectCategory) {
		// TODO Auto-generated method stub
		subjectCategoryMapper.updateByPrimaryKeySelective(subjectCategory);
	}

	@Override
	public SubjectCategory findById(int id) {
		// TODO Auto-generated method stub
		return subjectCategoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SubjectCategory> findByName(String name) {
		// TODO Auto-generated method stub
		SubjectCategoryExample example = new SubjectCategoryExample();
		SubjectCategoryExample.Criteria criteria = example.createCriteria();
		criteria.andSubjectNameEqualTo(name);
		return subjectCategoryMapper.selectByExample(example);
	}

	@Override
	public List<SubjectCategory> findByFid(Integer fid) {
		// TODO Auto-generated method stub
		SubjectCategoryExample example = new SubjectCategoryExample();
		SubjectCategoryExample.Criteria criteria = example.createCriteria();
		criteria.andFidEqualTo(fid);
		return subjectCategoryMapper.selectByExample(example);
	}

}
