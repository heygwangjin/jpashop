package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable // JPA의 내장 타입
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // JPA 스펙상 엔티티, 임베디드 타입은 자바 기본 생성자를 설정해야 한다.
    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
