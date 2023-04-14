package com.ibm.apple.operations.xpaths;

public final class PolicyXpaths {
	
	private PolicyXpaths() {
		
	  }

	 public static final String POLICY_TAB = "//*[@id=\"master_header\"]//*[@id=\"tabs_menu\"]//*[@name=\"NAV_EMC_SUITE_SECURE\"]";
	 
	 public static final String ADD_POLICY_BUTTON = "//*[@id=\"create_new_pol\"]";
	 
	 public static final String POLICY_NAME_FIELD = "//input[contains(@id,'configurationName')]";
	 
	 public static final String POLICY_TYPE = "//select[contains(@id,'orgPackages')]";
	 
	 public static final String POLICY_START_FROM = "//select[contains(@id,'configCategory')]";
	 
	 public static final String CONTINUE_BUTTON = "//input[contains(@id,'save')]";
	 
	 public static final String POLICY_NAME_ASSERTION = "//span[contains(@class,'policy-name')]";
	 
	 public static final String DEVICE_SETTINGS_TAB = "//span[text()='Device Settings']";
	 
	 public static final String PASSCODE_PAYLOAD_TAB = "//a[contains(@id,'PASSCODE')]";
	 
	 public static final String EDIT_BUTTON = "//button[contains(@id,'policy-edit-button')]";
	 
	 public static final String CONFIGURE_PASSCODE_POLICY_CHECKBOX = "//input[(@id='iOS.requirePasscode')]";
	 
	 public static final String ENFORCE_PASSCODE_ON_MOBILE_DEVICE_CHECKBOX = "//input[(@id='iOS.requirePasscodeOnDevice')]";
	 
	 public static final String NEXT_BUTTON = "//button[text()='Next']";
	 
	 public static final String PUBLISH_BUTTON = "//button[text()='Publish']";
	 
	 public static final String CONFIRM_BUTTON = "//button[text()='Confirm']";
	 
	 public static final String PASSWORD = "//input[@id='password']";
	 
	 public static final String CHECK_PUBLISH = "//span[text()='Published']";


}
