package org.springframework.samples.web.command;

import org.springframework.web.multipart.MultipartFile;

public class FileCommand {

	private String mode;

	private String content, saveFileName, originalFileName;

	private long fileSize;

	private MultipartFile upload;

	public String getMode() {

		return mode;

	}

	public void setMode(String mode) {

		this.mode = mode;

	}

	public String getContent() {

		return content;

	}

	public void setContent(String content) {

		this.content = content;

	}

	public String getSaveFileName() {

		return saveFileName;

	}

	public void setSaveFileName(String saveFileName) {

		this.saveFileName = saveFileName;

	}

	public String getOriginalFileName() {

		return originalFileName;

	}

	public void setOriginalFileName(String originalFileName) {

		this.originalFileName = originalFileName;

	}

	public long getFileSize() {

		return fileSize;

	}

	public void setFileSize(long fileSize) {

		this.fileSize = fileSize;

	}

	public MultipartFile getUpload() {

		return upload;

	}

	public void setUpload(MultipartFile upload) {

		this.upload = upload;

	}

}