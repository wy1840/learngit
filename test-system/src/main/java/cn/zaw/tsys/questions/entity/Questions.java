package cn.zaw.tsys.questions.entity;

import java.io.Serializable;
/**
 * 试题 实体类
 * @author uid
 *
 */
public class Questions implements Serializable{

	
	private static final long serialVersionUID = 657528880238018662L;
	
	/**试题ID*/
	private int subjectID;
	/**试题题目*/
	private String 	subjectTitle;
	/**试题A选项*/
	private String subjectOptionA;
	/**试题B选项*/
	private String subjectOptionB;
	/**试题C选项*/
	private String subjectOptionC;
	/**试题D选项*/
	private String subjectOptionD;
	/**试题答案*/
	private String subjectAnswer;
	/**试题答案解析*/
	private String subjectParse;
	public int getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	public String getSubjectTitle() {
		return subjectTitle;
	}
	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}
	public String getSubjectOptionA() {
		return subjectOptionA;
	}
	public void setSubjectOptionA(String subjectOptionA) {
		this.subjectOptionA = subjectOptionA;
	}
	public String getSubjectOptionB() {
		return subjectOptionB;
	}
	public void setSubjectOptionB(String subjectOptionB) {
		this.subjectOptionB = subjectOptionB;
	}
	public String getSubjectOptionC() {
		return subjectOptionC;
	}
	public void setSubjectOptionC(String subjectOptionC) {
		this.subjectOptionC = subjectOptionC;
	}
	public String getSubjectOptionD() {
		return subjectOptionD;
	}
	public void setSubjectOptionD(String subjectOptionD) {
		this.subjectOptionD = subjectOptionD;
	}
	public String getSubjectAnswer() {
		return subjectAnswer;
	}
	public void setSubjectAnswer(String subjectAnswer) {
		this.subjectAnswer = subjectAnswer;
	}
	public String getSubjectParse() {
		return subjectParse;
	}
	public void setSubjectParse(String subjectParse) {
		this.subjectParse = subjectParse;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Questions [subjectID=" + subjectID + ", subjectTitle=" + subjectTitle + ", subjectOptionA="
				+ subjectOptionA + ", subjectOptionB=" + subjectOptionB + ", subjectOptionC=" + subjectOptionC
				+ ", subjectOptionD=" + subjectOptionD + ", subjectAnswer=" + subjectAnswer + ", subjectParse="
				+ subjectParse + "]";
	}
	
	
}
