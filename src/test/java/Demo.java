import com.thoughtworks.gauge.Step;

public class Demo {
    @Step("Sum <a> ve <b> numbers")
    public void sum(double a, double b) {
        System.out.println(a + b);
    }

    @Step("Print <text>")
    public void printHelloWorld(String text) {
        System.out.println(text);
    }
}
