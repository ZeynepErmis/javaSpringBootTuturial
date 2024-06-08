package com.kodlama.io.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.entity.concretes.Framework;

public interface FrameworkRepository extends JpaRepository<Framework, Integer> {

}
