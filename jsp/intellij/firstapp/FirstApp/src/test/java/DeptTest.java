import com.firstcoding.firstapp.dept.Dept;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeptTest {

    @Test
    public void DeptTest(){

        Dept dept = new Dept(10, "test", "loc");

        System.out.println(dept);

        Assertions.assertEquals(10, dept.getDeptno(), "부서 번호 테스트");


    }

}
