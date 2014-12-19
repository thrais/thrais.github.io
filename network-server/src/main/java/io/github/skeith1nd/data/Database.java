package io.github.skeith1nd.data;

import io.github.skeith1nd.network.core.INetworkObject;
import io.github.skeith1nd.network.core.player.Player;
import org.json.JSONObject;

public class Database {
    private static Database instance;
    private Database(){}

    private String data = "{\n" +
            "    \"skeith1nd\" : {\n" +
            "        \"name\" : \"steve\",\n" +
            "        \"level\" : 1,\n" +
            "        \"room\" : 1,\n" +
            "        \"x\" : 200,\n" +
            "        \"y\" : 200,\n" +
            "        \"type\" : \"man1\"\n" +
            "    },\n" +
            "    \"danielpuder\" : {\n" +
            "        \"name\" : \"daniel\",\n" +
            "        \"level\" : 1,\n" +
            "        \"room\" : 1,\n" +
            "        \"x\" : 250,\n" +
            "        \"y\" : 220,\n" +
            "        \"type\" : \"man1\"\n" +
            "    }\n" +
            "}";

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Player getPlayer(String userId) {
        Player result = new Player();

        JSONObject jsonObject = new JSONObject(data);
        JSONObject jsonUser = jsonObject.getJSONObject(userId);

        result.setUser(userId);
        result.setType(jsonUser.getString("type"));
        result.setX(jsonUser.getInt("x"));
        result.setY(jsonUser.getInt("y"));

        return result;
    }
}
