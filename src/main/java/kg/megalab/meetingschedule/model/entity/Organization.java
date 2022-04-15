package kg.megalab.meetingschedule.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_organization")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

    @Column(name = "organization_name", nullable = false, unique = true)
    String organizationName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_organization_id")
    @ToString.Exclude
    Organization parentOrganization;

}
