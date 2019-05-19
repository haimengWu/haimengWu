package com.HaimengWu.composite;

import com.HaimengWu.beans.Player;
//��Ʒ�ӿ�
public abstract class Item {
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public abstract void use(Player player);
}
