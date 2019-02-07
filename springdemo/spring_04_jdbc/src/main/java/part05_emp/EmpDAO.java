package part05_emp;

import java.util.HashMap;
import java.util.List;

public interface EmpDAO {
    public List<EmpDTO> searchMethod(HashMap<String, Integer> map);
}
