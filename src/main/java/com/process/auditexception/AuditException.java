/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.process.auditexception;

/**
 *
 * @author crixx
 */ 
public class AuditException extends Exception {
    public AuditException(String message) {
        super(message);
    }

    public AuditException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuditException(Throwable cause) {
        super(cause);
    }

}
