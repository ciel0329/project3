package com.spring.mall.pay.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.mall.pay.vo.RefundTotalVO;

public class AdminRefundDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public AdminRefundDAO() {
		System.out.println("AdminRefundDAO() 객체 생성");
	}
	
	//1. 관리자 페이지 환불 요청 리스트
	public List<RefundTotalVO> refundList(RefundTotalVO vo) {
		return mybatis.selectList("adminRefundDAO.refundList",vo);
	}
	
	//2. 
}
