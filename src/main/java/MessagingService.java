import co.flock.www.FlockApiClient;
import co.flock.www.model.messages.Attachments.*;
import co.flock.www.model.messages.FlockMessage;
import co.flock.www.model.messages.Message;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

/**
 * Created by tanushee on 23/9/16.
 **/
public class MessagingService {


    private static final Logger _logger = Logger.getLogger(MessagingService.class);
    private static final String BOT_TOKEN = "d3f0bea6-eb89-4708-8408-092e6693c5d1";

    private AttachmentMessage _attachmentMessage = new AttachmentMessage();


    public void sendMsgTextOnly(String chatId) {
        _logger.debug(
                " user: " + Runner.userId + " Token: " + Runner.userToken + " chatId: " + chatId);
        Message message = new Message(chatId, "Test message text ");
        sendMessage(Runner.userToken, message);
    }

    public void sendMsgTextAttachmentTitle(String chatId) {
        _logger.debug(
                " user: " + Runner.userId + " Token: " + Runner.userToken + " chatId: " + chatId);
        Message message = new Message(chatId, "Test message text ");
        message.setAttachments(_attachmentMessage.get_msg_title());
        sendMessage(Runner.userToken, message);
    }

    public void sendMsgTextAttachmentTitleDescription(String chatId) {
        _logger.debug(
                " user: " + Runner.userId + " Token: " + Runner.userToken + " chatId: " + chatId);
        Message message = new Message(chatId, "Test message text ");
        message.setAttachments(_attachmentMessage.get_msg_title_description());
        String messageJson = new Gson().toJson(message);
        _logger.debug("messageJson: " + messageJson);
        sendMessage(Runner.userToken, message);
    }

    public void sendMsgAttachementFlockMl(String chatId) {
        _logger.debug(
                " user: " + Runner.userId + " Token: " + Runner.userToken + " chatId: " + chatId);
        Message message = new Message(chatId, "Test message text ");
        message.setAttachments(_attachmentMessage.get_msg_view_flockml());
        String messageJson = new Gson().toJson(message);
        _logger.debug("messageJson: " + messageJson);
        sendMessage(Runner.userToken, message);
    }

    public void sendMsgAttachmentFlockMlMention(String chatId) {
        _logger.debug(
                " user: " + Runner.userId + " Token: " + Runner.userToken + " chatId: " + chatId);
        Message message = new Message(chatId, "Test message text ");
        message.setAttachments(_attachmentMessage.get_msg_view_flockml_mention());
        String messageJson = new Gson().toJson(message);
        _logger.debug("messageJson: " + messageJson);
        sendMessage(Runner.userToken, message);
    }


    public void sendMessageType1(String chatId) {
        _logger.debug(
                " user: " + Runner.userId + " Token: " + Runner.userToken + " chatId: " + chatId);
        Message message = new Message(chatId, "Test message text ");
        //        Message message = new Message(bill.getApprover(), "Kindly approve");
        Attachment attachment = new Attachment();
        Button[] buttons = new Button[2];
        buttons[0] = new Button();
        buttons[0].setId("id1");
        buttons[0].setName(
                "Button11111111111111111111111111166666666666666666666666666666666666666666666666");
        Action action = new Action();
        action.addDispatchEvent(); // will call callback url;
        buttons[0].setAction(action);

        buttons[1] = new Button();
        buttons[1].setId("id2");
        buttons[1].setName("Button 2");
        action = new Action();
        action.addOpenBrowser("www.google.com", true);
        buttons[1].setAction(action);

        HtmlView htmlView = new HtmlView();
        htmlView.setInline(
                "<style type=\"text/css\">body { margin:0; padding:0; } ul { margin:0; padding: 5px 0 0 20px; } li { line-height:19px; } </style><div style=\"font-family:'Lucida Grande',Arial,sans-serif;font-size:14px;font-weight:400\"><ul><li>Amount Requested: Rs. bill.getAmount()" +
                        "</li><li>Status: " + " bill.getStatus().toString()" + "</li></ul></div>");
        View views = new View();
        views.setHtml(htmlView);

        //        Image original = new Image();
        //        original.setSrc(bill.getPath());
        //        ImageView imageView = new ImageView(original);
        //        views.setImage(imageView);

        //                WidgetView widgetView = new WidgetView();
        //                widgetView.setSrc("https://tanushee.fwd.wf/view?billId=" + bill.getId());
        //                views.setWidget(widgetView);
        attachment.setViews(views);
        attachment.setButtons(buttons);
        //                attachment.setDescription("Status: " + bill.getStatus());
        //                attachment.setTitle("Amount: " + bill.getAmount());
        message.setAttachments(new Attachment[]{attachment});
        String messageJson = new Gson().toJson(message);
        _logger.debug("messageJson: " + messageJson);
        //        sendMessage(user.getUserToken(), message);
        sendMessage(Runner.userToken, message);
    }


