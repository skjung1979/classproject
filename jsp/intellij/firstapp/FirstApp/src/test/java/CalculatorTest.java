import com.firstcoding.firstapp.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator cal;

    // 객체 생성을 한번만 하도록 하기 위한 세팅
    @BeforeEach
    public void setup(){
        System.out.println("@BeforeEach");
        cal = new Calculator();
    }


    @Test
    public void test(){
        
//        Assertions.fail("테스트 미 진행"); // 테스트를 위한 실패처리는 주는것
//        Assertions.assertTrue(true, "테스트하는 메소드의 결과값이 true면 성공");
//        Assertions.assertNull(null, "메소드의 반환값이 Null이면 성공");
        Assertions.assertNotNull(new Object(), "메소드의 반환 값이 null이 아니면 성공");
    }
    
    @Test
    public void testAdd(){

        System.out.println("test : add()");

        //Calculator cal = new Calculator();

        // 가운데 메소드 값이 expected 값과 같은지...
        Assertions.assertEquals(12, cal.add(10,2), "add(10,2) => 12 테스트");

    }

    @Test
    public void testSub(){
        System.out.println("Test: sum()");
        //Calculator cal = new Calculator();
        Assertions.assertEquals(8, cal.sub(10,2), "sub(10,2) => 테스트");
    }

    @Test
    public void testMul(){
        System.out.println("Test: mul()");
        //Calculator cal = new Calculator();
        Assertions.assertEquals(20, cal.mul(10,2), "mul(10,2) => 테스트");
    }
    
    @Test
    public void testDiv(){
        System.out.println("Test: div()");
        //Calculator cal = new Calculator();
        Assertions.assertEquals(5, cal.div(10, 2), "div(10,2) => 테스트");
    }


}
