package com.xiaoyuan.base.service;

import java.io.Serializable;
import java.util.List;

public interface BaseServiceInter {
	//ͨ��һ��hql���ʹ���Ĳ��������Ӧ�Ĳ�ѯ����
	public List getResult(String hql,Object[] parameters);
	//����һ������
	public void save(Object obj);
	//ɾ��
	public void delete(Object obj);
	//����
	public void update(Object obj);
	//����ID����һ������  ��java.io���е�serSerializable
	public Object findById(Class clazz,Serializable id);
	
	
}
