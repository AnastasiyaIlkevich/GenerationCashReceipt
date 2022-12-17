package com.clevertec.generationCashReceipt.exceptions;




public class ProductNotFoundException extends RuntimeException {

    private static final String ID_EXCEPTION = "This product was not found! It is recommended to check the validity of the ID.";

    public ProductNotFoundException() {
        super(ID_EXCEPTION);
    }
}
