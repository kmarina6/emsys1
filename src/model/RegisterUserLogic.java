package model;

import dao.DAOException;
import dao.MemberDao;
//import update.Update;

public class RegisterUserLogic {
  MemberDao memberDao = new MemberDao();
 // Update update = new Update();
    public boolean exute(User user){
        boolean registCheck = false;
        //登録処理
        try {
            memberDao.insertMember(user);
            //update.updateMember(user);
            registCheck = true;
        } catch (DAOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        return registCheck;
    }
}