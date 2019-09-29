package com.sample.shop.common.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * To hold the exception message title and description.
 *
 * @author Ammarah Shakeel
 */

@Getter @Setter @NoArgsConstructor
class Message {
    private String title;
    private String text;
    private MessageType messageType;

    Message(String title, String text, MessageType messageType) {
        this.title = title;
        this.text = text;
        this.messageType = messageType;
    }
}
