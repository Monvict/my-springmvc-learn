package com.lotus.cotroller;

import com.lotus.bean.City;
import com.lotus.mapper.CityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @RequestMapping("/cities")
    public ModelAndView getCities() {
        List<City> cities = cityMapper.selectAll();

        ModelAndView mv = new ModelAndView();
        mv.addObject("cityList", cities);
        mv.setViewName("cities");

        return mv;
    }

    @RequestMapping("/city/edit")
    public ModelAndView editCity(@RequestParam("id") String id) {
        City city = cityMapper.selectByPrimaryKey(id);

        ModelAndView mv = new ModelAndView();
        mv.addObject("city", city);
        mv.setViewName("cityEdit");
        return mv;
    }

    @PostMapping("/city/editSubmit")
    public ModelAndView editCitySubmit(City city) {

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
