package org.springframework.samples.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.dao.StudyDao;
import org.springframework.samples.web.domain.Vo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/imageTest")
public class ImageTestController {

   @Autowired
   private StudyDao dao;

   @RequestMapping(method = RequestMethod.GET)
   public String imageForm() {
      return "imageTest";
   }

   @RequestMapping("/saveImage")
   public String saveImage(Vo vo, HttpSession session) {
      
      String code = (String) session.getAttribute("code");
      System.out.println(code);
      try {
         Map<String, Object> hmap = new HashMap<String, Object>();
         hmap.put("img", vo.getImgFile().getBytes());
         dao.saveImage(hmap, code);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return "redirect:/share/list";
   }

}