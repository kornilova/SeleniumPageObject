import org.junit.*;

public class MainTestAnnotation {

    @BeforeClass
    public static void beforeClassMethod(){
        System.out.println("beforeClassMethod");
    }

    @Before
    public void setUp(){
        System.out.println("setUp");
    }

    @Test
    public void method1(){
        System.out.println("method1");
    }

    @Test
    @Ignore
    public void method2(){
        System.out.println("method2");
    }

    @Test
    public void method3(){
        System.out.println("method3");
    }

    @After
    public void tearDown(){
        System.out.println("tearDown");
    }

    @AfterClass
    public static void afterClassMethod(){
        System.out.println("afterClassMethod");
    }
}
