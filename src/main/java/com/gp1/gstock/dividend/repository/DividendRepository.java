package com.gp1.gstock.dividend.repository;

import com.gp1.gstock.dividend.entity.Dividend;
import com.gp1.gstock.dividend.entity.DividendId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DividendRepository extends JpaRepository<Dividend, DividendId> {
}
