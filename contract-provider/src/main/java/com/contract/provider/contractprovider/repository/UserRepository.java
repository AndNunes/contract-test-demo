package com.contract.provider.contractprovider.repository;

import com.contract.provider.contractprovider.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT user from user u WHERE u.cpf = ?1")
    User findByCpf(String cpf);
}
