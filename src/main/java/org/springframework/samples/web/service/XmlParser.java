package org.springframework.samples.web.service;

import java.util.ArrayList;

import org.springframework.samples.web.domain.PublicParking;

public interface XmlParser {
   public ArrayList<PublicParking> apiParserSearch();
   
   public String getURLParam(String search);

}