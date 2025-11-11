package api.models.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponse {
    Integer customerId;
    String firstName;
    String lastName;
    LocalDate birthDate;
    String finCode;
    String phoneNumber;
    String email;
    LocalDate registrationDate;
    String status;
}
