package com.spring.mall.product.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mall.product.vo.ProductQnaVO;

@Repository
public class ProductQnaDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public ProductQnaDAO() {
		System.out.println("ProductQnaDAO() 객체 생성");
	}
	
	public void insertProductQna(ProductQnaVO vo) {
		System.out.println("insertProductQna() 실행");
		mybatis.insert("productQnaDAO.insertPrdQna",vo);
	}
}
