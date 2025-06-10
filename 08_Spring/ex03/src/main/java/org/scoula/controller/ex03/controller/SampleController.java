package org.scoula.controller.ex03.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.controller.ex03.dto.SampleDTO;
import org.scoula.controller.ex03.dto.SampleDTOList;
import org.scoula.controller.ex03.dto.TodoDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {
    @RequestMapping("") // url: /sample
    public void basic() {
        log.info("basic.............");
    }

    @RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST}) // url: /sample/basic
    public void basicGet() {
        log.info("basic get.............");
    }

    @GetMapping("/basicOnlyGet")
    public void basicGet2() {
        log.info("basic get only get...........");
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) {
        log.info("" + dto);

        return "ex01";
    }

    @GetMapping("/ex02")
    public String ex02(
            @RequestParam("name") String name,
            @RequestParam("age") int age
    ) {
        log.info("name: " + name);
        log.info("age: " + age);

        return "ex02";
    }

    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list) {
        log.info("list dtos" + list);
        return "ex02Bean";
    }

    @GetMapping("/ex03")
    public String ex03(TodoDTO todo) {
        log.info("todo: " + todo);
        return "ex03";
    }

    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, int page) {
        log.info("dto: " + dto);
        log.info("page: " + page);
        return "ex04";
    }

    @GetMapping("/ex05")
    public String ex05() {
        log.info("/ex05...............");

        return "ex05";
    }

    @GetMapping("/ex06")
    public String ex06(RedirectAttributes ra) {
        log.info("/ex06...............");
        ra.addAttribute("name", "AAA");
        ra.addAttribute("age", 10);


        return "redirect:/sample/ex06";
    }

    @GetMapping("/ex07")
    public @ResponseBody SampleDTO ex07() {
        log.info("/ex07...............");

        SampleDTO dto = new SampleDTO();
        dto.setAge(10);
        dto.setName("홍길동");

        return dto;
    }

    @GetMapping("/ex08")
    public ResponseEntity<String> ex08() {
        log.info("/ex08...............");

        String msg = "{\name\":\"홍길동\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=UTF-8");

        return new ResponseEntity<>(msg, headers, HttpStatus.OK);
    }
}
