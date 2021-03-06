/**
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.portlets.FeedbackPortlet.web;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class FeedbackValidator implements Validator {
	
	private int feedbackMaxChars;
	
	public void setFeedbackMaxChars(int feedbackMaxChars)
	{
	    this.feedbackMaxChars = feedbackMaxChars;
	}
    
    public boolean supports(Class givenClass) {
	    return givenClass.equals(SubmitFeedbackForm.class);
	}	
	
	public void validate(Object object, Errors errors) {
	    SubmitFeedbackForm form = (SubmitFeedbackForm) object;
	    if(form.getFeedback().length()>feedbackMaxChars){
	        errors.rejectValue("feedback","error.feedback");
		}		
	}	
}
