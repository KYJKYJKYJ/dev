package part05_emp_Answer;

import java.util.HashMap;
import java.util.List;

import part05_emp_Answer.EmpDTO;

public interface EmpDAO {
    public List<EmpDTO> searchMethod(HashMap<String, Integer> map);
}
