package cn.syf.csp.fais.service;

import java.util.List;

import cn.syf.csp.fais.po.Config;

public interface ConfigService {
public List<Config> selectAll();
	
	public int insert(Config config);
	
	public void delete(int id);
	
	public void updateEnableById(Integer id,String enable);
	
	public void update(Config config);
	
	public Config findById(int id);
	
	public List<Config> select(int page,int limit); 
	
	public List<Config> selectByType(String type);
	
	public List<String> getTypes();
	
	public Config findByConfigKey(String configKey);
}
