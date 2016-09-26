import co.flock.www.FlockApiClient;
import co.flock.www.model.messages.Attachments.Action;
import co.flock.www.model.messages.Attachments.Attachment;
import co.flock.www.model.messages.Attachments.Button;
import co.flock.www.model.messages.FlockMessage;
import co.flock.www.model.messages.Message;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

/**
 * Created by tanushee on 23/9/16.
 **/
public class MessagingService {

    private static final Logger _logger = Logger.getLogger(MessagingService.class);

    private MessageType _messageType = new MessageType();

    public void sendPlatformMessage(String commandText, String chatId) {

        _logger.debug(
                " user: " + Runner.userId + " Token: " + Runner.userToken + " chatId: " + chatId);
        Message message = new Message(chatId, "Message for incorrect type " + commandText);

        switch (commandText) {
            case "flockml":
                message = _messageType.sendMessageTypeFlockML(message);
                break;
            case "flockmlAtt":
                message = _messageType.set_flockML_attachment(message);
                break;
            case "text":
                message = _messageType.set_text(message);
                break;
            case "attach_title":
                message = _messageType.set_title(message);
                break;
            case "attach_flockml":
                message = _messageType.set_view_flockml(message);
                break;
            case "attach_flockml_mention":
                message = _messageType.set_view_flockml_mention(message);
                break;
            case "attach_imgbutton":
                message = _messageType.set_imgbutton(message);
                break;
            case "attach_imgbutton_flockml":
                message = _messageType.set_imgbutton_flockml(message);
                break;
        }
        String messageJson = new Gson().toJson(message);
        _logger.debug("Returned MessageJson: " + messageJson);
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
