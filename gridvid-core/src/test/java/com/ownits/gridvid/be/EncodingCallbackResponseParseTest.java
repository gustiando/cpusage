package com.ownits.gridvid.be;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details.
 * 
 * @author gumatias <gustavo@ownits.com>
 *
 */
public class EncodingCallbackResponseParseTest {
	
	private static final String SAMPLE_REQUESTS_PROPERTIES = "sample-requests.properties";
	
	private Properties mSampleRequests;
	private Gson mGson;
	
	@Before
	public void setup() throws Exception {
		mSampleRequests = new Properties();
		mSampleRequests.load(this.getClass().getResourceAsStream(SAMPLE_REQUESTS_PROPERTIES));
		mGson = new GsonBuilder().create();
	}

	@Test
	public void shouldParseTest_1() throws Exception {
		EncodingCallbackResponse oResponse = mGson.fromJson(mSampleRequests.get("5").toString(), EncodingCallbackResponse.class);
		
		assertNotNull(oResponse);
		assertNotNull(oResponse.getJobId());
		assertNotNull(oResponse.getExitCode());
		assertNotNull(oResponse.getProcTime());
		assertNotNull(oResponse.getTotalTime());
		
		assertEquals("50ecb7dc17c510430b000194", oResponse.getJobId());
		assertEquals(Integer.valueOf(0), oResponse.getExitCode());
		assertEquals("123", oResponse.getProcTime());
		assertEquals("321", oResponse.getTotalTime());
		
		String oJson = mGson.toJson(oResponse);
		assertNotNull(oJson);
	}
	
}