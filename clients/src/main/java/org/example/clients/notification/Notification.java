package org.example.clients.notification;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Notification {

    long id;
    String message;

}
