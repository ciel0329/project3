package com.spring.mall.order.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mall.cart.service.CartService;
import com.spring.mall.inven.vo.InvenVO;
import com.spring.mall.order.service.OrderService;
import com.spring.mall.order.vo.UserOrderDetailVO;
import com.spring.mall.order.vo.UserOrderVO;
import com.spring.mall.pay.vo.PaymentVO;
import com.spring.mall.product.vo.ProductVO;
import com.spring.mall.user.service.UserLoginService;
import com.spring.mall.user.vo.UserOrderPointVO;
import com.spring.mall.user.vo.UserVO;

@Controller
@RequestMapping("/order/**")
public class OrderController {

	@Autowired
	private OrderService orderService;

	public OrderController() {
		System.out.println(">> OrderController() 객체 생성 ");
	}

	@GetMapping("orderView.do")
	public String order() {
		System.out.println(">> orderView.do() 생성  -> order.jsp 이동 ");
		return "store/order";

	}

	@RequestMapping("orderViewD.do")
	public String orderD() {
		System.out.println(">> orderView.do() 생성  -> order.jsp 이동 ");
		return "store/orderD";

	}

	// 1. 주문 정보 입력
	@RequestMapping("order.do")
	public String order(HttpSession session, Model model, UserOrderVO order, UserOrderDetailVO orderDetail,
			PaymentVO pvo) throws Exception {
		UserVO user = (UserVO) session.getAttribute("user");
		String user_id = user.getUser_id();
		session.getAttribute("map");

		// 주문 정보 저장
		// 주문 아이디 저장 방식
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";

		for (int i = 1; i <= 6; i++) {
			subNum += (int) (Math.random() * 10);
		}

		// 주문 테이블로 주문 정보 저장
		String order_id = ymd + "-" + subNum;
		order.setOrder_id(order_id);
		order.setUser_id(user_id);
		orderService.insertOrder(order);

		// 결제창에서 쓰일 최근 주문 정보 가져오기
		Map<String, String> orderMap = new HashMap<String, String>();
		orderMap.put("user_id", user_id);
		orderMap.put("order_id", order_id);

		UserOrderVO orderInfo = new UserOrderVO();
		orderInfo = orderService.getOrder(user_id, order_id);
		session.setAttribute("orderInfo", orderInfo);

		// 2. 결제 완료 후, 결제 테이블에 정보 삽입
		pvo.setOrder_id(order_id);
		orderService.insertPayment(pvo);
		session.setAttribute("payment", pvo);

		return "store/shipping";
	}

	// 1-1. 주문 정보 입력(바로 결제)
	@RequestMapping("shippingD.do")
	public String orderD(HttpSession session, Model model, UserOrderVO order, UserOrderDetailVO orderDetail,
			PaymentVO pvo) throws Exception {
		UserVO user = (UserVO) session.getAttribute("user");
		String user_id = user.getUser_id();
		session.getAttribute("mapD");

		// 주문 정보 저장
		// 주문 아이디 저장 방식
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";

		for (int i = 1; i <= 6; i++) {
			subNum += (int) (Math.random() * 10);
		}

		// 주문 테이블로 주문 정보 저장
		String order_id = ymd + "-" + subNum;
		order.setOrder_id(order_id);
		// order.setOrder_total(order_total);
		order.setUser_id(user_id);
		orderService.insertOrder(order);

		// 결제창에서 쓰일 최근 주문 정보 가져오기
		UserOrderVO orderInfo = new UserOrderVO();
		orderInfo = orderService.getOrder(user_id, order_id);
		session.setAttribute("orderInfo", orderInfo);

		// 2. 결제 완료 후, 결제 테이블에 정보 삽입
		pvo.setOrder_id(order_id);
		orderService.insertPayment(pvo);
		session.setAttribute("payment", pvo);

		return "store/shippingDirect";
	}

	@RequestMapping("pay.do")
	public String pay(HttpSession session, Model model, UserOrderVO order, UserOrderDetailVO orderDetail, PaymentVO pvo,
			InvenVO iVo, UserOrderPointVO point) throws Exception {
		session.getAttribute("payment");
		session.getAttribute("orderInfo");
		UserVO user = (UserVO) session.getAttribute("user");
		String user_id = user.getUser_id();

		// 상세 주문 정보 저장
		UserOrderVO orderInfo = (UserOrderVO) session.getAttribute("orderInfo");
		String order_id = orderInfo.getOrder_id();
		// 상세 주문 정보 저장
		orderDetail.setOrder_id(order_id);
		orderDetail.setUser_id(user_id);
		orderService.insertOrderDetail(orderDetail);

		// 상품 재고량 감소시키지
		// 구매 이후 구매한 상품 아이디, 수량 가져오기
		List<UserOrderDetailVO> qtyId = orderService.getIdQty(order_id);
		System.out.println("qtyId : " + qtyId);
		session.setAttribute("qtyId", qtyId);

		// 아이디 하나, 수량 반복문으로 분리 후 하나씩 재고 정리
		for (int i = 0; i < qtyId.size(); i++) {
			int product_id = qtyId.get(i).getProduct_id();
			int user_order_cnt = qtyId.get(i).getUser_order_cnt();
			iVo.setProduct_id(product_id);
			iVo.setInven_stock(user_order_cnt);
			orderService.deleteInven(iVo);
		}

		// 포인트 결제금액의 5% 적립
		point.setOrder_id(order_id);
		point.setUser_id(user_id);
		orderService.updatePoint(point);

		// 결제 칸으로 넘어가면 장바구니 정보 삭제
		orderService.cartAllDelete(user_id);
		System.out.println("vo : " + order);

		return "store/afterPay";
	}

	@RequestMapping("payD.do")
	public String payD(@RequestParam int product_id, @RequestParam int inven_stock, HttpSession session, Model model, UserOrderVO order,
			UserOrderDetailVO orderDetail, PaymentVO pvo, UserOrderPointVO point, InvenVO iVo,
			HttpServletRequest request) throws Exception {
		System.out.println("payD.do 로 이동 ");
		
		//결제 정보 가져오기 
		session.getAttribute("payment");
		//주문 정보 가져오기 
		session.getAttribute("orderInfo");
		session.getAttribute("mapD");
		
		UserVO user = (UserVO) session.getAttribute("user");
//		System.out.println(product_id);

		order = (UserOrderVO) session.getAttribute("orderInfo");

		String user_id = user.getUser_id();
		String order_id = order.getOrder_id();

		// 바로구매 주문상세 정보 입력
		orderDetail.setOrder_id(order_id);
		orderDetail.setProduct_id(product_id);
		orderDetail.setUser_order_cnt(inven_stock);
		System.out.println(order_id);
		System.out.println(product_id);

		//주문 상세 테이블 정보입력 
		orderDetail.setUser_order_cnt(inven_stock);
		orderDetail.setOrder_id(order_id);
		orderDetail.setProduct_id(product_id);
		orderDetail.setUser_id(user_id);
		orderService.insertOrderDetailDirect(orderDetail);
		System.out.println(orderDetail);

	// 재고 정리
			//여기가 오류 지점 
			iVo.setProduct_id(product_id);
			iVo.setInven_stock(inven_stock);
			orderService.deleteInven(iVo);
			System.out.println("iVo : "+iVo);

		// 포인트 결제금액의 5% 적립
		point.setOrder_id(order_id);
		point.setUser_id(user_id);
		orderService.updatePoint(point);

		return "store/afterPay";
	}

}