package readfile.bean;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
    private int id;
    private String name;
    private int salary;
}
