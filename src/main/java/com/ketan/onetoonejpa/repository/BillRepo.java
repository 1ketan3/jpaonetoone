package com.ketan.onetoonejpa.repository;

import com.ketan.onetoonejpa.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<Bill,Integer>
{

}
