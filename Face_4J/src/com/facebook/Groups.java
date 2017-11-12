package com.facebook;
import facebook4j.Comment;
import facebook4j.FacebookBase;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Friendlist;
import facebook4j.Group;
import facebook4j.GroupMember;
import facebook4j.PagableList;
import facebook4j.Page;
import facebook4j.Post;
import facebook4j.RawAPIResponse;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.api.FriendMethods;
import facebook4j.api.SearchMethods;
import facebook4j.auth.AccessToken;
import facebook4j.auth.OAuthSupport;
import facebook4j.internal.org.json.JSONException;
import facebook4j.internal.org.json.JSONObject;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
public class Groups {

	

	public static void main(String[] args) throws FacebookException, JSONException {
	
		
		String acesstoken="";
		facebook4j.Facebook facebook = new FacebookFactory().getInstance();
	
	
			facebook.setOAuthAppId("", "");
        facebook.setOAuthPermissions("email,user_friends_email,user_groups,user_photos,user_videos,user_birthday,user_status,user_likes,user_activities,user_location");
         facebook.setOAuthAccessToken(new AccessToken(acesstoken, null));
         
         
//         ResponseList<Group> results = facebook.searchGroups("maadi");
//
//		for (Group group : results) {
//			//System.out.println(group.getName());
//			System.out.println(group.getId());
//			  ResponseList<Post> feeds = facebook.getFeed(group.getId(),
//	                     new Reading().limit(200));
//			
//			  for (int i = 0; i < feeds.size(); i++) 
//			  {
//				  Post post = feeds.get(i);
//	               
//	                 String message = post.getMessage();
//	               
//
//	                // System.out.println(message);
//			  }
//			
//		}

//        ResponseList<Post> oList= facebook.getFeed("1404372443214887",  new Reading().limit(200));
//        
//        for (Post page : oList) {
//		System.out.println(page.getMessage());
//		}
         int i=0;
		ResponseList<GroupMember> members=facebook.getGroupMembers("1404372443214887",new Reading().limit(2000));
		for (GroupMember groupMember : members) {
			System.out.println(groupMember.getId()+" "+groupMember.getName()+" "+groupMember.getLocale()+" "+"----------"+i++);
			//System.out.println(groupMember.getId());
			
		}
		
		
		User user = facebook.getUser("151615425570303", new Reading().fields("email"));
		
		System.out.println(user.getEmail());
		
	}

}
