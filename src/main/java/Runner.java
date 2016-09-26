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

        post("/", (req, res) -> {
            _logger.debug("Req received : " + req.body());
            JSONObject jsonObject = new JSONObject(req.body());
            String type = (String) jsonObject.get("name");
            _logger.debug("Got event: " + type);
            if ("app.install".equals(type)) {
                String userId = jsonObject.getString("userId");
                String userToken = jsonObject.getString("userToken");
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

                if (cmd.toLowerCase().equalsIgnoreCase("app")) {
                    String chatId = jsonObject.getString("chat");
                    String userId = jsonObject.getString("userId");
                    //                    User user = _dbManager.getUserById(userId);

                    _messagingService.sendPlatformMessage(text, chatId);
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
