package com.entity.vo;

import com.entity.DiscusswealthmanagementproductsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * @author
 * @email 
 * @date 2023-11-10 11:38:27
 */
public class DiscusswealthmanagementproductsVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			

	private Long userid;
		
	/**
	 * head sculpture
	 */
	
	private String avatarurl;
		
	/**
	 * Username
	 */
	
	private String nickname;
		
	/**
	 * No.Comment content
	 */
	
	private String content;
		
	/**
	 * Reply to content
	 */
	
	private String reply;
				
	
	/**
	 * setting:用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 *get:用户id
	 */
	public Long getUserid() {
		return userid;
	}
				
	
	/**
	 * setting:head sculpture
	 */
	 
	public void setAvatarurl(String avatarurl) {
		this.avatarurl = avatarurl;
	}
	
	/**
	 *get:head sculpture
	 */
	public String getAvatarurl() {
		return avatarurl;
	}
				
	
	/**
	 * setting:Username
	 */
	 
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/**
	 *get:Username
	 */
	public String getNickname() {
		return nickname;
	}
				
	
	/**
	 * setting:No.Comment content
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 *get:No.Comment content
	 */
	public String getContent() {
		return content;
	}
				
	
	/**
	 * setting:Reply to content
	 */
	 
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	/**
	 *get:Reply to content
	 */
	public String getReply() {
		return reply;
	}
			
}
