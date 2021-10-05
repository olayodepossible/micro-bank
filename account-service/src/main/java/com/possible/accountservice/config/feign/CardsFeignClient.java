package com.possible.accountservice.config.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("card")
public interface CardsFeignClient {

}

