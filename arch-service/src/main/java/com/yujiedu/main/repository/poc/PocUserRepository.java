package com.yujiedu.main.repository.poc;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yujiedu.orm.poc.PocUser;

@Repository
@Transactional(readOnly = true)
public interface PocUserRepository extends JpaRepository<PocUser, String> {
	Page<PocUser> findAll(Pageable pageable);

	List<PocUser> findByUserId(String userId);

	// custom query example and return a stream
	@Query("select u from PocUser u where u.userId like :userId")
	Stream<PocUser> findByUserIdReturnStream(@Param("userId") String userId);

}