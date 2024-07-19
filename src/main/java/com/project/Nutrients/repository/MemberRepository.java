package com.project.Nutrients.repository;

import com.project.Nutrients.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    ArrayList<Member> findAll();

    Optional<Member> findByEmail(String email);

}
