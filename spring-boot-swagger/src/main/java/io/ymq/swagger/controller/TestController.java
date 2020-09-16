package io.ymq.swagger.controller;

import io.ymq.swagger.model.BaseResponse;
import io.ymq.swagger.model.BaseResponse2;
import io.ymq.swagger.model.TestResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yejg
 * @since 2019-08-27
 */
@RestController
@RequestMapping("/test")
public class TestController {

    // 入参
    // @ApiImplicitParams({
    //         @ApiImplicitParam(name = "id", value = "唯一id", required = true, dataType = "String"),
    //         @ApiImplicitParam(name = "name", value = "名字", required = true, dataType = "String"),
    // })
    @PostMapping(value = "/get")
    public BaseResponse getUser() {

        TestResponse t = new TestResponse("001", "测试001");

        BaseResponse br = new BaseResponse();
        br.setData(t);

        return br;
    }

    @PostMapping(value = "/get2")
    public BaseResponse2 getUser2() {
        BaseResponse2 br = new BaseResponse2();
        return br;
    }

}