    public void sendMessageType2(String chatId) {
        _logger.debug(" user: " + Runner.userId + " chatId: " + chatId);
        Message message = new Message(chatId, "Test message text ");
        //        Message message = new Message(bill.getApprover(), "Kindly approve");
        Attachment attachment = new Attachment();
        Button[] buttons = new Button[2];
        buttons[0] = new Button();
        buttons[0].setId("id1");
        buttons[0].setName("Button111111111111111111111111111666666666666666666666" + "\n" +
                "6666666666666666666666666666666666666666666");
        Action action = new Action();
        action.addDispatchEvent(); // will call callback url;
        buttons[0].setAction(action);

        buttons[1] = new Button();
        buttons[1].setId("id2");
        buttons[1].setName("Button 2");
        action = new Action();
        action.addOpenBrowser("www.google.com", true);
        buttons[1].setAction(action);

        HtmlView htmlView = new HtmlView();
        //        htmlView.setInline(
        //            "<style type=\"text/css\">body { margin:0; padding:0; } ul { margin:0; padding: 5px 0 0 20px; } li { line-height:19px; } </style><div style=\"font-family:'Lucida Grande',Arial,sans-serif;font-size:14px;font-weight:400\"><ul><li>Amount Requested: Rs. bill.getAmount()" +
        //            "</li><li>Status: " + " bill.getStatus().toString()" + "</li></ul></div>");
        htmlView.setInline("\"Any valid html can go <b>here</b>.\"");
        View views = new View();
        views.setHtml(htmlView);
        attachment.setViews(views);
        attachment.setButtons(buttons);
        message.setAttachments(new Attachment[]{attachment});
        String messageJson = new Gson().toJson(message);
        _logger.debug("messageJson: " + messageJson);
        //        sendMessage(user.getUserToken(), message);
        sendMessage(Runner.userToken, message);

    }


    public void sendMessageTypeFlockML(String chatId) {
        _logger.debug(" user: " + Runner.userId + " chatId: " + chatId);
        Message message = new Message(chatId, "ONLY FLOCK ML");
        //        Message message = new Message(bill.getApprover(), "Kindly approve");
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
        String messageJson = new Gson().toJson(message);
        _logger.debug("messageJson: " + messageJson);
        sendMessage(Runner.userToken, message);
    }

    public void sendMessageTypeFlockMLInAttachment(String chatId) {
        _logger.debug(" user: " + Runner.userId + " chatId: " + chatId);
        Message message = new Message(chatId, "ONLY FLOCK ML");
        //        Message message = new Message(bill.getApprover(), "Kindly approve");
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
        String messageJson = new Gson().toJson(message);
        _logger.debug("messageJson: " + messageJson);
        sendMessage(Runner.userToken, message);
    }


    private static void sendMessage(String token, Message message) {
        _logger.debug("Sending message to  : " + message.getTo() + " text : " + message.getText() +
                "User token: " + token + "Runner token" + Runner.userToken);
        FlockMessage flockMessage = new FlockMessage(message);
        FlockApiClient flockApiClient = new FlockApiClient(token, true);
        try {
            String responseBody = flockApiClient.chatSendMessage(flockMessage);
            _logger.debug("responseBody: " + responseBody);
        } catch (Exception e) {
            _logger.error("Failed to send message: ", e);
        }
    }
}
