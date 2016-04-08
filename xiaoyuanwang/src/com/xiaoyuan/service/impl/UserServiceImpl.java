package com.xiaoyuan.service.impl;

import java.util.List;

import com.xiaoyuan.base.service.BaseServiceImpl;
import com.xiaoyuan.domain.Users;
import com.xiaoyuan.service.inter.UserServiceInter;

public class UserServiceImpl extends BaseServiceImpl implements
		UserServiceInter {
	public Users check(Users user) {
		// TODO Auto-generated method stub
		List<Users>list= getResult("from Users where email=? and pwd=?",new Object[]{user.getEmail(),user.getPwd()});
		if(list.size()==1){
			return list.get(0);
		}else{
			return null;
		}
	}
		
}
