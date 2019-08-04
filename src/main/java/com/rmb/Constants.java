package com.rmb;

public final class Constants {

	public static class Permissions {

		public static final String VIEW_OWN_RESOURCE_INFORMATION = "VIEW_OWN_RESOURCE_INFORMATION";
		public static final String VIEW_ANY_RESOURCE_INFORMATION = "VIEW_ANY_RESOURCE_INFORMATION";

		public static final String TRANSFER_FROM_OWN_ACCOUNT = "TRANSFER_FROM_OWN_ACCOUNT";
		public static final String TRANSFER_FROM_ANY_ACCOUNT = "TRANSFER_FROM_ANY_ACCOUNT";

		public static final String CREATE_USER = "CREATE_USER";
		public static final String CLOSE_ANY_USER = "CLOSE_ANY_USER";

		public static final String CREATE_OWN_ACCOUNT = "CREATE_OWN_ACCOUNT";
		public static final String CREATE_ACCOUNT_FOR_ANY_USER = "CREATE_ACCOUNT_FOR_ANY_USER";

		public static final String CLOSE_OWN_ACCOUNT = "CLOSE_OWN_ACCOUNT";
		public static final String CLOSE_ACCOUNT_FOR_ANY_USER = "CLOSE_ACCOUNT_FOR_ANY_USER";

	}

	public static final class Status {

		public static final String ACTIVE = "ACTIVE";
		public static final String CLOSED = "CLOSED";
	}

	public static final class Currency {

		public static final String USD = "USD";
		public static final String SEK = "SEK";
		public static final String INR = "INR";
		public static final String GBP = "GBP";
	}

	public static final class Country {

		public static final String US = "US";
		public static final String Sweden = "Sweden";
		public static final String India = "India";
	}

	public static final class CountryCode {

		public static final String US = "US";
		public static final String Sweden = "SE";
		public static final String India = "IN";
	}

	public static final class AccountType {
		public static final String savings = "savings";
		public static final String current = "current";
	}

	public static final class AccountTypeCode {
		public static final String savings = "1";
		public static final String current = "2";
	}
}