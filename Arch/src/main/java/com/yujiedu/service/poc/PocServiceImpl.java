package com.yujiedu.service.poc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.yujiedu.orm.poc.PocUser;
import com.yujiedu.repository.poc.PocUserRepository;

@Service("pocService")
@Transactional(readOnly = true)
public class PocServiceImpl implements IPocService {
	private static Logger logger = LoggerFactory.getLogger(PocServiceImpl.class);

	@Autowired
	private PocUserRepository pocUserRepository;

	public PocServiceImpl() {
	}

	@Override
	public void log(String msg) {
		logger.info(String.format("log():   msg=%s", msg));
	}

	@Override
	public PocUser findUserById(String userId) {
		List<PocUser> pocUserList = pocUserRepository.findByUserId(userId);
		logger.info(String.format("pocUser count: %d, found by userId(%s): %d", pocUserRepository.count(), userId,
				pocUserList.size()));
		if (pocUserList.isEmpty())
			return null;
		else
			return pocUserList.get(0);
	}

	@Override
	public List<PocUser> findAllPocUsers() {
		List<PocUser> list = pocUserRepository.findAll();
		return list;
	}

	@Override
	public List<PocUser> findUsersById(String userId) {
		if (StringUtils.isEmpty(userId)) {
			return null;
		}
		Stream<PocUser> stream = pocUserRepository.findByUserIdReturnStream("%" + userId + "%");
		return stream.collect(Collectors.toList());
	}
	// public List<PocEmp> findAllEmpployees() {
	// DetachedCriteria criteria = DetachedCriteria.forClass(PocEmp.class);
	// criteria.createAlias("pocDep", "dep", JoinType.LEFT_OUTER_JOIN);
	// criteria.addOrder(Order.asc("empNo"));
	//
	// return this.findByCriteria(criteria);
	// }
	//
	// public String createEmployee(PocEmp emp) {
	// if (emp == null)
	// return null;
	//
	// PocDep dep = emp.getPocDep();
	// if (dep != null) {
	//
	// String depName = dep.getDepName();
	// if (!StringUtils.isEmpty(depName)) {
	// PocDep dbDep = getDepartment(depName);
	// if (dbDep == null) {
	// if (StringUtils.isNullOrEmpty(dep.getDepUuid())) {
	// dep.setDepUuid(IdGenerator.getUUID());
	// }
	// dep.setRecCrtDt(new Date());
	// this.saveEntity(dep);
	// } else {
	// emp.setPocDep(dbDep);
	// }
	// }
	// }
	//
	// if (StringUtils.isNotEmpty(emp.getEmpUuid())) {
	// emp.setEmpUuid(IdGenerator.getUUID());
	// }
	// emp.setRecCrtDt(new Date());
	// this.saveEntity(emp);
	// return emp.getEmpUuid();
	// }
	//
	// @Override
	// public int updateEmployee(PocEmp emp) {
	// if (emp == null)
	// return 0;
	// int rows = 0;
	//
	// PocDep dep = emp.getPocDep();
	// PocDep dbDep = null;
	// if (dep != null) {
	// String depName = dep.getDepName();
	// if (StringUtils.isNotEmpty(depName)) {
	// dbDep = getDepartment(depName);
	// if (dbDep == null) {
	// if (StringUtils.isNullOrEmpty(dep.getDepUuid())) {
	// dep.setDepUuid(IdGenerator.getUUID());
	// }
	// dep.setRecCrtDt(new Date());
	// this.saveOrUpdateEntity(dep);
	// dbDep = dep;
	// rows++;
	// } else {
	// emp.setPocDep(dbDep);
	// }
	// }
	// }
	// PocEmp dbPocEmp = this.getEmployee(emp.getEmpNo());
	// if (dbPocEmp == null)
	// throw new RuntimeException("Not found the employee, empNo=" +
	// emp.getEmpNo() + ".");
	//
	// BeanUtil.copyBeans(emp, dbPocEmp, new String[] { "firstName", "lastName"
	// });
	// dbPocEmp.setPocDep(dbDep);
	// this.updateEntity(dbPocEmp);
	// return ++rows;
	// }
	//
	// @Transactional(readOnly = true)
	// public PocDep getDepartment(String depName) {
	// DetachedCriteria criteria = DetachedCriteria.forClass(PocDep.class);
	// criteria.add(Restrictions.eq("depName", depName));
	//
	// List<PocDep> list = this.findByCriteria(criteria);
	// if (list.isEmpty())
	// return null;
	// else
	// return list.get(0);
	// }
	//
	// @Override
	// public int deleteEmployee(String employeeNo) {
	// PocEmp emp = this.getEmployee(employeeNo);
	// if (emp != null) {
	// this.deleteEntity(emp);
	// return 1;
	// } else
	// return 0;
	// }
	//
	// // @Override
	// // public int deleteAllEmployees() {
	// // // use HQL to insert/update/delete will not trigger event
	// // return employeeDao.deleteAllEmployees();
	// // }
	//
	// public PocEmp getEmployee(String employeeNo) {
	// if (StringUtils.isNotEmpty(employeeNo))
	// return null;
	//
	// DetachedCriteria criteria = DetachedCriteria.forClass(PocEmp.class);
	// criteria.createAlias("pocDep", "dep", JoinType.LEFT_OUTER_JOIN);
	// criteria.add(Restrictions.eq("empNo", employeeNo));
	//
	// List<PocEmp> list = this.findByCriteria(criteria);
	// if (list.isEmpty())
	// return null;
	// else
	// return list.get(0);
	// }

}
