package studentself;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubjectSelf {
	//과목명, 학년, 학기, 중간, 기말, 수행평가
	private String name;
	private int grade;
	private int semester;
	private int mid;
	private int finals;
	private int performance;
	
	//한 학생에게 같은 과목명, 학년, 학기 성적이 여러 개 있을 수 없기 때문에
	//equals를 과목명, 학년, 학기를 이용하여 오버라이딩
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubjectSelf other = (SubjectSelf) obj;
		return Objects.equals(name, other.name) && grade == other.grade && semester == other.semester;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, grade, semester);
	}
	
	public SubjectSelf(String name, int grade, int semester) {
		this.name = name;
		this.grade = grade;
		this.semester = semester;
	}

	public void print() {
		System.out.println(grade + "학년 " + semester + "학기  " + name);
	}

	public void update(int midScore, int finalScore, int perfomScore) {
		this.mid = midScore;
		this.finals = finalScore;
		this.performance = perfomScore;
	}
	
	
}
