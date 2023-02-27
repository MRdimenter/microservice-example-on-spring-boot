package org.example.notification;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String message;
    String customerName;
    String sender;

}
