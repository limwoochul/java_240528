package studentself;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.security.auth.Subject;

import lombok.Data;

@Data
public class StudentSelf {
	
	//- 학년, 반, 번호, 이름
	private int grade, classNum, num;
	private String name;
	
	//- 각 과목의 점수
	private List<SubjectSelf> subjectList = new ArrayList<SubjectSelf>();
	
	public StudentSelf(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}

	//같은 학교에 특정년도에 같은 학년, 반, 번호를 가진 학생은 1명이기 때문에
	//equals를 오버라이딩
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentSelf other = (StudentSelf) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classNum, grade, num);
	}

	public void print() {
		System.out.println(grade + "학년 " + classNum + "반 " + num + "번 " + name);
		System.out.println("과목성적");
		if(subjectList.size() == 0) {
			System.out.println("등록된 과목이 없습니다.");
			return;
		}
		for(SubjectSelf tmp : subjectList) {
			System.out.println(tmp);
		}
	}
	
	public StudentSelf update(StudentSelf existStudent, StudentSelf newStudent) {
		newStudent.setSubjectList(existStudent.getSubjectList());
		return newStudent;
	}


	
	
	
}
