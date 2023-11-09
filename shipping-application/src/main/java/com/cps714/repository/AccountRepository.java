package com.cps714.repository;

import com.cps714.objects.users.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findByAccountID(Integer accountID);

}