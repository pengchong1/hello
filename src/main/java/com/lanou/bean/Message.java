package com.lanou.bean;

public class Message {
    private Integer id;

    private Integer up;

    private Integer down;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUp() {
        return up;
    }

    public void setUp(Integer up) {
        this.up = up;
    }

    public Integer getDown() {
        return down;
    }

    public void setDown(Integer down) {
        this.down = down;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	@Override
	public String toString() {
		return "Message [id=" + id + ", up=" + up + ", down=" + down + ", content=" + content + "]";
	}
}