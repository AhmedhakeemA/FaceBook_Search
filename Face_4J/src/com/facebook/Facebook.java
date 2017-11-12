package com.facebook;


import facebook4j.Comment;
import facebook4j.FacebookBase;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Group;
import facebook4j.GroupMember;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.api.SearchMethods;
import facebook4j.auth.AccessToken;
import facebook4j.auth.OAuthSupport;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class Facebook {

	public Facebook() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws FacebookException {

		String acesstoken=" ";

		facebook4j.Facebook facebook = new FacebookFactory().getInstance();
	
	
			facebook.setOAuthAppId("", "");
        facebook.setOAuthPermissions("user_friends,user_groups,user_photos,user_videos,user_birthday,user_status,user_likes,user_activities,user_location");
         facebook.setOAuthAccessToken(new AccessToken(acesstoken, null));
		
      //-----------------------------------------------------------
//        ResponseList<Post> resultsvv = facebook.getGroupFeed("BMW");
//         for (Post posts : resultsvv) {
//            System.out.println(posts.getMessage());
//             //System.out.println(posts.getFrom().getName());
//             PagableList<Comment> comments = posts.getComments();
//         }
//         
//         
       
         
      
//-----------------------------------------------------------------
//         ResponseList<Post> resultsvv = facebook.searchPosts("watermelon");
//         for (Post posts : resultsvv) {
//             System.out.println(posts);
//         }
//         System.out.println("11111111111111111");

         ResponseList<Group> results = facebook.searchGroups("BMW");

         String[] parts = results.toString().split(",");

         String[] new_Parts = new String[parts.length];

         String[] Final_Filter = new String[new_Parts.length];

         for (int i = 0; i < parts.length; i++) {
             new_Parts[i] = parts[i].trim();
         }

         for (int i = 0; i < new_Parts.length; i++) {
             if (new_Parts[i].contains("id") && !(new_Parts[i].contains("http"))) {
                 Final_Filter[i] = new_Parts[i].replaceAll("id", "").replaceAll("=", "").replaceAll("'", "").replaceAll("[^\\d]", "");
             }
         }
         List<String> list = new ArrayList<String>();
         for (String s : Final_Filter) {
             if (s != null && s.length() > 0) {
                 list.add(s);
             }
         }

         Final_Filter = list.toArray(new String[list.size()]);

         for (int i = 0; i < Final_Filter.length; i++) {
             System.out.println(Final_Filter[i]);
         }

         for (int j = 0; j < Final_Filter.length; j++) {
             ResponseList<Post> feeds = facebook.getFeed(Final_Filter[j],
                     new Reading().limit(200));

             // For all 25 feeds...
             for (int i = 0; i < feeds.size(); i++) {
                 // Get post.
                 Post post = feeds.get(i);
                 // Get (string) message.
                 String message = post.getMessage();
                 // Print out the message.
                 System.out.println(post);
                  //post.getUpdatedTime()

                 // Get more stuff...
                 PagableList<Comment> comments = post.getComments();
                // String date = post.getCreatedTime().toString();
                 //String name = post.getFrom().getName();
                 //String id = post.getId();

                 //baygeeb kol al postst ally fe page 11405---- ally heya kaamal agsam
                 //System.out.println(post.getMessage());
                 //System.out.println(post.getFrom().getName());
                 // if (FacebookContainTheWord(Word, post.toString()) && !FacebookIsEmpty(post.toString()) && !FacebookIsRecorded(post.toString(), FacebookList)) {

                 

                 for (Comment post_comment : comments) {
                     //System.out.println(post_comment);
                     //FacebookList.add(post_comment);
                 }
                 //}

                 //baygeeb kol al Comments ally fe page 11405---- ally heya kaamal agsam
                // System.out.println( name+ "       " + comments + "\n");

             }
         }

     

//------------------------------------------------------------------
	}

}
