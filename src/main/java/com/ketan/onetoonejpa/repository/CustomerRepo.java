package com.ketan.onetoonejpa.repository;

import com.ketan.onetoonejpa.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer>
{
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("select c.mobileno,c.name from Customer c")
    List<Object> getnameandmobile();
}
