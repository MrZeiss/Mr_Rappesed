package com.ht.service;

import com.ht.bean.EmpLeave;
import com.ht.common.bean.Pager4EasyUI;
/**
 * 员工请假管理Service
 * @author xiaoqiang
 *
 */
public interface EmpLeaveService extends BaseService<EmpLeave> {
	/**
	 * 更新请假审核（老板）
	 * @param beanName
	 * @param idName
	 * @param status
	 * @param id
	 */
	public void updateSecondLevel(String beanName,String levelName, String idName, int secondLevel, String id);

	/**
	 * 通过员工Id查询请假分页
	 * @param pager
	 * @param empId
	 * @return
	 */
	public Pager4EasyUI<EmpLeave> byIdPager(Pager4EasyUI<EmpLeave> pager, String empId);
	
	/**
	 * 查询当前部门下的请假分页
	 * @param pager
	 * @param depId
	 * @return
	 */
	public Pager4EasyUI<EmpLeave> byDepIdPager(Pager4EasyUI<EmpLeave> pager, String depId);
}
