package student;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject implements Serializable{
	private static final long serialVersionUID = 123L;
	//과목명, 학년, 학기, 중간, 기말, 수행평가
	private String Name;
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
		Subject other = (Subject) obj;
		return Objects.equals(Name, other.Name) && grade == other.grade && semester == other.semester;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Name, grade, semester);
	}
	public void update(int midScore, int finalScore, int performScore) {
		this.mid = midScore;
		this.finals = finalScore;
		this.performance = performScore;
	}
	@Override
	public String toString() {
		return "과목 : " + Name + "\n" + grade + "학년 " + semester + "학기\n중간 : " + mid
				+ "\n기말 : " + finals + "\n수행 : " + performance + "\n총점 : " + getTotal();
	}
	private double getTotal() {
		return (mid*0.4 + finals*0.5 + performance*0.1);
	}
	
	
}
