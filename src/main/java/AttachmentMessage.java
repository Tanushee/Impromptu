import co.flock.www.model.messages.Attachments.*;

/**
 * Created by tanushee on 23/9/16.
 **/
public class AttachmentMessage
{

    public Attachment[] get_msg_title()
    {
        Attachment attachment = new Attachment();
        attachment.setTitle("Title only");
        return (new Attachment[]{attachment});
    }

    public Attachment[] get_msg_title_description()
    {
        Attachment attachment = new Attachment();
        attachment.setTitle("Title only");
        attachment.setDescription(
            "Lorem ipsum dolor sit amet, qui et exerci persius tractatos, mea in habeo accumsan, at sed esse propriae. Qui albucius euripidis interesset ne. Eam ut iisque feugiat posidonium. Vis porro quaestio pericula in. His ut salutandi conceptam consectetuer.\n" +
            "\n" +
            "Vim te urbanitas persecuti, scripta mnesarchum mel ad. Summo conceptam rationibus ei vim. Ei quo wisi ipsum, quidam aperiri no his. No pro adolescens deterruisset consequuntur, an has noluisse euripidis interesset. Mel posse perpetua mnesarchum at.\n" +
            "\n" +
            "Ea simul essent eos, eu aliquip inciderint vix. Ius case complectitur ei. Mea interpretaris necessitatibus in, brute scribentur vim no. Quo eu movet veniam utinam, quo etiam errem ea. Altera explicari ex qui, vel an probo accusamus. Causae omnesque te quo, cu pro exerci accusam eleifend. In ius possim intellegat inciderint, doctus suscipit no usu.\n");
        return (new Attachment[]{attachment});
    }

    public Attachment[] get_msg_html_type1()
    {
        Attachment attachment = new Attachment();
        attachment.setTitle("Title only");
        attachment.setDescription(
            "Lorem ipsum dolor sit amet, qui et exerci persius tractatos, mea in habeo accumsan, at sed esse propriae. Qui albucius euripidis interesset ne. Eam ut iisque feugiat posidonium. Vis porro quaestio pericula in. His ut salutandi conceptam consectetuer.\n" +
            "\n" +
            "Vim te urbanitas persecuti, scripta mnesarchum mel ad. Summo conceptam rationibus ei vim. Ei quo wisi ipsum, quidam aperiri no his. No pro adolescens deterruisset consequuntur, an has noluisse euripidis interesset. Mel posse perpetua mnesarchum at.\n" +
            "\n" +
            "Ea simul essent eos, eu aliquip inciderint vix. Ius case complectitur ei. Mea interpretaris necessitatibus in, brute scribentur vim no. Quo eu movet veniam utinam, quo etiam errem ea. Altera explicari ex qui, vel an probo accusamus. Causae omnesque te quo, cu pro exerci accusam eleifend. In ius possim intellegat inciderint, doctus suscipit no usu.\n");

        View view = new View();
        HtmlView htmlView = new HtmlView();
        htmlView.setInline("<img src=x onerror=prompt(\"removed\");> ");
        view.setHtml(htmlView);
        attachment.setViews(view);
        return (new Attachment[]{attachment});
    }

    public Attachment[] get_msg_view_flockml()
    {
        Attachment attachment = new Attachment();
        attachment.setTitle("Title only");
        attachment.setDescription(
            "Lorem ipsum dolor sit amet, qui et exerci persius tractatos, mea in habeo accumsan, at sed esse propriae. Qui albucius euripidis interesset ne. Eam ut iisque feugiat posidonium. Vis porro quaestio pericula in. His ut salutandi conceptam consectetuer.\n" +
            "\n" +
            "Vim te urbanitas persecuti, scripta mnesarchum mel ad. Summo conceptam rationibus ei vim. Ei quo wisi ipsum, quidam aperiri no his. No pro adolescens deterruisset consequuntur, an has noluisse euripidis interesset. Mel posse perpetua mnesarchum at.\n" +
            "\n" +
            "Ea simul essent eos, eu aliquip inciderint vix. Ius case complectitur ei. Mea interpretaris necessitatibus in, brute scribentur vim no. Quo eu movet veniam utinam, quo etiam errem ea. Altera explicari ex qui, vel an probo accusamus. Causae omnesque te quo, cu pro exerci accusam eleifend. In ius possim intellegat inciderint, doctus suscipit no usu.\n");

        View view = new View();
        view.setFlockml(
            "<flockml>Hello <strong>foobar</strong>, Welcome to <a href=\"https://flock.co/\">Flock!</a> <br> <em>HELLO WORLD ! 2nd FlockMl </em></flockml>");
        //        view.setFlockml("<em>HELLO WORLD ! 2nd FlockMl </em>"); // TODO add for all elements
        attachment.setViews(view);
        return (new Attachment[]{attachment});
    }

