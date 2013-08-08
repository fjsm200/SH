package com.seeyon.v3x.utils;

import java.util.UUID;

public class UUIDLong {
	public static Long getLong(){
		return UUID.randomUUID().getMostSignificantBits();
	}
}
