import org.apache.log4j.Logger;
import org.json.JSONObject;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import java.sql.SQLException;
import java.util.*;

import static spark.Spark.*;

/**
 * Created by tanushee on 23/9/16.
 **/
public class Runner {

    private static final Logger _logger = Logger.getLogger(Runner.class);
    private static MessagingService _messagingService;
    public static String userId = "u:bsy83reyjc87ya6q";
    public static String userToken = "1c5c380b-0a02-4774-af55-81291dfca107";

    public static void main(String[] args) throws Exception {
        //secure("deploy/keystore.jks", "password", null, null);
        _logger.debug("Starting..");
        //        _dbManager = new DbManager(getDbConfig());
        _messagingService = new MessagingService();
        port(9000);
        HashMap map = new HashMap();
        staticFileLocation("/public");
        map.put("resourcePrefix", "");
        get("/new", (req, res) -> new ModelAndView(map, "template.mustache"),
                new MustacheTemplateEngine());

        post("/create", (req, res) -> {
            String body = req.body();
            _logger.debug("Received request with body: " + body);
            JSONObject jsonObject = new JSONObject(body);
            int amount = Integer.parseInt(jsonObject.getString("amount"));
            String requestorId = jsonObject.getString("requestorId");
            String requestorName = jsonObject.getString("requestorName");
            String approverId = jsonObject.getString("approverId");
            String approverName = jsonObject.getString("approverName");
//            ApprovalRequest approvalRequest = new ApprovalRequest(amount, requestorId,
//                    requestorName, approverId, approverName);
//            _logger.debug("approvalRequest created: " + approvalRequest);
            //            User user = _dbManager.getUserById(approvalRequest.getRequestorId());
            //            _logger.debug("requestor user: " + user);
            //
            //            insertBillAndSendMsg(approvalRequest, user);
            return "Approval created";
        });

//        get("/viewall",
//                (req, res) -> new ModelAndView(getLauncherMap(req.queryParams("flockEvent")),
//                        "template_launcher.mustache"), new MustacheTemplateEngine());
//
//        get("/view",
//                (req, res) -> new ModelAndView(getLauncherMapForBill(req.queryParams("billId")),
//                        "template_bill.mustache"), new MustacheTemplateEngine());


//        post("/approve", (req, res) -> {
//            _logger.debug("Received approval request with body: " + req.body());
//            return approveOrRejectBill(req, true);
//        });
//
//        post("/reject", (req, res) -> {
//            _logger.debug("Received rejection request with body: " + req.body());
//            return approveOrRejectBill(req, false);
//        });

        post("/", (req, res) -> {
            _logger.debug("Req received : " + req.body());
            JSONObject jsonObject = new JSONObject(req.body());
            String type = (String) jsonObject.get("name");
            _logger.debug("Got event: " + type);
            if ("app.install".equals(type)) {
                String userId = jsonObject.getString("userId");
                String userToken = jsonObject.getString("userToken");
                //                _dbManager.insertOrUpdateUser(new User(userId, userToken));
                Runner.userId = userId;
                Runner.userToken = userToken;
                _logger.debug("User inserted : " + userId + " User Token : " + userToken +
                        "Make sure to change it at each install or uninstall. currently it's hardcode.");
            } else if ("app.uninstall".equalsIgnoreCase(type)) {
                String userId = jsonObject.getString("userId");
                //                _dbManager.deleteUser(new User(userId, ""));
                _logger.debug("User deleted : " + userId);
            } else if ("client.pressButton".equalsIgnoreCase(type)) {

            } else if ("client.slashCommand".equalsIgnoreCase(type)) {
                _logger.debug("Processing slash cmd press");
                String text = jsonObject.getString("text");
                String cmd = jsonObject.getString("command");

                if (cmd.toLowerCase().equalsIgnoreCase("test1")) {
                    String chatId = jsonObject.getString("chat");
                    String userId = jsonObject.getString("userId");
                    //                    User user = _dbManager.getUserById(userId);

                    switch (text) {
                        case "test":
                            _messagingService.sendMessageType1(chatId);
                            break;
                        case "test1":
                            _messagingService.sendMessageType2(chatId);
                            break;
                        case "flockml":
                            _messagingService.sendMessageTypeFlockML(chatId);
                            break;
                        case "flockmlAtt":
                            _messagingService.sendMessageTypeFlockMLInAttachment(chatId);
                            break;
                        case "text":
                            _messagingService.sendMsgTextOnly(chatId);
                            break;
                        case "attach_title":
                            _messagingService.sendMsgTextAttachmentTitle(chatId);
                            break;
                        case "attach_flockml":
                            _messagingService.sendMsgAttachementFlockMl(chatId);
                            break;
                        case "attach_flockml_mention":
                            _messagingService.sendMsgAttachmentFlockMlMention(chatId);
                            break;
                        case "attach_imgbutton":
                            _messagingService.sendMsgImageButton(chatId);
                            break;
                        case "attach_imgbutton_flockml":
                            _messagingService.sendMsgImageButtonFlockMl(chatId);
                            break;
                    }
                }
            }
            return "";
        });
    }


    private static String getBaseUrl() {
        ResourceBundle bundle = ResourceBundle.getBundle("config", Locale.getDefault());
        return bundle.getString("base_url");
    }

}
