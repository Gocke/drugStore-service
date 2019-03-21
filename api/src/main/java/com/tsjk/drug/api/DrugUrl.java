package com.tsjk.drug.api;

/**
 * @author Caine
 * @date 2019/3/2
 * @desc
 */
public interface DrugUrl {

    String SERVICE_NAME = "PAS-SERVICE";

    String URI_PREFIX = "/pas";

    /*
    * 简单获取token demo
    * */
    String Get_Token = URI_PREFIX + "/getToken";
}
