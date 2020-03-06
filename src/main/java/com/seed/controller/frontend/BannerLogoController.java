package com.seed.controller.frontend;
import com.seed.model.BannerLogo;
import com.seed.service.IBannerLogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/banner")
public class BannerLogoController {
    @Autowired
    private IBannerLogoService bannerLogoService;

    @RequestMapping(value = "/getbanner",method = {RequestMethod.POST,RequestMethod.GET})
    @Cacheable(cacheNames = "logo",key = "'bannerLogo'")
    public List<BannerLogo> getbanner(){
        BannerLogo bannerLogo =new BannerLogo();
        List<BannerLogo> lis = bannerLogoService.selectBannerLogoList(bannerLogo);
        //String listArray= JSONArray.toJSONString(lis);
       // System.out.println(listArray.replaceAll("",""));
        return lis;
    }
}
