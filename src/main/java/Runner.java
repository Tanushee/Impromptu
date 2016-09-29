import database.DbConfig;
import database.DbManager;
import database.User;

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
public class Runner
{

    private static final Logger _logger = Logger.getLogger(Runner.class);
    private static MessagingService _messagingService;
    private static DbManager _dbManager;

    public static void main(String[] args) throws Exception
    {
        _logger.debug("Starting..");
        _dbManager = new DbManager(getDbConfig());
        _messagingService = new MessagingService();
        port(9000);
        HashMap map = new HashMap();
        staticFileLocation("/public");
        map.put("resourcePrefix", "");
        get("/new", (req, res) -> new ModelAndView(map, "template.mustache"),
            new MustacheTemplateEngine());

        post("/", (req, res) -> {
            _logger.debug("Req received : " + req.body());
            JSONObject jsonObject = new JSONObject(req.body());
            String type = (String) jsonObject.get("name");
            _logger.debug("Got event: " + type);
            if ("app.install".equals(type)) {
                String userId = jsonObject.getString("userId");
                String userToken = jsonObject.getString("userToken");
                User user = new User(userId, userToken);
                _dbManager.insertOrUpdateUser(user);
                _logger.debug("User inserted : " + userId + " User Token : " + userToken +
                              "Make sure to change it at each install or uninstall. ");
            } else if ("app.uninstall".equalsIgnoreCase(type)) {
                String userId = jsonObject.getString("userId");
                _dbManager.deleteUser(new User(userId, ""));
                _logger.debug("User deleted : " + userId);
            } else if ("client.pressButton".equalsIgnoreCase(type)) {

            } else if ("client.slashCommand".equalsIgnoreCase(type)) {
                _logger.debug("Processing slash cmd press");
                String text = jsonObject.getString("text");
                String cmd = jsonObject.getString("command");

                if (cmd.toLowerCase().equalsIgnoreCase("app")) {
                    String chatId = jsonObject.getString("chat");
                    String userId = jsonObject.getString("userId");
                    _logger.info("User Id " + userId);
                    User user = _dbManager.getUserById(userId);

                    _messagingService.sendPlatformMessage(text, chatId, user);
                }
            }
            return "";
        });
    }


    private static DbConfig getDbConfig()
    {
        ResourceBundle bundle = ResourceBundle.getBundle("config", Locale.getDefault());
        return new DbConfig(bundle.getString("db_host"),
            Integer.parseInt(bundle.getString("db_port")), bundle.getString("db_name"),
            bundle.getString("db_username"), bundle.getString("db_password"));
    }

    private static String getBaseUrl()
    {
        ResourceBundle bundle = ResourceBundle.getBundle("config", Locale.getDefault());
        return bundle.getString("base_url");
    }

  /*  private static Map<String, List<Bill>> getLauncherMap(String queryString) throws SQLException
    {
        Map<String, List<Bill>> s = new HashMap<>();
        _logger.debug("String : " + queryString);
        JSONObject jsonObject = new JSONObject(queryString);
        String userId = jsonObject.getString("userId");
        _logger.debug("Userid : " + userId);

        List<Bill> bills = _dbManager.getBillsForUser(userId);
        _logger.debug("Bills fetched : " + bills);
        s.put("bills", bills);
        return s;
    }*/

}
