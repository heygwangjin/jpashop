package jpabook.jpashop.domain.item;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@DiscriminatorValue("B")
@Entity
public class Book extends Item {

    private String author;
    private String isbn;

    @Builder
    public Book(String author, String isbn) {
        this.author = author;
        this.isbn = isbn;
    }
}
