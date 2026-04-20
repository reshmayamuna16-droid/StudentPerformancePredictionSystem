package ReshmaApplication.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    private Integer id;

    private String name;
    private String department;

    private Integer english;
    private Integer hindi;
    private Integer physics;
    private Integer math;
    private Integer chemistry;
    private Integer science;
}