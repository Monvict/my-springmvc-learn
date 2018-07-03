package com.lotus.cotroller;

import com.lotus.bean.City;
import com.lotus.mapper.CityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;

/**
 * @author Tony
 * 2018-06-29 10:51
 **/
@Controller
@Slf4j
public class CityController {

    @Autowired
    private CityMapper cityMapper;

    /**
     * 所有城市
     * @return
     */
    @RequestMapping("/cities")
    public ModelAndView getCities() throws Exception {
        List<City> cities = cityMapper.selectAll();
        Thread.sleep(new Random().nextInt(1000));

        ModelAndView mv = new ModelAndView();
        mv.addObject("cityList", cities);
        mv.setViewName("cities");

        return mv;
    }

    /**
     * 增加一个城市
     */
    @RequestMapping("/city/add")
    public ModelAndView addCity() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("cityAdd");
        return mv;
    }

    @PostMapping("city/addSubmit")
    public ModelAndView addCitySubmit(City city) {
        cityMapper.insertSelective(city);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/cities");
        return mv;
    }
    /**
     * 删除城市
     *
     */
    @RequestMapping("/city/delete")
    public ModelAndView delCity(@RequestParam String id) {
        log.info("start to dele city, id {}", id);
        cityMapper.deleteByPrimaryKey(id);
        log.info("Finish to dele city");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/cities");
        return mv;
    }

    /**
     * 修改城市信息
     */
    @RequestMapping("/city/edit")
    public ModelAndView editCity(@RequestParam("id") String id) {
        City city = cityMapper.selectByPrimaryKey(id);

        ModelAndView mv = new ModelAndView();
        mv.addObject("city", city);
        mv.setViewName("cityEdit");
        return mv;
    }

    @PostMapping("/city/editSubmit")
    public ModelAndView editCitySubmit(@Validated City city, BindingResult bindingResult) {
        log.info("Receive ciyt {}", city);
        ModelAndView mv = new ModelAndView();

        //获取校验的错误信息
        if(bindingResult.hasErrors()){
            //输出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for(ObjectError error : allErrors){
                //输出错误信息
                log.warn("Get error message {}",error.getDefaultMessage());
            }
            mv.addObject("allErrors", allErrors);//将错误信息传递到页面
            mv.setViewName("cityEdit");
            return mv;
        }

        cityMapper.updateByPrimaryKeySelective(city);
        mv.setViewName("redirect:/cities");

        return mv;
    }

    @RequestMapping("/city/{id}")
    public City getCity(@PathVariable("id") String id) {
        return cityMapper.selectByPrimaryKey(id);
    }
}
