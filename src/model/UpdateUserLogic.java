package model;

import dao.DAOException;
import dao.UpdateMemberDao;

public class UpdateUserLogic {
	UpdateMemberDao updateMemberDao = new UpdateMemberDao();
	    public boolean exute(UserToUpdate userToUpdate){
	        boolean registCheck = false;
	        //登録処理
	        try {
	        	updateMemberDao.updateMember(userToUpdate);
	            registCheck = true;
	        } catch (DAOException e) {
	            // TODO 自動生成された catch ブロック
	            e.printStackTrace();
	        }
	        return registCheck;
	    }
	}
