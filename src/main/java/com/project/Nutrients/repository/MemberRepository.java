package com.project.Nutrients.repository;

import com.project.Nutrients.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {

    ArrayList<Member> findAll();

}
