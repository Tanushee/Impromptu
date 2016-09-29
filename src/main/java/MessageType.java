import co.flock.www.model.messages.Attachments.*;
import co.flock.www.model.messages.Message;

import com.google.gson.Gson;

import org.apache.log4j.Logger;

/**
 * Created by tanushee on 23/9/16.
 **/
public class MessageType
{

    private static final Logger _logger = Logger.getLogger(MessagingService.class);

    public Message set_title(Message message)
    {
        Attachment attachment = new Attachment();
        attachment.setTitle("Title only");
        message.setAttachments(new Attachment[]{attachment});

        return (message);
    }

    public Message set_msg_title_description(Message message)
    {
        Attachment attachment = new Attachment();
        attachment.setTitle("Title only");
        attachment.setDescription(
            "Lorem ipsum dolor sit amet, qui et exerci persius tractatos, mea in habeo accumsan, at sed esse propriae. Qui albucius euripidis interesset ne. Eam ut iisque feugiat posidonium. Vis porro quaestio pericula in. His ut salutandi conceptam consectetuer.\n" +
            "\n" +
            "Vim te urbanitas persecuti, scripta mnesarchum mel ad. Summo conceptam rationibus ei vim. Ei quo wisi ipsum, quidam aperiri no his. No pro adolescens deterruisset consequuntur, an has noluisse euripidis interesset. Mel posse perpetua mnesarchum at.\n" +
            "\n" +
            "Ea simul essent eos, eu aliquip inciderint vix. Ius case complectitur ei. Mea interpretaris necessitatibus in, brute scribentur vim no. Quo eu movet veniam utinam, quo etiam errem ea. Altera explicari ex qui, vel an probo accusamus. Causae omnesque te quo, cu pro exerci accusam eleifend. In ius possim intellegat inciderint, doctus suscipit no usu.\n");
        message.setAttachments(new Attachment[]{attachment});
        return (message);
    }

    public Message set_msg_html_type1(Message message)
    {
        _logger.info("Inside html ");
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
        htmlView.setInline("<p>&nbsp; &nbsp; &nbsp; &nbsp; lalalalalalallaalal <br> &nbsp; &nbsp; &nbsp;</p>\n" +
                           "\"<img src=https://html-online.com/img/01-interactive-connection.png onerror=prompt(\"removed\");> ");
        view.setHtml(htmlView);
        attachment.setViews(view);
        message.setAttachments(new Attachment[]{attachment});
        return (message);
    }

    public Message set_view_flockml(Message message)
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
        message.setAttachments(new Attachment[]{attachment});

