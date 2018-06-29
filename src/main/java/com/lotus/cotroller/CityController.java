package com.lotus.cotroller;

import com.lotus.bean.City;
import com.lotus.mapper.CityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    public ModelAndView getCities() {
        List<City> cities = cityMapper.selectAll();

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
    public ModelAndView editCitySubmit(@RequestBody City city) {

        log.info("Receive ciyt {}", city);
        cityMapper.updateByPrimaryKeySelective(city);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/cities");

        return mv;
    }

    @RequestMapping("/city/{id}")
    public City getCity(@PathVariable("id") String id) {
        return cityMapper.selectByPrimaryKey(id);
    }
}
