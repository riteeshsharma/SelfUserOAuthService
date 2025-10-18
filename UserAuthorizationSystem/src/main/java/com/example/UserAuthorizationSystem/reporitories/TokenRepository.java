package com.example.UserAuthorizationSystem.reporitories;

import com.example.UserAuthorizationSystem.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

}
