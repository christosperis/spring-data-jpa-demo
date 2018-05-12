package com.codehub.spring.springdatajpademo.repository;

import com.codehub.spring.springdatajpademo.domain.City;
import com.codehub.spring.springdatajpademo.domain.Hotel;
import com.codehub.spring.springdatajpademo.transfer.HotelSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query("select new com.codehub.spring.springdatajpademo.transfer.HotelSummary(h.city, h.name, avg(r.rating)) "
            + "from Hotel h left outer join h.reviews r where h.city = ?1 group by h")
    Page<HotelSummary> findHotelSummaryByCity(City city, Pageable pageable);

    @Query(value = "select * from hotel as hotel where city_id = :cityId", nativeQuery = true)
    List<Hotel> findHotelsByCity(@Param("cityId") BigInteger cityId);

}