        return (message);
    }

    public Message get_msg_view_flockml_(Message message)
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
        message.setAttachments(new Attachment[]{attachment});

        return (message);
    }

    public Message set_view_flockml_mention(Message message)
    {
        Attachment attachment = new Attachment();
        attachment.setTitle("*Title *");
        View view = new View();
        view.setFlockml(
            "<flockml><em>HELLO WORLD <strong>!<strong>  </em></flockml>"); // TODO add for all elements
        view.setFlockml(
            "<flockml><user userId=\"u:3qeququuup3j33wp\">FirstName LastName</user></flockml>"); //Hardcode to Phoebe's user id
        attachment.setViews(view);
        message.setAttachments(new Attachment[]{attachment});

        return (message);
    }

    public Message set_imgbutton(Message message)
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
        message.setAttachments(new Attachment[]{attachment});
        return (message);
    }

    public Message set_imgbutton_flockml(Message message)
    {
        _logger.debug("Inside set_imgbutton_flockml: " + message);

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
        button2.setIcon(
            "http://image.shutterstock.com/z/stock-vector-vector-flat-design-modern-url-icon-wit-hand-clicking-on-website-link-web-designer-template-180324473.jpg");
        Action action1 = new Action();
        action1.addOpenWidget("www.google.com", "sidebar", "modal");
        button2.setAction(action1);

        Button button3 = new Button();
        button3.setName("Button3");
        button3.setId("333");
        button3.setIcon(
            "http://image.shutterstock.com/z/stock-vector-vector-flat-design-modern-url-icon-wit-hand-clicking-on-website-link-web-designer-template-180324473.jpg");
        Action action2 = new Action();
        action1.addOpenWidget("www.google.com", "sidebar", "modal");
        button3.setAction(action2);

        attachment.setButtons(new Button[]{button, button1, button2, button3});
        message.setAttachments(new Attachment[]{attachment});
        String messageJson = new Gson().toJson(message);
        _logger.debug("messageJson: " + messageJson);
        return (message);
    }

    public Message sendMessageTypeFlockML(Message message)
    {
        Attachment attachment = new Attachment();
        Button[] buttons = new Button[2];
        buttons[0] = new Button();
        buttons[0].setId("id1");
        buttons[0].setName("Platform Icon");
        buttons[0].setIcon("http://www.freeiconspng.com/free-images/platform-icon-9646");

        Action action = new Action();
        action.addDispatchEvent(); // will call callback url;
        buttons[0].setAction(action);

        buttons[1] = new Button();
        buttons[1].setId("id2");
        buttons[1].setName("Button 2");
        action = new Action();
        action.addOpenBrowser("www.google.com", true);
        buttons[1].setAction(action);

        attachment.setButtons(buttons);
        //                attachment.setDescription("Status: " + bill.getStatus());
        //                attachment.setTitle("Amount: " + bill.getAmount());
        message.setFlockml(
            "<flockml>Hello <strong>foobar</strong>, Welcome to <a href=\"https://flock.co/\">Flock!</a></flockml>");
        message.setAttachments(new Attachment[]{attachment});
        return message;
    }


    public Message set_text1(Message message)
    {
        message.setText(
            "https://www.google.co.in/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=icon+image+url");
        return message;
    }

    public Message set_text2(Message message)
    {
        message.setText("<html>" +
                        "<h1 style=\"color: #5e9ca0;\">You can edit <span style=\"color: #2b2301;\">this demo</span> text!</h1>\n" +
                        "<h2 style=\"color: #2e6c80;\">How to use the editor:</h2>\n" +
                        "<p>Paste your documents in the visual editor on the left or your HTML code in the source editor in the right. <br />Edit any of the two areas and see the other changing in real time.&nbsp;</p>\n" +
                        "<p>Click the <span style=\"background-color: #2b2301; color: #fff; display: inline-block; padding: 3px 10px; font-weight: bold; border-radius: 5px;\">Clean</span> button to clean your source code.</p>\n" +
                        "<h2 style=\"color: #2e6c80;\">Some useful features:</h2>\n" +
                        "<ol style=\"list-style: none; font-size: 14px; line-height: 32px; font-weight: bold;\">\n" +
                        "<li style=\"clear: both;\"><img style=\"float: left;\" src=\"https://html-online.com/img/01-interactive-connection.png\" alt=\"interactive connection\" width=\"45\" /> Interactive source editor</li>\n" +
                        "<li style=\"clear: both;\"><img style=\"float: left;\" src=\"https://html-online.com/img/02-html-clean.png\" alt=\"html cleaner\" width=\"45\" /> HTML Cleaning</li>\n" +
                        "<li style=\"clear: both;\"><img style=\"float: left;\" src=\"https://html-online.com/img/03-docs-to-html.png\" alt=\"Word to html\" width=\"45\" /> Word to HTML conversion</li>\n" +
                        "<li style=\"clear: both;\"><img style=\"float: left;\" src=\"https://html-online.com/img/04-replace.png\" alt=\"replace text\" width=\"45\" /> Find and Replace</li>\n" +
                        "<li style=\"clear: both;\"><img style=\"float: left;\" src=\"https://html-online.com/img/05-gibberish.png\" alt=\"gibberish\" width=\"45\" /> Lorem-Ipsum generator</li>\n" +
                        "<li style=\"clear: both;\"><img style=\"float: left;\" src=\"https://html-online.com/img/6-table-div-html.png\" alt=\"html table div\" width=\"45\" /> Table to DIV conversion</li>\n" +
                        "</ol>\n" +
                        "<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p>\n" +
                        "<h2 style=\"color: #2e6c80;\">Cleaning options:</h2>\n" +
                        "<table class=\"editorDemoTable\">\n" +
                        "<thead>\n" +
                        "<tr>\n" +
                        "<td>Name of the feature</td>\n" +
                        "<td>Example</td>\n" +
                        "<td>Default</td>\n" +
                        "</tr>\n" +
                        "</thead>\n" +
                        "<tbody>\n" + "</html>");
        return message;
    }

    public Message set_text3(Message message)
    {
        message.setText("<form action=\"#\" method=\"post\">\n" +
                        "  <fieldset>\n" +
                        "    <label for=\"name\">Name:</label>\n" +
                        "    <input type=\"text\" id=\"name\" placeholder=\"Enter your \n" +
                        "full name\" />\n" +
                        "\n" +
                        "    <label for=\"email\">Email:</label>\n" +
                        "    <input type=\"email\" id=\"email\" placeholder=\"Enter \n" +
                        "your email address\" />\n" +
                        "\n" +
                        "    <label for=\"message\">Message:</label>\n" +
                        "    <textarea id=\"message\" placeholder=\"What's on your \n" +
                        "mind?\"></textarea>\n" +
                        "\n" +
                        "    <input type=\"submit\" value=\"Send message\" />\n" +
                        "\n" +
                        "  </fieldset>\n" +
                        "</form>\n");
        return message;
    }

    public Message set_text4(Message message)
    {
        message.setText(" <form action=\"HINDI.jsp\" method=\"POST\"/>\n" +
                        "        <b>कृपया अपना नाम प्रवेश करे</b>:<br>\n" +
                        "        <script language=\"javascript\">\n" +
                        "            CreateHindiTextBox(\"hindiText\");\n" +
                        "        </script>\n" +
                        "        <input type=\"submit\" value=\"submit\"/>" +
                        "असरकारक व्याख्या पहेला खण्ड गटकउसि सभिसमज साधन समजते पहेला प्रदान सुस्पश्ट कार्यसिधान्तो पढने सुविधा व्रुद्धि प्रौध्योगि. 登媛範験入術考氏置闘出大鶴踏約日靖。台都延川消生問以表何外道新座姦。夫提和沢教破造計襲女理講同移派最感土待下。. Lorem Ipsum -- 隆社だむい負称や長彩ラ説19毎室まくすひ。<aRABIC> إختار المؤلّفة عل وفي. واحدة ويعزى تزامناً انه ان, بـ");
        return message;
    }

    public Message set_text(Message message)
    {
        message.setText(
            "Hong Kong Phooey, number one super guy. Hong Kong Phooey, quicker than the human eye. He's got style, a groovy style, and a car that just won't stop. When the going gets tough, he's really rough, with a Hong Kong Phooey chop (Hi-Ya!). Hong Kong Phooey, number one super guy. Hong Kong Phooey, quicker than the human eye. Hong Kong Phooey, he's fan-riffic!");
        return message;
    }

    public Message set_flockML_attachment(Message message)
    {
        Attachment attachment = new Attachment();
        Button[] buttons = new Button[2];
        buttons[0] = new Button();
        buttons[0].setId("id1");
        buttons[0].setName("Platform Icon");
        buttons[0].setIcon("http://www.freeiconspng.com/free-images/platform-icon-9646");

        Action action = new Action();
        action.addDispatchEvent(); // will call callback url;
        buttons[0].setAction(action);

        buttons[1] = new Button();
        buttons[1].setId("id2");
        buttons[1].setName("Button 2");
        action = new Action();
        action.addOpenBrowser("www.google.com", true);
        buttons[1].setAction(action);

        attachment.setButtons(buttons);
        //        attachment
        message.setFlockml(
            "<flockml>Hello <strong>foobar</strong>, Welcome to <a href=\"https://flock.co/\">Flock!</a></flockml>");
        message.setAttachments(new Attachment[]{attachment});
        return message;
    }
}
