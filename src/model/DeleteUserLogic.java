package model;

import dao.DAOException;
import dao.DeleteMemberDao;

public class DeleteUserLogic {
	DeleteMemberDao deleteMemberDao = new DeleteMemberDao();
	    public boolean exute(SearchUser searchUser){
	        boolean registCheck = false;
	        //登録処理
	        try {
	        	 deleteMemberDao.deleteMember(searchUser);
	            //update.updateMember(user);
	            registCheck = true;
	        } catch (DAOException e) {
	            // TODO 自動生成された catch ブロック
	            e.printStackTrace();
	        }
	        return registCheck;
	    }
	}
