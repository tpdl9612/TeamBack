package com.example.back.common;

public interface ResponseMessage {

    String SUCCESS = "SUCCESS.";

    String VALIDATION_FAIL = "Validation failed.";
    String DUPLICATE_ID = "Duplicate id.";
    String DUPLICATED_EMAIL = "Duplicate Email";
    String DUPLICATED_NICKNAME = "Duplicate Nickname";

    String SIGN_IN_FAIL = "Login information mismatch.";
    String CERTIFICATION_FAIL = "Certification failed.";

    String MAIL_FAIL = "Mail send failed";
    String DATABASE_ERROR = "Database error.";

    String NOT_EXISTED_USER = "Not Existed User";
    String NOT_EXISTED_PRODUCT = "Not Existed Product";
    String NOT_EXISTED_ORDER = "Not Existed Order";
    String NOT_EXISTED_ANSWER = "Not Existed Answer";
    String NOT_EXISTED_QUESTION = "Not Existed Question";
    String NOT_EXISTED_PAYMENT = "Not Existed Payment";
    String WRONG_PASSWORD = "Wrong Password";
    String DO_NOT_HAVE_PERMISSION = "Do Not Have Permission";

    String DUPLICATED_PRODUCT_ID = "Duplicate Product Id";
    String DUPLICATED_PRODUCT = "Duplicate Product";
    String DUPLICATED_ORDER = "Duplicate Order";
    String EMPTY_ORDER = "Empty Order";
}
