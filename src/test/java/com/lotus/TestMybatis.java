package com.lotus;

import com.lotus.bean.City;
import com.lotus.mapper.CityMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Tony
 * 2018-06-27 16:26
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springmybatis.xml")
@Slf4j
public class TestMybatis {

    @Autowired
    private CityMapper mapper;

    @Test
    public void testCity() {
       City city = mapper.selectByPrimaryKey("1");
       log.info("City = {}", city);
    }

    @Test
    public void testSelectAll() {
        List<City> cities = mapper.selectAll();
        log.info("cities = {}", cities);
    }
}
