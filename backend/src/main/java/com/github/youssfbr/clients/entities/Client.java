package com.github.youssfbr.clients.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "tb_client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String firstName;

    @Column(nullable = false, length = 20)
    private String lastName;

    @Column(length = 14, unique = true)
    private String cpf;

    private LocalDate birthDate;

    @Column(nullable = false, updatable = false)
    private Instant registerDate;

    // TO DO ADDRESS

    // CONTACT
    @Column(length = 20)
    private String phone;

    @Column(length = 40, unique = true)
    private String email1;

    @Column(columnDefinition = "TEXT")
    private String note;


    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    @ToString.Exclude
    private List<Phone> phones;

    @PrePersist
    private void prePersist() {
        setRegisterDate(Instant.now());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Client client = (Client) o;
        return id != null && Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
