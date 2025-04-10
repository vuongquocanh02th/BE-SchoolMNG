package com.school_management_api.model;

import com.school_management_api.model.type.EPaymentStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentRecord student;

    @Enumerated(EnumType.STRING)
    private EPaymentStatus status = EPaymentStatus.CHUA_THANH_TOAN;
}