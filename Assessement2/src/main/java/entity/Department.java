package entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Department {
    private Long id;
    private String name;
    private String status;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Department users;

}
