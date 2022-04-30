package com.example.quizback.repo.userRepo;

import com.example.quizback.model.userDto.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends JpaRepository<Roles,Long> {
}
