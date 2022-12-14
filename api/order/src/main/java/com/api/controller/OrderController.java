package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    /**
     * 新增订单
     *
     * @return
     */
    @RequestMapping("/addOrder")
    public String addOrder() {
        System.out.println("订单新增成功");
        //调用库存扣减
        String apiReqResult = restTemplate.getForObject("http://stock/stock/subStock", String.class);
        return "订单服务-订单新增成功:" + apiReqResult;
    }
}
