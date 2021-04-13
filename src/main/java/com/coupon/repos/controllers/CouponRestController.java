package com.coupon.repos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coupon.model.Coupon;
import com.coupon.repos.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

	@Autowired
	CouponRepo repository;

	@RequestMapping(value = "/addcoupon", method = RequestMethod.POST)
	public Coupon create(@RequestBody Coupon coupon) {
		return repository.save(coupon);

	}

	@RequestMapping(value = "/coupon/{code}", method = RequestMethod.GET)
	public Coupon create(@PathVariable("code") String code) {
		System.out.println("finding coupon value");
		return repository.findByCode(code);

	}
}
