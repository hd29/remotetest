package com.xiaoyuan.service.inter;

import com.xiaoyuan.base.service.BaseServiceInter;
import com.xiaoyuan.domain.Users;

public interface UserServiceInter extends BaseServiceInter {
		//��֤�û��Ƿ���ڣ�����users�����������null����ʾ���û�������
	public Users check(Users user);
}
