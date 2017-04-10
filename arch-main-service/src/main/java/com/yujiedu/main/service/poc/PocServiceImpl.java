package com.yujiedu.main.service.poc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.yujiedu.main.repository.poc.PocUserRepository;
import com.yujiedu.main.state.Events;
import com.yujiedu.main.state.States;
import com.yujiedu.orm.poc.PocUser;
import com.yujiedu.service.poc.IPocService;

@Service("pocService")
@Transactional(readOnly = true)
public class PocServiceImpl implements IPocService {
	private static Logger logger = LoggerFactory.getLogger(PocServiceImpl.class);

	@Autowired
	private PocUserRepository pocUserRepository;
	@Autowired
	private StateMachine<States, Events> stateMachine;

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

	@Override
	public void changeState() {
		stateMachine.start();
		stateMachine.sendEvent(Events.PAY);
		stateMachine.sendEvent(Events.RECEIVE);
	}

}
