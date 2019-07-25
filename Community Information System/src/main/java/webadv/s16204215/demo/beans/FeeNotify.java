package webadv.s16204215.demo.beans;

import java.util.Date;

/**
 * @author jm,jsh
 *
 */
public class FeeNotify {
	private int notify_id;
	private int owner_id;
	private String title;
	private String content;
	private Date time;
	public int getNotify_id() {
		return notify_id;
	}
	public void setNotify_id(int notify_id) {
		this.notify_id = notify_id;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
