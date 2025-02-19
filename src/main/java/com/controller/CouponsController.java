package com.controller;

import com.business.CouponsBusiness;
import com.dto.CouponCorpDTO;
import com.dto.CouponIndividualDTO;

import com.entity.Coupons;

import com.enums.ResponseCode;
import com.utils.cache.Response;
import com.vo.CouponVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zmh
 * @since 2022-04-29
 */
@RestController
@Api("coupons api")
@RequestMapping("/api/coupons")
public class CouponsController {
    @Autowired
    private CouponsBusiness couponsBusiness;

    @ApiOperation("issue coupons to all the employees of Corporation, will create a new batch")
    @PostMapping("/corporation")
    public Response<List<Coupons>> issueCouponsToCorporation(@RequestBody CouponCorpDTO couponCorpDTO){
        List<Coupons> res = couponsBusiness.issueCouponsToCorporation(couponCorpDTO);
        return new Response<>(ResponseCode.SUCCESS, res);
    }
    @ApiOperation("issue coupons to Individual, need a batchId")
    @PostMapping("/individual")
    public Response<Coupons> issueCouponsToIndividual(@RequestBody CouponIndividualDTO couponIndividualDTO){
        Coupons coupons = couponsBusiness.issueCouponsToIndividual(couponIndividualDTO);
        return new Response<>(ResponseCode.SUCCESS, coupons);
    }

    @ApiOperation("get valid coupons by userId")
    @GetMapping("/u/{userId}")
    public Response<CouponVO> getValidCouponsByUserId(@PathVariable("userId") Long userId){
        CouponVO couponVO = couponsBusiness.getValidCouponsByUserId(userId);
        return new Response<>(couponVO);
    }

    @ApiOperation("delete coupons by couponId")
    @DeleteMapping("/{couponId}")
    public Response<ResponseCode> deleteCouponByCouponId(@PathVariable("couponId") Long couponId){
        couponsBusiness.deleteCouponByCouponId(couponId);
        return new Response<>(ResponseCode.SUCCESS);
    }
}
