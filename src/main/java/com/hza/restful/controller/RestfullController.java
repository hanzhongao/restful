package com.hza.restful.controller;

import com.hza.restful.entity.Persion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Create by hza
 * 2019-11-15 11:48
 */
@RestController
//@Controller
@RequestMapping("/restful")
//@CrossOrigin(origins = {"http://localhost:8080"}, maxAge = 3600)  // 跨域资源访问
public class RestfullController {

    @GetMapping("/request")
//    @ResponseBody
    public String doGetMapping() {
        return "{\"message\":\"返回查询结果\"}" ;
    }

    @PostMapping("/request/{rid}")
//    @ResponseBody
    public String doPostMapping(@PathVariable("rid") Integer rid, Persion persion) {
        System.out.println("name:" + persion.getName() + ", age=" + persion.getAge());
        return "{\"message\":\"返回新增结果\",\"id\":" + rid + "}" ;
    }

    @PutMapping("/request/{rid}")
//    @ResponseBody
    public String doPutMapping(@PathVariable(value = "rid") Integer rid,Persion persion) {
        System.out.println("name:" + persion.getName() + ", age=" + persion.getAge());
        return "{\"message\":\"返回修改结果\",\"id\":" + rid + "}" ;
    }

    @DeleteMapping("/request/{rid}")
//    @ResponseBody
    public String doDeleteMapping(@PathVariable("rid") Integer rid) {
        return "{\"message\":\"返回删除结果\",\"id\":" + rid + "}" ;
    }

    @GetMapping("/persion/{id}")
    public Persion getByPersionId(@PathVariable("id") Integer id) {
        Persion p1 = new Persion() ;
        if (id == 1) {
            p1.setName("lily");
            p1.setAge(21);
            p1.setBirthday(new Date());
        } else if (id == 2) {
            p1.setName("smith");
            p1.setAge(23);
            p1.setBirthday(new Date());
        }
        return p1 ;
    }

    @PostMapping("/persions")
    public List<Persion> getPersions() {

        List<Persion> list = new ArrayList<Persion>() ;

        Persion p1 = new Persion() ;
        p1.setName("lily");
        p1.setAge(21);
        p1.setBirthday(new Date());

        Persion p2 = new Persion() ;
        p2.setName("smith");
        p2.setAge(23);
        p2.setBirthday(new Date());

        list.add(p1) ;
        list.add(p2) ;

        return list ;
    }
}
