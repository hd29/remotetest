package com.xiaoyuan.base.service;

import java.io.Serializable;
import java.util.List;

public interface BaseServiceInter {
	//通过一个hql语句和传入的参数完成响应的查询任务
	public List getResult(String hql,Object[] parameters);
	//保存一个对象
	public void save(Object obj);
	//删除
	public void delete(Object obj);
	//更新
	public void update(Object obj);
	//根据ID返回一个对象  用java.io包中的serSerializable
	public Object findById(Class clazz,Serializable id);
	
	
}
