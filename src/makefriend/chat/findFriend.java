package makefriend.chat;

import makefriend.makefriendonline.linkDatabases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class findFriend {
    public findFriend(String user_id, String friend_id) throws SQLException, ClassNotFoundException {
        friendList = new ArrayList<String>();
        boolean keyOfLinkdatabase = false;
        sqlI = new String();
        sqlII = new String();
        sqlI = "select * from my_friends where my_id = \'" + user_id + "\' and friendship = 1;";
        sqlII = "select * from my_friends where my_friend_id = \'" + user_id + "\' and friendship = 1;";
        this.getData();
    }

    public void getData() throws ClassNotFoundException, SQLException {
        linkDatabases lpLinkDatabases = new linkDatabases();
        ResultSet resultSet = lpLinkDatabases.getInformation(sqlI);

        while(resultSet.next()) {
            //好友编号
            String friend_id = resultSet.getString("my_friend_id");
            //System.out.println(friend_id);
            friendList.add(friend_id);
            System.out.println(friend_id);

        }
        lpLinkDatabases = new linkDatabases();
        resultSet = null;
        resultSet = lpLinkDatabases.getInformation(sqlII);
        while(resultSet.next()) {
            //好友编号
            String friend_id = resultSet.getString("my_id");
            //System.out.println(friend_id);
            friendList.add(friend_id);
            System.out.println(friend_id);
        }
    }

    public boolean isFriend(String friend_id) {
        boolean returnKey = false;
        for (int i=0;i<this.friendList.size();i++) {
            System.out.println(this.friendList.get(i) + " : " + friend_id);
            if (this.friendList.get(i).equals(friend_id)) {
                returnKey = true;
            }
        }
        return returnKey;
    }


    private String sqlI = null;
    private String sqlII = null;
    private ArrayList<String> friendList = null;
}
