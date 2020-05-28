package com.hamathon.sahab.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class ViewController {

//    @GetMapping(value = "/")
//    public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "index";
//    }


    @Value("${:classpath:/static/index.html}")
    private Resource index;

    @GetMapping(value = {"/jmx/*", "/jvm/*"}, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public ResponseEntity actions() throws IOException {
        return ResponseEntity.ok(new InputStreamResource(index.getInputStream()));
    }


    @GetMapping("/")
    public String one() {
        return "redirect:/static/index.html";
    }
}
