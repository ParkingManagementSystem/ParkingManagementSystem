package org.springframework.samples.web.domain;

import org.springframework.web.multipart.MultipartFile;

public class Vo {
	private MultipartFile imgFile;

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
}