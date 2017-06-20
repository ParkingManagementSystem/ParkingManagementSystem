package org.springframework.samples.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.dao.StudyDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImageShowController {
	@Autowired
	private StudyDao dao;

	@RequestMapping(value = "/view")
	public String view() {
		System.out.println("show");
		return "showImage";
	}
	
//	@RequestMapping(value="/getByteImage")
//	public void getByteImage(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		res.setContentType("image/png");
//		Map<String, Object> map = dao.getByteImage("1");
//		
//		ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
//		ObjectOutput out = new ObjectOutputStream(bos);   
//		out.writeObject(map);
//		
//		byte[] imageFile = bos.toByteArray();
//		InputStream in1 = new ByteArrayInputStream(imageFile);
//		IOUtils.copy(in1,  res.getOutputStream());
//	}

}
