import java.util.HashMap;
import java.util.Map;

public class TestResult {
    private Map<Integer, Test> result;


    public  TestResult() {
        this.result = new HashMap<>();
    }
    public void addResult(Test test){
        result.put(test.getKitNum(), test);
    }


    public Map<Integer, Test> getResult() {
        return result;
    }
}

