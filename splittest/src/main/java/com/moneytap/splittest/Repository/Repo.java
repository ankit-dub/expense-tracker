package com.moneytap.splittest.Repository;

import com.moneytap.splittest.model.Usr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Usr,Integer> {

        public Usr findByEmail(String email);
}
