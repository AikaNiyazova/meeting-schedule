package kg.megalab.meetingschedule.model.entity;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_organization")
public class Organization extends AbstractPersistable<Long> {

    @Column(name = "organization_name", nullable = false, unique = true) //TODO: unique ???
    String organizationName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) //TODO: cascade ???
    @JoinColumn(name = "parent_organization_id") //TODO: referencedColumnName = "id" ???
    @ToString.Exclude
    Organization parentOrganizationId;

}