    public Attachment[] get_msg_view_flockml_()
    {
        Attachment attachment = new Attachment();
        attachment.setTitle("Title only");
        attachment.setDescription(
            "Lorem ipsum dolor sit amet, qui et exerci persius tractatos, mea in habeo accumsan, at sed esse propriae. Qui albucius euripidis interesset ne. Eam ut iisque feugiat posidonium. Vis porro quaestio pericula in. His ut salutandi conceptam consectetuer.\n" +
            "\n" +
            "Vim te urbanitas persecuti, scripta mnesarchum mel ad. Summo conceptam rationibus ei vim. Ei quo wisi ipsum, quidam aperiri no his. No pro adolescens deterruisset consequuntur, an has noluisse euripidis interesset. Mel posse perpetua mnesarchum at.\n");

        View view = new View();
        view.setFlockml(
            "<flockml>Hello <strong>foobar</strong>, Welcome to <a href=\"https://flock.co/\">Flock!</a></flockml>");
        view.setFlockml("<em>HELLO WORLD ! 2nd FlockMl </em>"); // TODO add for all elements
        attachment.setViews(view);
        return (new Attachment[]{attachment});
    }

    public Attachment[] get_msg_view_flockml_mention()
    {
        Attachment attachment = new Attachment();
        attachment.setTitle("*Title *");
        View view = new View();
        view.setFlockml(
            "<flockml><em>HELLO WORLD <strong>!<strong>  </em></flockml>"); // TODO add for all elements
        view.setFlockml(
            "<flockml><user userId=\"u:3qeququuup3j33wp\">FirstName LastName</user></flockml>"); //Hardcode to Phoebe's user id
        attachment.setViews(view);
        return (new Attachment[]{attachment});
    }

    public Attachment[] get_msg_imgbutton()
    {
        Attachment attachment = new Attachment();
        attachment.setTitle("*Title *");
        Button button = new Button();
        button.setIcon("https://cdn2.iconfinder.com/data/icons/web/512/Link-512.png");
        button.setId("111");
        Action action = new Action();
        action.addOpenBrowser(
            "https://www.google.co.in/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=icon+image+url",
            true);
        button.setAction(action);
        View view = new View();
        attachment.setViews(view);
        attachment.setButtons(new Button[]{button});
        return (new Attachment[]{attachment});
    }

    public Attachment[] get_msg_imgbutton_flockml()
    {
        Attachment attachment = new Attachment();
        attachment.setTitle("*Title *");


        View view = new View();
        view.setFlockml(
            "<flockml><em>HELLO WORLD <strong>!<strong>  </em></flockml>"); // TODO add for all elements
        attachment.setViews(view);

        Button button = new Button();
        button.setIcon("https://cdn2.iconfinder.com/data/icons/web/512/Link-512.png");
        button.setId("111");
        button.setName("Hello<br/>World");
        Action action = new Action();
        action.addOpenBrowser(
            "https://www.google.co.in/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=icon+image+url",
            true);
        button.setAction(action);

        Button button1 = new Button();
//        button1.setName(
//            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In quis finibus eros. Curabitur ornare enim a egestas fringilla. Fusce cursus nulla et ipsum cursus suscipit et eu arcu. Proin faucibus congue lorem lobortis hendrerit. Vestibulum sapien odio, iaculis a pellentesque ac, faucibus ut odio. Morbi aliquet ultricies nibh non ornare. Ut semper pretium velit, quis consequat mauris ultrices in. Integer euismod nec lorem volutpat posuere. In hac habitasse platea dictumst. Sed lobortis a mi id pulvinar");
        button1.setIcon("http://www.freeiconspng.com/uploads/blue-links-icon-5.jpg");
        button1.setId("222");
        button1.setAction(action);

        Button button2 = new Button();
        button2.setName("Button2. ");
        button2.setId("2222");
        button2.setIcon("http://image.shutterstock.com/z/stock-vector-vector-flat-design-modern-url-icon-wit-hand-clicking-on-website-link-web-designer-template-180324473.jpg");
        Action action1 = new Action();
        action1.addOpenWidget("www.google.com", "sidebar", "modal");
        button2.setAction(action1);

        Button button3 = new Button();
        button3.setName("Button3");
        button3.setId("333");
        button3.setIcon("http://image.shutterstock.com/z/stock-vector-vector-flat-design-modern-url-icon-wit-hand-clicking-on-website-link-web-designer-template-180324473.jpg");
        Action action2 = new Action();
        action1.addOpenWidget("www.google.com", "sidebar", "modal");
        button3.setAction(action2);

        attachment.setButtons(new Button[]{button, button1, button2, button3});

        return (new Attachment[]{attachment});
    }

}
