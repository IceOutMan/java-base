package glf.ainewbegin.jdk;

/**
 * @Author glf
 * @Date 2021/3/12
 */
public class Dog implements IShoutAction {
    @Override
    public String shout() {
        System.out.println("Dog shout");
        return "DOG";
    }
}
