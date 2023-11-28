package com.cps714.repository;

import com.cps714.objects.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Repository access Admin table (unused)
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByAdminID(Integer adminID);
}