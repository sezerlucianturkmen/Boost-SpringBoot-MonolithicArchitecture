package com.boost.Java3Monolithic.repository;

import com.boost.Java3Monolithic.repository.entity.Musteri;
import com.boost.Java3Monolithic.repository.entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUrunRepository extends JpaRepository<Urun,Long> {

}
