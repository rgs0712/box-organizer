package br.com.rgs.boxorganizer.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Table(name= "role")
public class Role {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long roleId;

    private String name;

    @Getter
    public enum Values {
        ADMIN(1),
        USER(2),
        FRIEND(3);

        long roleId;

        Values(long roleId) {
            this.roleId = roleId;
        }

    }

}
