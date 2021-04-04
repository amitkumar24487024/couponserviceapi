package com.coupon.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coupon.model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Integer> {

	Coupon findByCode(String code);

}
