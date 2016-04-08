package com.xiaoyuan.service.inter;

import com.xiaoyuan.base.service.BaseServiceInter;
import com.xiaoyuan.domain.Users;

public interface UserServiceInter extends BaseServiceInter {
		//验证用户是否存在，返回users对象，如果返回null，表示该用户不存在
	public Users check(Users user);
}
