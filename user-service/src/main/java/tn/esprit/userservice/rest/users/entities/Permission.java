package tn.esprit.userservice.rest.users.entities;

import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name="permissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {

    public Permission(Long id, String permission) {
        this.id = id;
        this.permission = permission;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="id")
    private Long id;

    @Column(name="permission", nullable = false)
    private String permission;

    // enabled as default
    @Column(name="enabled")
    private boolean enabled = true;

    @Column(name="note")
    private String note;

}
