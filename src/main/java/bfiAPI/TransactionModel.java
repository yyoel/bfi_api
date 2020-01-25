package bfiAPI;

import lombok.Data;

import  javax.persistence.Entity;
import  javax.persistence.GeneratedValue;
import  javax.persistence.Id;
import  java.util.Date;

// @Data
// @Entity
public class TransactionModel {

    public Date transactionTime;
    public int productId;
    public String bodyMessage;
}