package kr.scott.ngg.file.domain;

import kr.scott.ngg.cmn.DTO;

public class FileVO extends DTO {
	/** 파일 고유번호 */
	private int fileSq;
	/** 원본 파일명 */
	private String fileOName;
	/** 저장 파일명 */
	private String fileSName;
	/** 파일 저장 경로 */
	private String filePath;

	public FileVO() {
		// TODO Auto-generated constructor stub
	}

	public FileVO(int num, int totalNum) {
		super(num, totalNum);
		// TODO Auto-generated constructor stub
	}

	public FileVO(int fileSq, String fileOName, String fileSName, String filePath) {
		this.fileSq = fileSq;
		this.fileOName = fileOName;
		this.fileSName = fileSName;
		this.filePath = filePath;
	}

	public int getFileSq() {
		return fileSq;
	}

	public void setFileSq(int fileSq) {
		this.fileSq = fileSq;
	}

	public String getFileOName() {
		return fileOName;
	}

	public void setFileOName(String fileOName) {
		this.fileOName = fileOName;
	}

	public String getFileSName() {
		return fileSName;
	}

	public void setFileSName(String fileSName) {
		this.fileSName = fileSName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "FileVO [fileSq=" + fileSq + ", fileOName=" + fileOName + ", fileSName=" + fileSName + ", filePath="
				+ filePath + ", toString()=" + super.toString() + "]";
	}

}// --class
