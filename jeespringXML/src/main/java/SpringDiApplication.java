import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDiApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.printMessage();
        Person person = (Person) context.getBean("person");
        person.getName();
        MessageSender sender =
                context.getBean("messageSender", MessageSender.class);
        sender.sendMessage();

        MessageSender sender1 =
                 context.getBean("messageSenderByEmail", MessageSender.class);
        sender1.sendMessage();
        context.close();
    }
}
