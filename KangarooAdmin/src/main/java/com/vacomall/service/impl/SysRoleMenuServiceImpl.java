package com.vacomall.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vacomall.entity.SysRoleMenu;
import com.vacomall.mapper.SysRoleMenuMapper;
import com.vacomall.service.ISysRoleMenuService;
import com.vacomall.service.support.BaseServiceImpl;

/**
 *
 * SysRoleMenu 表数据服务层接口实现类
 *
 */
@Service
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {

	@Override
	public void addAuth(String roleId, String[] menuIds) {
		// TODO Auto-generated method stub
		
		/**
		 * 删除原有权限
		 */
		SysRoleMenu sysRoleMenu = new SysRoleMenu();
		sysRoleMenu.setRoleId(roleId);
		this.deleteSelective(sysRoleMenu);
		/**
		 * 重新授权
		 */
		for(String menuId : menuIds){
			
			SysRoleMenu sysRoleMenu2 = new SysRoleMenu();
			sysRoleMenu2.setRoleId(roleId);
			sysRoleMenu2.setMenuId(menuId);
			this.insert(sysRoleMenu2);
		}
		
	}

	@Override
	public List<SysRoleMenu> selectByRole(String roleId) {
		// TODO Auto-generated method stub
		
		EntityWrapper<SysRoleMenu> ew = new EntityWrapper<SysRoleMenu>();
		ew.addFilter("roleId = {0}", roleId);
		return this.selectList(ew);
		
	}


}