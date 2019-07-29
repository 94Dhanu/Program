package com.bridgelabz.fundoo.user.service;

import io.swagger.models.RefResponse;

public class ResponseHelper {
	public static RefResponse statusResponse(int code, String message) {
		RefResponse statusResponse = new RefResponse();
		statusResponse.setStatusMessage(message);
		statusResponse.setStatusCode(code);
		return statusResponse;
	}
}
