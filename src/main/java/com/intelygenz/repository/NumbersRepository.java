package com.intelygenz.repository;

import com.intelygenz.model.Numbers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumbersRepository extends JpaRepository<Numbers, Long> {
}
