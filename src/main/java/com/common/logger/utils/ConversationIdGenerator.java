package com.common.logger.utils;

import java.util.UUID;

public class ConversationIdGenerator {

	private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

	private ConversationIdGenerator() {
		super();
	}

	public static String getConversationId() {
		if (threadLocal.get() != null) {
			return threadLocal.get();
		} else {
			String uuid = UUID.randomUUID().toString();
			threadLocal.set(uuid);
			return uuid;
		}
	}
}
